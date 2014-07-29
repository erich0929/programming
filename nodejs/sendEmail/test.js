var nodemailer = require ('nodemailer');
var smtpTransport = nodemailer.createTransport ("SMTP", {
											service : "Gmail",
											auth : {
												user : "erich092929@gmail.com",
												pass : "/^\\s*$/drnrmf0"
											}
});

var sendmail = function (obj) {
	var mailOption = {
		from : "<erich092929@gmail.com>",
		to : obj.to,
		subject : "Welcome to HGTech!",
		html : "<b>Thanks for contact to HGTech blog<br/>If you click <a href=\"" + obj.link + "\">this link</a>, you can be authorized!</b>"
	}
	smtpTransport.sendMail (mailOption, function (err, res) {
		if (err) {
			console.log (err);
		} else {
			console.log ("Complete to send email to " + obj.to);
		}
	});
};

var obj = {};
obj.link = 'http://localhost:3000';
obj.to = 'erich0929@naver.com';
sendmail (obj);
