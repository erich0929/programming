var email     = require("emailjs/email");
var server     = email.server.connect({
	   user:    "erich0929@naver.com", 
	   password:"/^\s*$/dspdlqj0", 
	   host:    "smtp.naver.com", 
	   port : 465,
	   ssl:     true
});

// send the message and get a callback with an error or details of the message that was sent
server.send({
	text:    "i hope this works", 
	from:    "you <username@gmail.com>", 
	to:      "someone <someone@gmail.com>, another <another@gmail.com>",
	cc:      "else <else@gmail.com>",
	subject: "testing emailjs"
}, function(err, message) { console.log(err || message); });

