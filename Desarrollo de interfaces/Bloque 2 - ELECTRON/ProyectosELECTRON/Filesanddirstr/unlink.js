const { fstat } = require("fs");

const fs = require("fs");

fs.unlink("./stuff/writeMe.txt",function(){
    fs.rmdir("stuff",function(err){

        if(err){    throw err+ "borrando carpeta stuff";
    }
    });

},function(err){

    if(err){
        throw err+"borrado archivo stuff/writeMe.txt";
    }
})

