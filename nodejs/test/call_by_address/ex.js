var str1 = "hello world";
var str2 = str1;

str2 = "hello world!!";

console.log (str1); // "hello world"
console.log (str2); // "hello world!!"

var obj1 = {};
var obj2 = obj1;

obj1.str1 = "hello world";
obj2.str2 = obj1.str1;
obj2.str2 = "hello world!!";

console.log (obj1.str1); // "hello world"
console.log (obj2.str1); // "hello world"
