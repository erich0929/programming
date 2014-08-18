#!/usr/bin/node
var request = require ('/home/erich0929/programming/nodejs/bus/node_modules/request');
var colors = require ('/home/erich0929/programming/nodejs/bus/node_modules/colors');

request ('http://bus.gjcity.net/busmap/lineStationArriveInfoList?BUSSTOP_ID=' + process.argv [2], function (err, res, body) {
		data = JSON.parse (body);
		//console.log ('--------------------------------');
		for (var i = 0; i < data.list.length; i++) {
			console.log ('-----------------------------'.rainbow);
			console.log ('버스번호'.yellow.inverse + " : " + data.list [i].LINE_NAME);
			console.log ('현재위치'.yellow.inverse + " : " + data.list [i].BUSSTOP_NAME);
			console.log ('예상시간'.yellow.inverse + " : " + data.list [i].REMAIN_STOP);
			console.log ('현재속도'.yellow.inverse + " : " + data.list [i].SPEED);
			console.log ('-----------------------------'.rainbow);
		}
		//console.log ('--------------------------------');
	//console.log (data.list);
});
