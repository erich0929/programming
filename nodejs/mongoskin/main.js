var db = require ('mongoskin').db ('mongodb://localhost:27017/myblogsite');
db.collection ('articles').findOne ({_id : 'foo'}, function (err, result) {
	if (!result) console.log (!result);
});
