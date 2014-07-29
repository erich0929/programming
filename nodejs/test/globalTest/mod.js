foo_global = "it's meant by global."; // 전역변수로 선언 되었다.
var module_scope = "it's meant by module"; // 모듈변수로 선언 되었다.
module.exports = function () {
	console.log (foo_global);
	console.log (module_scope);
};
