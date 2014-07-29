var http = require ('http');
var colors = require ('colors');

option = {
	hostname : '127.0.0.1',
	port : 1337,
	path : '/',
	method : 'post'
};
var req = http.request (option, function (res) {
	console.log (res);
});
req.end ();
