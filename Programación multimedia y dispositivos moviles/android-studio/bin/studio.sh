#!/bin/sh
#
# ---------------------------------------------------------------------
# Android Studio startup script.
# ---------------------------------------------------------------------
#

message()
{
  TITLE="Cannot start Android Studio"
  if [ -n "`which zenity`" ]; then
    zenity --error --title="$TITLE" --text="$1"
  elif [ -n "`which kdialog`" ]; then
    kdialog --error "$1" --title "$TITLE"
  elif [ -n "`which xmessage`" ]; then
    xmessage -center "ERROR: $TITLE: $1"
  elif [ -n "`which notify-send`" ]; then
    notify-send "ERROR: $TITLE: $1"
  else
    printf "ERROR: $TITLE\n$1\n"
  fi
}

UNAME=`which uname`
GREP=`which egrep`
GREP_OPTIONS=""
CUT=`which cut`
READLINK=`which readlink`
XARGS=`which xargs`
DIRNAME=`which dirname`
MKTEMP=`which mktemp`
RM=`which rm`
CAT=`which cat`
SED=`which sed`

if [ -z "$UNAME" -o -z "$GREP" -o -z "$CUT" -o -z "$MKTEMP" -o -z "$RM" -o -z "$CAT" -o -z "$SED" ]; then
  message "Required tools are missing - check beginning of \"$0\" file for details."
  exit 1
fi

OS_TYPE=`"$UNAME" -s`

# ---------------------------------------------------------------------
# Ensure IDE_HOME points to the directory where the IDE is installed.
# ---------------------------------------------------------------------
SCRIPT_LOCATION=$0
if [ -x "$READLINK" ]; then
  while [ -L "$SCRIPT_LOCATION" ]; do
    SCRIPT_LOCATION=`"$READLINK" -e "$SCRIPT_LOCATION"`
  done
fi

cd "`dirname "$SCRIPT_LOCATION"`"
IDE_BIN_HOME=`pwd`
IDE_HOME=`dirname "$IDE_BIN_HOME"`
cd "$OLDPWD"

# ---------------------------------------------------------------------
# Locate a JDK installation directory which will be used to run the IDE.
# Try (in order): STUDIO_JDK, studio.jdk, ./jre64, JDK_HOME, JAVA_HOME, "java" in PATH.
# ---------------------------------------------------------------------
if [ -n "$STUDIO_JDK" -a -x "$STUDIO_JDK/bin/java" ]; then
  JDK="$STUDIO_JDK"
fi

if [ -z "$JDK" -a -s "$HOME/.AndroidStudio4.0/config/studio.jdk" ]; then
  USER_JRE=`"$CAT" $HOME/.AndroidStudio4.0/config/studio.jdk`
  if [ ! -d "$USER_JRE" ]; then
    USER_JRE="$IDE_HOME/$USER_JRE"
  fi
  if [ -x "$USER_JRE/bin/java" ]; then
    JDK="$USER_JRE"
  fi
fi

if [ -z "$JDK" -a "$OS_TYPE" = "Linux" ] ; then
  BUNDLED_JRE="$IDE_HOME/jre64"
  if [ ! -d "$BUNDLED_JRE" ]; then
    BUNDLED_JRE="$IDE_HOME/jre"
  fi
  if [ -x "$BUNDLED_JRE/bin/java" ] && "$BUNDLED_JRE/bin/java" -version > /dev/null 2>&1 ; then
    JDK="$BUNDLED_JRE"
  fi
fi

if [ -z "$JDK" -a -n "$JDK_HOME" -a -x "$JDK_HOME/bin/java" ]; then
  JDK="$JDK_HOME"
fi

if [ -z "$JDK" -a  -n "$JAVA_HOME" -a -x "$JAVA_HOME/bin/java" ]; then
  JDK="$JAVA_HOME"
fi

