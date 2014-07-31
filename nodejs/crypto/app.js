var crypto = require ('crypto');
var current_date = (new Date ()).valueOf ().toString ();
var random = Math.random ().toString ();
console.log ("current date : " + current_date);
console.log ("random : " + random);

var id = crypto.createHash ('sha1').update (current_date + random).digest ('base64');
console.log (id);
for (i=0;i<20;i++) {
var other = crypto.randomBytes (2).toString ('base64');
other = crypto.createHash ('sha1').update (other).digest ('base64');
console.log (other);
}
