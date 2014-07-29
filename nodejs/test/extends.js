var parent = function () { console.log ("I'm a parent.\n"); };
var parentInst = new parent ();
parent.prototype.parent = parent ;
parent.prototype.do_something = function () { console.log ("I'm doing something.\n"); };
var child = new parentInst.parent ();
child.prototype.sum  = function () { console.log ("I'm caculating.\n"); };
child.do_something ();
