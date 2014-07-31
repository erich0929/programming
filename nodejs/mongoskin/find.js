var db = require ('mongoskin').db ('mongodb://localhost:27017/myblogsite');
var collection = db.collection ('articles');
collection.find ({_id : new require('mongoskin').ObjectID ('537c5ed5c1bce8980a8b4567') }).toArray (function (err, res) {
	console.log (res.length === 0);
});

collection.findOne ({_id : new require('mongoskin').ObjectID ('537c5ed5c1bce8980a8b4567')}, function (err, res) {
	if (res) {
		console.log ("if (article)");
	} else {
		console.log ("else");
	}
});
