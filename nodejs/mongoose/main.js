var mongoose = require ('mongoose');
mongoose.connect ('mongodb://localhost:27017/test/');

var db = mongoose.connection;

var Schema = mongoose.Schema;

var persons = mongoose.model ('person', new Schema ({ '_id' : String, 'name' : String}), 'emp');
persons.find ({}, function (err, result) {
	console.log (result);
});

console.log (db.collections.emp);
mongoose.disconnect ();
