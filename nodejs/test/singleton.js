var global = {};

(function ($) {
	local_x = 0;
	$.singleton_method = function () { return local_x ++; }
}) (global);

(function ($) {
	$.generic_method = function () { var local_x = 0; return local_x ++; }
}) (global);

console.log ("sigleton : ");
console.log (global.singleton_method ());
console.log (global.singleton_method ());
console.log ("generic : ");
console.log (global.generic_method ());
console.log (global.generic_method ());

