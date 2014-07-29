var mongoskin = require ('mongoskin');
var db = mongoskin.db ('mongodb://localhost:27017/ttl_test');
var collection = db.collection ('ttl_collection');
collection.ensureIndex ({"Date" : 1}, {'expireAfterSeconds' : 10}, function (err) {
	if (err) console.log (err);
});

collection.ensureIndex ('content', {'unique' : true}, function (err) {
	if (err) console.log (err);
});

collection.insert ({'Date' : new Date (), 'content' : 'some_sentence'}, function (err,res) {
	var ele = res [0];
	console.log (ele._id);
});

var startDate = new Date ();
var count;
collection.count (function (err, res) {
	if (err) throw err;
	console.log (res);
	count = res;
});
console.log ('Documents : ' + count + '<' + (new Date () - startDate) + 'ms>');
