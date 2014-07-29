var mongoskin = require ('mongoskin');
var db = mongoskin.db ('mongodb://localhost:27017/myblogsite');
var collection = db.collection ('articles');

collection.findOne ({title : /^Node/i} , function (err, article) {
	var i = (article.comments) ? article.comments.length : 0;
	console.log (i);
});
