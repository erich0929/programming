function Coffee (price) {
	this.price = price || 100;
}

Coffee.prototype.getPrice = function () {
	return this.price;
}

Coffee.additive = {};
Coffee.additive.mocha = {
	getPrice : function () {
		var price = this.uber.getPrice ();
		return price + 10;
	}
};

Coffee.additive.syrap = {
	getPrice : function () {
		var price = this.uber.getPrice ();
		return price + 0;
	}
};

Coffee.prototype.add = function (additive) {
	var F = function () {}, newObj, 
	overrides = this.constructor.additive [additive], i;
	F.prototype = this;
	newObj = new F ();
	newObj.uber = this;
	for (i in overrides) {
		if (overrides.hasOwnProperty (i)) {
			newObj [i] = overrides [i];
		}
	}
	return newObj;
}

var coffee = new Coffee (120);
coffee = coffee.add ('mocha');
coffee = coffee.add ('syrap');
console.log (coffee.getPrice ());
