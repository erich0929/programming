//String.prototype.hashCode = function(){
//	var hash = 0;
//	if (this.length == 0) return hash;
//	for (i = 0; i < this.length; i++) {
//		char = this.charCodeAt(i);
//		hash = ((hash<<5)-hash)+char;
//		hash = hash & hash; // Convert to 32bit integer
//	}
//	return hash;
//}


var arr = [{name : '김광로', value : 30}, {name : '김광로', value : 20},
			{name : '김수혜', value : 20}, {name : '김수혜', value : 30}];

var out = [];
//var out  = {name : "김수혜"};
//console.log (out ["name"]);

for (var i = 0; i < arr.length ; i ++) {
	out [Object.prototype.toString (arr [i].value)] = arr [i];
}

//console.log ("김광로".hashCode ());
console.log ('-------');
console.log (arr);
console.log ('-------');
console.log (Number.prototype.toString (1));
