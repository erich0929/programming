function Classfunc () {
	this.a = 1;
	this.b = 1;
	
	return { 'c' : 2, 'd' : 2 };
};

var instance = new Classfunc ();
console.log (instance.a + ", " + instance.b);
