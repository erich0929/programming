var http = require ('http');

http.createServer (function (req, res) {

	//Build the answer
	var answer = "";
	answer += "Request URL: " + req.url + "\n";
	answer += "Request type: " + req.method + "\n";
	answer += "Request headers: " + JSON.stringify (req.headers) + "\n";

	//Send answer
	res.writeHead (200, {'content-Type': 'text/plain'});
	res.end ('Hello world\n\n' + answer);
}).listen (1337, '127.0.0.1');

console.log ('Server running at http://127.0.0.1:1337/');
