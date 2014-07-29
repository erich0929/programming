var mongo = require ('mongodb');
var monk = require ('monk');
var db = monk ('localhost:27017/test');

var emp = db.get ('emp');
//emp.update ({ name : 'kim' }, { '$push' : { city : 'kwang ju' } } );
//emp.find ({}, {skip : 1}).each (function (err, doc) {
//console.log (doc);
//});
emp.find ({}, function (err, docs) {
	for (var doc in docs) {
		console.log (doc);
	}
});
