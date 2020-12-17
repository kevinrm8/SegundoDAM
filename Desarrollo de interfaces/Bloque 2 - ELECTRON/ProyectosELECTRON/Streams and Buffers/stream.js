
const fs = require ('fs');

var miStream = fs.createReadStream(__dirname+'/ghettobrothers.txt');
var miStreamEscr = fs.createWriteStream(__dirname+'/copia');

miStream.pipe(miStreamEscr);