var limit = 20;
var i;
var j;
var stri;
for ( i = limit; i >0; i --) {
    for (j = 0; j <= limit; j ++) {
         stri += (i == j)? "*":" ";
    }
    console.log(stri);
    stri ="";
}