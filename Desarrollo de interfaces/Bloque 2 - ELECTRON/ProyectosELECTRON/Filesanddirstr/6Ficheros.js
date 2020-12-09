const fs = require("fs");
const { brotliCompressSync } = require("zlib");
/*
fs.readFile("./readme.txt","utf8",(err,data)=>{

if(err)throw err;
console.log("Reading asynchronous file");
console.log(data);

fs.writeFile("./writeme.txt",data,(err)=>{
if(err) throw err;
err
? console.log(err)
: console.log("File written correctly");
})

});
*/
fs.rename("readme.txt","leeme.txt",(err)=> {

if(err) throw err;
console.log("Nombbre Editado Satisfactoriamente");
});
fs.stat("leeme.txt",(err,stats)=>{
    if(err) throw err;
    console.log(stats);
})