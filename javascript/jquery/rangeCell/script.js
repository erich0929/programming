$ (function () {
	y = $ ("table tr").length;
	x = $ ("table td").length / y;
	$ ("table td").mousedown (rangeMouseDown)
	.mouseup (rangeMouseUp)  
	.mousemove (rangeMouseMove);
var dragStart = 0;
var dragEnd = 0;
var isDragging = false;

function rangeMouseDown (e) {
	if (IsRightClicked (e)) {
		return false;
	} else {
		var allCells = $ ("table td");
		dragStart = allCells.index ($ (this));
		isDragging = true;
		e.preventDefault ();
		document.documentElement.onselectstart = function () {
			return false;
		};
	}
};

function rangeMouseUp (e) {
	if (IsRightClicked (e)) {
		return false;
	} else {
		dragEnd = $ ('table td').index ($ (this));
		isDragging = false;
		selectRange ();
		document.documentElement.onselectstart = function () {
			return true;
		};
	}

};

function rangeMouseMove (e) {
	if (isDragging) {
		dragEnd = $ ('table td').index ($ (this));
		selectRange ();
	}
};

function selectRange() {
	$("table td").removeClass('selected');
	starty = parseInt (dragStart / x);
	startx = dragStart - starty * x;
	endy = parseInt (dragEnd / x);
	endx = dragEnd - endy * x;
	for (var i = Math.min (startx, endx) ; i <= Math.max (startx, endx); i++) {
		for (var j = Math.min (starty, endy) ; j <= Math.max (starty, endy); j ++) {
			$ ($ ('table td').get (j * x + i)).addClass ('selected');
		}
	}
}

function IsRightClicked (e) {
	if (e.which) {
		return (e.which == 3);
	} else if (e.button) {
		return (e.button == 2);
	}
};
});
