var db = require ('mongoskin').db ('mongodb://localhost:27017/myblogsite');
var collection = db.collection ('articles');
collection.count (function (err, count){ console.log (count);})
collection.find ({}).sort ({ 'saved_at' : -1}).skip (1).limit (5).toArray (function (err, result) {
	console.log (result.length);	
});
