const http=require('http');
const fs = require('fs');

var server = http.createServer(function(req,res){

    console.log(req.url);
    res.writeHead(200,{'Content-type':'text/plain'});

    var miStreamLectura = fs.createReadStream(__dirname+"/ghettobrothers.txt");
    miStreamLectura.pipe(res);

});

server.listen(3000,'127.0.0.1');