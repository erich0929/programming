var Token = require ('./token.js');
var TokenSet = require ('./tokenset.js');

var Scanner = function (tokens, expression) {
	var tokens = tokens;
	var expression = expression;
	var stack = expression.split (/\s+/).reverse ();

	this.advance = function () {
		var top = stack.pop ();
		for (var i = tokens.iterator (); i.hasNext (); ) {
			var t = i.next ();
			var res;
			if (res = t.match (top)) {
				currentToken = t;
				if (res [2]) stack.push (res [2]);
				break;
			}
		}
		return t;
	};

	this.match = function (candidate) {
		return currentToken === candidate;
	};
	this.show = function () {
		console.log (stack);
	};
	var currentToken = this.advance ();
};

//paser code
var tokens = new TokenSet ();
var SUM = tokens.create (/^(sum)(.*)/i);
var LP = tokens.create (/^(\()(.*)/i);
var DIGIT = tokens.create (/^([0-9]+)(.*)/);
var PLUS = tokens.create (/^(\+)(.*)/);
var RP = tokens.create (/^(\))(.*)/);

var expression = 'sum( 1 + 1 )';
var scanner = new Scanner (tokens, expression);

scanner.show ();
