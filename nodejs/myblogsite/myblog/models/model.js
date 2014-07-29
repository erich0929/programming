var mongoskin = require ('mongoskin');
var db = mongoskin.db ('mongodb://localhost:27017/myblogsite');
var collection = db.collection ('articles');
var before_auth = db.collection ('before_auth');
var after_auth = db.collection ('after_auth');

before_auth.ensureIndex ({'created_at' : 1}, {expireAfterSeconds : 20}, function (err) {
	if (err) { console.log (err); }
});
before_auth.ensureIndex ('username', {unique : true}, function (err) {
	if (err) { console.log (err); }
});

after_auth.ensureIndex ('username', {unique : true}, function (err) {
	if (err) { console.log (err); }
});

var session_db = mongoskin.db ('mongodb://localhost:27017/hgtech-session');


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
	};
	
	smtpTransport.sendMail (mailOption, function (err, res) {
		if (err) {
			console.log (err);
		} else {
			console.log ("Complete to send email to " + obj.to);
		}
	});
};

exports.collection = collection;
exports.ObjectID = mongoskin.ObjectID;
exports.db = db;
exports.beforeAuth_db = before_auth;
exports.afterAuth_db = after_auth;

exports.session_db = session_db;

exports.is_unique_username = function (username, callback) {
	var bool;
	before_auth.findOne ({'username' : username}, function (err, before) {
		after_auth.findOne ({'username' : username}, function (err, after) {
			if (!before && !after) {
				callback (bool = true);
			} else {
				callback (bool = false);
			}
		});
	});
};
exports.sendmail = sendmail;
