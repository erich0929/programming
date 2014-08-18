var request = require ('request');
var mongo = require ('mongoskin');
var db = mongo.db ('mongodb://localhost:27017/GJBusSystem');
var repository = db.collection ('lines');

var iterator = 0;
var limitNum = 9999;

while (iterator <= limitNum) {
	var url = 'http://bus.gjcity.net/guide/stnguide/stnGuideList?LINE_ID=' + iterator;
	console.log ("Let's collecting bus line information.");
	request (url, function (err, res, body) {
			console.log ('------------------------------------');
			if (err) throw err;
			var linedata = JSON.parse (body);
			if (linedata.list.length !== 0) {
				for (var i=0; i < linedata.list.length; i++) {
					console.log ('line number : ' + iterator);
					console.log ('trying to insert info to the Database : ');
					linedata.list [i].line_num = iterator;
					console.log ('info : ');
					console.log (linedata.list [i]);
					repository.insert (linedata.list [i], function (err) {
						if (err) {
							console.log (err);
						} else {
							console.log ('Database response : Query O.K');
						}
					});
				}
			} else {
				console.log ('');
			}		
	});
	iterator ++;
}
