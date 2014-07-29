var parent_ = function () {
	var local_parent = 0;
	var local_method = function () { return local_parent; }
	return { parent_method : local_method, parent_value : local_parent };
}

var child = (function () {
	var child = parent_ ();
	var local_child = 10;
	child.child_method = function () { return local_child; }
	child.parent_method = function () { console.log ("parent method overrided !"); return this.parent_value; }
	return child;
}) ();

console.log (child.parent_method ());
console.log (child.child_method ());
