function closer () {
	var local_x = 0;
	function get () { return local_x ; }
	function set (x) { local_x = x ; return local_x;}
	return { get_x : get, set_x : set };
}

closer.prototype.setlocal = function (x) { this.set_x (x); this.get_x () };

var instance = closer ();
console.log (instance.get_x ());
console.log (instance.set_x (10));
console.log (instance.setlocal (20)); // 에러, new 연산자로 생성하지 않고 함수 호출만으로 인스턴스를 생성했기 때문에 프로토타입 상속이 이루어 지지 않았다.
