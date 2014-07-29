function a () {
	local_x = 0;
}

a.prototype.set = function (x) { this.local_x = x; return x; }
a.prototype.get = function () { return this.local_x; }

var instance = new a ();

console.log (instance.get ());
console.log (instance.set (10));
console.log (instance.local_x); //에러
