var mod = require ('./mod.js');
mod ();
console.log (global.foo_global); // mod.js 에서 foo_global 변수가 전역변수로 선언되었으므로 접근할 수 있다.
console.log (global.module_scope); // mod.js 에서 module_scope 변수가 모듈변수 (var)로 선언되었으므로 클로저 함수를 통해서만 접근할 수 있다.
