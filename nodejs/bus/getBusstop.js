var mongo = require ('/home/erich0929/programming/nodejs/bus/node_modules/mongoskin');
var db = mongo.db ('mongodb://localhost:27017/GJBusSystem');
var repository = db.collection ('lines');

var arr = [];
var arr1 = [];
repository.find ({'BUSSTOP_NAME' : process.argv [2]}).toArray (function (err, res) {
	if (err) throw err;
	for (var i=0; i < res.length; i++) {
		arr.push (res [i].BUSSTOP_ID);
		arr1.push (res [i].NEXT_BUSSTOP);
	}	
	//console.log( arr);
	var out = arr.unique ();
	var out1 = arr1.unique ();
	for (i = 0; i < out.length ; i++) {
		console.log (out [i] + " " + out1 [i]);
	}
	db.close ();
});;

Array.prototype.unique = function() {
	var unique = [];
	for (var i = 0; i < this.length; i++) {
		if (unique.indexOf(this[i]) == -1) {
			unique.push(this[i]);
		}
	}
	return unique;
};
