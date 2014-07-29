var scareMe = function () {
	console.log ("Boo");
	scareMe = function () {
		console.log ("double Boo");
	};
};

scareMe.property = "properly";
var prank = scareMe;

scareMe.call_ref = "call by ref";

var spooky = {
	boo : scareMe
};

prank (); //Boo
prank (); //Boo
console.log (prank.property); //properly

spooky.boo (); //Boo
spooky.boo (); //Boo
console.log (spooky.boo.property); // properly

scareMe (); //double Boo
scareMe (); //double Boo
console.log (scareMe.property); //undefined
scareMe.property = "new properly";
console.log (scareMe.property); //new properly
prank (); //Boo

console.log (prank.call_ref); //call by ref
console.log (spooky.boo.call_ref); //call by ref
console.log (scareMe.property); //undefined
