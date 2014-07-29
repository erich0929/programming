var Token = require ('./token.js');

//Token 배열을 만들고 Iterator를 반환해주는 자료구조
var TokenSet = function () {
	var members = [];
	this.create = function (spec) {
		var token = new Token (spec);
		members.push (token);
		return token;
	};

	this.match = function (str) {
		var i = members.length - 1;
		while (true) {
			if (members [i].match (str)) break;
			i--;
		}
		return members [i];
	};

	this.getByIndex = function (i) {
		return members [i]
	};

	this.showMembers = function () {
		console.log (members);
	};

	this.iterator = function () {
		var iter = members.length - 1;
		return { hasNext : function () {return iter !== -1;},
				 next : function () {return members [iter--];}
		};
	};
};

module.exports = TokenSet;

//
//var tokens = new TokenSet ();
//var SUM = tokens.create (/^(sum)(.*)/i);
//var LP = tokens.create (/^(\()(.*)/i);
//var DIGIT = tokens.create (/^([0-9]+)(.*)/i);
//var PLUS = tokens.create (/^(\+)(.*)/i);
//var RP = tokens.create (/^(\))(.*)/i);
//
//var expression = 'sum( 1 + 1 )';
//var stack = expression.split (/\s+/).reverse ();
//var currentToken;
//
//function advance () {
//	var top = stack.pop ();
//	console.log (top);
//	for (var i = tokens.iterator (); i.hasNext (); ) {
//		var t = i.next ();
//		console.log (t);
//		var res;
//		if (res = t.match (top)) {
//			currentToken = t;
//			console.log (res);
//			if (res [2]) stack.push (res [2]);
//			break;
//		}
//	}
//};
//
//function match (candidate) {
//	return currentToken === candidate;
//};
//
//advance ();
//console.log (match (SUM));
//console.log (stack);
