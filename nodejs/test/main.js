var anotherfile = require ('./anotherfile.js');
console.log (global.process.mainModule === module); // true
anotherfile (); // false

