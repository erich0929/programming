function a () {
	var local_x = 7;
	this.get = function () { return local_x; };
	this.set = function (x) { local_x = x; return local_x; };
}

var obj = new a ();
console.log (obj.local_x);
