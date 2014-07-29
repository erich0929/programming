var express = require ('express');
var http = require ('http');
var app = express ();

app.set ('view engine', 'jade');
app.set ('views', './views');

app.use (express.static ('./public'));
app.locals.pretty = true;

app.get ('/', function (req, res) {
	res.render ('index', {
		title: 'Learning Jade'
	});
});

http.createServer (app).listen (3000, function () {
	console.log ('App started');
});
