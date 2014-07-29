var nodemailer = require ('nodemailer');

var smtpTransport = nodemailer.createTransport ("SMTP", {
	service : "Gmail",
	auth : {
		user : "erich092929@gmail.com",
		pass : "/^\\s*$/drnrmf0"
	}
});

var mailOption = {
	from : "<erich092929@gmail.com>",
	to : "erich0929@naver.com",
	subject  : "Hello world",
	text : "Hello world, you know.",
	//html : "<b>Hello world, I'm fine</b>"
};

smtpTransport.sendMail (mailOption, function (err, res) {
	if (err) {
		console.log (err);
	} else {
		console.log ('Message sent:' + res.message);
	}
});

console.log ('next');
