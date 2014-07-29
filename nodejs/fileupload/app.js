var http = require ('http');
var express = require ('express');
//var connect = require ('connect');
var bodyParser = require ('body-parser');
var multipart = require ('connect-multiparty');
var fs = require ('fs');
var app = express ();

app.use (bodyParser ());
app.use (multipart ());
app.get ('/', function (req, res) {
	fs.readFile ('index.html', function (err, data) {
		res.writeHead (200, { 'Content-Type' : 'text/html' });
		res.end (data, function (err) {
			console.log (err);
		});
	});
});

app.post ('/upload', function (req, res) {
	fs.readFile (req.files.uploadFile.path, function (err, data) {
		console.log (req.files.uploadFile.path);
		var filePath = __dirname + '/files/' + req.files.uploadFile.name;
		fs.writeFile (filePath, data, function (err) {
			if (err) {
				throw err;
			} else {
				res.json ({message : "imageUrl"});
			}
		});
	});
});

app.get ('/image', function (req, res) {
	if (!req.query.img) res.redirect ('/');
	res.sendfile (__dirname + '/files/' + req.query.img, function (err) {
		res.end (err);
	});
});

app.post ('/ajax', function (req, res) {
	console.log (req.body.textdata);
	res.json ({message : "imageUrl"});
});

http.createServer (app).listen (1337);
console.log ('Server running... port : 1337');
