const fs=require('fs');
var readStream= fs.createReadStream(__dirname+"/ghettobrothers.txt",{highWaterMark: 1});

readStream.on('data',function(chunk){

    console.log("new piece recieved");
    console.log(chunk);
});