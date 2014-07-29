var global = {};

(function ($) {
	private_x = 0;
	$.set_x = function () { return ++ private_x;}
}) (global);

console.log (global.set_x ());
console.log (global.set_x ());

