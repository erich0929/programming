var http = require ('http');
var colors = require ('colors');

var options = {
	hostname : '127.0.0.1',
	port : 1337,
	path : '/',
	method : 'POST'
};

var req = http.request (options, function (res) {
	console.log (typeof res.statusCode);
	console.log ('STATUS : '.red + res.statusCode.toString ().red);
	console.log ('HEADERS: '.green + JSON.stringify (res.headers).green);
	res.setEncoding ('utf8');
	res.on ('data', function (chunk) {
		console.log ('BODY : ' + chunk );
	});
});

req.write ('data\n');
req.write ('data\n');
