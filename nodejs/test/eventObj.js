var EventEmitter = require("events").EventEmitter;
exports.obj = new EventEmitter  ();
exports.obj.sum = function (x, y) {
	return x + y;
}
