let http = require('http')
let data = ""
let options = {
  host: '127.0.0.1',
  port: 3000,
  path: '/'
}

let request = http.get(options, function (res) {
  res.on('data', function (chunk) {
    data += chunk
  })
  res.on('end', function () {
    data = JSON.parse(data)
    console.log(data)
  })
  res.on('error', function (e) {
    console.log("There was an error: " + e.message)
  })
})