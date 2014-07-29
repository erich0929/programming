var mongoskin = require ('mongoskin');
var db = mongoskin.db ('mongodb://localhost:27017/callback_test');
var before_auth = db.collection ('before');
var after_auth = db.collection ('after');

var is_unique_username = function (username, callback) {
	var bool = 'fake';
	before_auth.findOne ({'username' : username}, function (err, before) {
		bool = 'fake fake';
		after_auth.findOne ({'username' : username}, function (err, after) {
			if (!before && !after) {
				//console.log (bool = true);
				callback (bool = true);
			} else {
				//console.log (bool = false);
				callback (bool = false);
			}
		});
	});
};

function callback (bool) {
	if (bool) {
		console.log ('SendMail ...');
	} else {
		console.log ('Redirect ...');
	}
};

is_unique_username ('erich0929', callback);
is_unique_username ('ksh0728', callback);
is_unique_username ('kker0929', callback);
