console.log (this.module === module);
console.log (this.require === require);
console.log (exports === module.exports);
var a = 1;
var bool = (this === global);
console.log (GLOBAL === this);
