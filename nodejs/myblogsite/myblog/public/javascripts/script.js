$ (function () {
	var screenTop = $ ('.screenboard').offset ().top;
	var sideTop = $ ('.schedule').offset ().top;
//	alert (sideTop.toString () + $(window).scrollTop ().toString ());
	$ (window).scroll (function () {
		if ($ (window).scrollTop () > sideTop - 100) {
			$ ('.schedule').css ({position : 'fixed', width : '200px', display : 'inline', height : '600px', top : '100px'});
		} else {
			$ ('.schedule').css ({position : 'static', width : '200px', display : 'inline', height : '600px'});
		}
	});
	
$ ('.screenboard').css ({position : 'static', 'margin-top' : '0px', 'margin-left' : '0px', 'background-color': 'black', color : 'white', 'padding-left' : '190px', height : '130px', display : 'inline-block' , width : '100%' });

   	$ (window).scroll (function () {
		if ($ (window).scrollTop () > screenTop - 30) {
			$ ('.screenboard').css ({position : 'fixed', top : '0px', left : '0px', 'background-color' : 'black', color : 'white', 'z-index' : '100', 'padding-left' : '190px', height : '130px', display : 'inline-block', width : '100%'});
		} else {
			$ ('.screenboard').css ({position : 'static', 'margin-top' : '0px', 'margin-left' : '0px', 'background-color': 'black', color : 'white', 'padding-left' : '190px', height : '130px', display : 'inline-block', width : '100%' });
		}
	});		
});
