var eObj = require ('./eventObj.js');
eObj.obj.on ('test', function () {
	console.log ('test');
});
//exports.obj.prototype.do_something = function () { console.log ("doing something\n"); };
console.log (eObj.obj.sum (5,6));
eObj.obj.emit ('test');
