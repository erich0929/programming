function Person (name) {
	console.log ("생성자 내부 코드 실행");
	this.name = name; // 생성자 멤버 정의.
};

var mySon = new Person ("달봉이");
console.log (Person.prototype.toString ());
