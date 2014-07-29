var http = require ('http'),
	express = require ('express'),
	mongoskin = require ('mongoskin'),
	skinstore = require ('connect-mongoskin'),
	cookieParser = require ('cookie-parser'),
	session = require ('express-session'),
	app = express (),
	session_db = mongoskin.db ('mongodb://localhost:27017/session_test');

app.use (cookieParser ());

app.use (session ({
	secret : 'YOUR_SESSION_SECRET',
	cookie : {maxAge : null}, // use session-cookies, not persistant cookies.
	store : new skinstore (session_db)
}));

app.get ('/', function (req, res) {
	console.log (req.session);
	var pre = req.session.value || 0;
	req.session.value = pre + 1;
	res.writeHead (200, {'Content-Type' : 'text/html'});
	res.end ('your persisting data : ' + req.session.value);
});


http.createServer (app).listen (1336);
console.log ('Server listening at 1336 port ...');