if [ -z "$JDK" ]; then
  JDK_PATH=`which java`

  if [ -n "$JDK_PATH" ]; then
    if [ "$OS_TYPE" = "FreeBSD" -o "$OS_TYPE" = "MidnightBSD" ]; then
      JAVA_LOCATION=`JAVAVM_DRYRUN=yes java | "$GREP" '^JAVA_HOME' | "$CUT" -c11-`
      if [ -x "$JAVA_LOCATION/bin/java" ]; then
        JDK="$JAVA_LOCATION"
      fi
    elif [ "$OS_TYPE" = "SunOS" ]; then
      JAVA_LOCATION="/usr/jdk/latest"
      if [ -x "$JAVA_LOCATION/bin/java" ]; then
        JDK="$JAVA_LOCATION"
      fi
    elif [ "$OS_TYPE" = "Darwin" ]; then
      JAVA_LOCATION=`/usr/libexec/java_home`
      if [ -x "$JAVA_LOCATION/bin/java" ]; then
        JDK="$JAVA_LOCATION"
      fi
    fi
  fi

  if [ -z "$JDK" -a -x "$READLINK" -a -x "$XARGS" -a -x "$DIRNAME" ]; then
    JAVA_LOCATION=`"$READLINK" -f "$JDK_PATH"`
    case "$JAVA_LOCATION" in
      */jre/bin/java)
        JAVA_LOCATION=`echo "$JAVA_LOCATION" | "$XARGS" "$DIRNAME" | "$XARGS" "$DIRNAME" | "$XARGS" "$DIRNAME"`
        if [ ! -d "$JAVA_LOCATION/bin" ]; then
          JAVA_LOCATION="$JAVA_LOCATION/jre"
        fi
        ;;
      *)
        JAVA_LOCATION=`echo "$JAVA_LOCATION" | "$XARGS" "$DIRNAME" | "$XARGS" "$DIRNAME"`
        ;;
    esac
    if [ -x "$JAVA_LOCATION/bin/java" ]; then
      JDK="$JAVA_LOCATION"
    fi
  fi
fi

JAVA_BIN="$JDK/bin/java"
if [ -z "$JDK" -o ! -x "$JAVA_BIN" ]; then
  message "No JDK found. Please validate either STUDIO_JDK, JDK_HOME or JAVA_HOME environment variable points to valid JDK installation."
  exit 1
fi

VERSION_LOG=`"$MKTEMP" -t java.version.log.XXXXXX`
JAVA_TOOL_OPTIONS= "$JAVA_BIN" -version 2> "$VERSION_LOG"
"$GREP" "64-Bit|x86_64|amd64" "$VERSION_LOG" > /dev/null
BITS=$?
"$RM" -f "$VERSION_LOG"
test ${BITS} -eq 0 && BITS="64" || BITS=""

# ---------------------------------------------------------------------
# Collect JVM options and IDE properties.
# ---------------------------------------------------------------------
if [ -n "$STUDIO_PROPERTIES" ]; then
  IDE_PROPERTIES_PROPERTY="-Didea.properties.file=$STUDIO_PROPERTIES"
fi

# Android Studio: we allow multiple vmoptions files to be included when determining JVM flags.
VM_OPTIONS=""
for VM_OPTIONS_FILE in \
    $IDE_BIN_HOME/studio$BITS.vmoptions \
    $HOME/.AndroidStudio4.0/config/studio$BITS.vmoptions \
    $IDE_HOME.vmoptions \
    $STUDIO_VM_OPTIONS; do
  if [ -r "$VM_OPTIONS_FILE" ]; then
    VM_OPTIONS_TO_ADD=`"$CAT" "$VM_OPTIONS_FILE" | "$GREP" -v "^#.*"`
    VM_OPTIONS="${VM_OPTIONS:-}${VM_OPTIONS:+	}${VM_OPTIONS_TO_ADD}"  # tab-delimited; see IFS below
    VM_OPTIONS_FILES="${VM_OPTIONS_FILES:-}${VM_OPTIONS_FILES:+,}${VM_OPTIONS_FILE}"
  fi
done

CLASSPATH="$IDE_HOME/lib/bootstrap.jar"
CLASSPATH="$CLASSPATH:$IDE_HOME/lib/extensions.jar"
CLASSPATH="$CLASSPATH:$IDE_HOME/lib/util.jar"
CLASSPATH="$CLASSPATH:$IDE_HOME/lib/jdom.jar"
CLASSPATH="$CLASSPATH:$IDE_HOME/lib/log4j.jar"
CLASSPATH="$CLASSPATH:$IDE_HOME/lib/trove4j.jar"
CLASSPATH="$CLASSPATH:$IDE_HOME/lib/jna.jar"
CLASSPATH="$CLASSPATH:$JDK/lib/tools.jar"
if [ -n "$STUDIO_CLASSPATH" ]; then
  CLASSPATH="$CLASSPATH:$STUDIO_CLASSPATH"
fi

# ---------------------------------------------------------------------
# Run the IDE.
# ---------------------------------------------------------------------
IFS="$(printf '\n\t')"
"$JAVA_BIN" \
  -classpath "$CLASSPATH" \
  ${VM_OPTIONS} \
  "-XX:ErrorFile=$HOME/java_error_in_STUDIO_%p.log" \
  "-XX:HeapDumpPath=$HOME/java_error_in_STUDIO.hprof" \
  -Didea.paths.selector=AndroidStudio4.0 \
  "-Djb.vmOptionsFile=$VM_OPTIONS_FILES" \
  ${IDE_PROPERTIES_PROPERTY} \
  -Didea.platform.prefix=AndroidStudio -Didea.jre.check=true \
  com.intellij.idea.Main \
  "$@"
