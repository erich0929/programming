var mongodb = require ('mongodb');
var server = require ('mongodb').Server;
var MongoClient = mongodb.MongoClient;

var mongoclient = new MongoClient (new server ('localhost', 27017, {'native_parser' : true }));

mongoclient.open (function (err, mongoclient) {});
var db = mongoclient.db ('myblogsite');

db.collection ('articles').find ({}).each (function (err, doc) {
	console.log (doc);
});

