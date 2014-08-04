function insertAtCaret(text, backend) {
	var backend = backend || 0;
	var txtarea = document.getElementById('hgtech-editor-textarea');
	var scrollPos = txtarea.scrollTop;
	var strPos = 0;
	var br = ((txtarea.selectionStart || txtarea.selectionStart == '0') ? 
			"ff" : (document.selection ? "ie" : false ) );
	if (br == "ie") { 
		txtarea.focus();
		var range = document.selection.createRange();
		range.moveStart ('character', -txtarea.value.length);
		strPos = range.text.length;
	}
	else if (br == "ff") strPos = txtarea.selectionStart;

	var front = (txtarea.value).substring(0,strPos);  
	var back = (txtarea.value).substring(strPos,txtarea.value.length); 
	txtarea.value=front+text+back;
	strPos = strPos + text.length - backend;
	if (br == "ie") { 
		txtarea.focus();
		var range = document.selection.createRange();
		range.moveStart ('character', -txtarea.value.length);
		range.moveStart ('character', strPos);
		range.moveEnd ('character', 0);
		range.select();
	}
	else if (br == "ff") {
		txtarea.selectionStart = strPos;
		txtarea.selectionEnd = strPos;
		txtarea.focus();
	}
	txtarea.scrollTop = scrollPos;
}

(function ($) {
	$.fn.hgtech_editor = function (config) {
		config = config || {}	;
		config.location = config.location || '';
		if (config.location == 'prepend') {
			config.location = this.prepend;
		} else {
			config.location = this.append;
		}

		var locationFunction = config.location;
		locationFunction.call (this, '<div style="display : table;"><div class="hlist"><ul id="hgtech-editor-toolbar"><li><a id="hgtech-editor-toolbar-image">image</a></li><li><a id="hgtech-editor-toolbar-hline">Hline</a></li><li><a id="hgtech-editor-toolbar-bold">Bold</a></li><li><a id="hgtech-editor-toolbar-boxtag">Box</a></li><li><a id="hgtech-editor-toolbar-italic">Italic</a></li><li><a id="hgtech-editor-toolbar-code">Code</a></li><li><a id="hgtech-editor-toolbar-canvas">Canvas</a></li></ul></div><div id="hgtech-editor-description" style="visibility : hidden; overflow : hidden; height : 0; margin : 3px 0; padding : 0px 25px;"></div><textarea style="width : 100%; resize : none;" rows="10" name="source" value="" id="hgtech-editor-textarea"></textarea><div id="hgtech-editor-preview" style="clear: both; padding: 3px; border: 2px dotted #ccc;font-size: 100%;line-height: 100%;width: 100%;word-wrap: break-word; margin-bottom : 10px; margin-top : 10px;"></div><input type="hidden" name="htmlcode" value="" id="hgtech-editor-htmlcode"><div class="hgtech-editor-dialog"><div id="hgtech-editor-dialog"><form action="#" id="hgtech-editor-dialog-imageform" method="post" enctype="multipart/form-data" style="background: -webkit-gradient(linear, bottom, left 175px, from(#CCCCCC), to(#EEEEEE));	background: -moz-linear-gradient(bottom, #CCCCCC, #EEEEEE 175px);margin:auto;position:relative;	width: 20%;height: 20%;font-family: Tahoma, Geneva, sans-serif;font-size: 14px;line-height: 24px;font-weight: bold;color: #09C;text-decoration: none;-webkit-border-radius: 10px;-moz-border-radius: 10px;	border-radius: 10px;padding:10px;border: 1px solid #999;border: inset 1px solid #333;-webkit-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);-moz-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);"><label>Image from  your desktop</label><input type="file" name="uploadfile" style="width=100%"><input type="submit" name="Submit" value="Submit" style="width=30%"></form><a href="#">close</a></div></div>');

		this.append ('<input type="submit" value="Submit">');

	this.addClass ('hgtech-editor').css ({"display" : "table"});		

	$ ('.hgtech-editor-dialog').css ({
		'visibility': 'hidden',
		'position': 'absolute',
		'left': '0px',
		'top': '0px',
		'width': '100%',
		'height': '100%',
		'text-align': 'center',
		'z-index': '1000'
	});

	$ ('.hgtech-editor-dialog input').css ({
		'display':'block', 
	    'border': '1px solid #999',
		'height': '25px', 
		'-webkit-box-shadow': '0px 0px 8px rgba(0, 0, 0, 0.3)', 
		'-moz-box-shadow': '0px 0px 8px rgba(0, 0, 0, 0.3)', 
		'box-shadow': '0px 0px 8px rgba(0, 0, 0, 0.3)'
	});

	$ ('.hgtech-editor #hgtech-editor-toolbar').css ({'list-style-type' : 'none', 
													 'height' : '30px',
													 'padding' : '0',
													 'margin' : '0',
													'background' : '#E5E5E5'});

	$ ('.hgtech-editor #hgtech-editor-toolbar ul').css ({'width' : '100%'});
	$ ('.hgtech-editor #hgtech-editor-toolbar li').css ({//'float' : 'left',
														'display' : 'inline-block',
														'position' : 'static',
														'padding' : '0',
														'line-height' : '20px'});

	$ ('.hgtech-editor #hgtech-editor-toolbar li a').css ({'display' : 'block',
														'font-weight' : '600',
														'font-size' : '13px',
														'padding' : '5px 25px',
														'color' : '#2D2D2D',
														'text-decoration' : 'none'});
	
	$ ('.hgtech-editor #hgtech-editor-toolbar li a').hover (function () {
		$ (this).css ({'color' : '#F90'});
	}, function () {
		$ (this).css ({'color' : '#fff'})
	});

	$ ('.hgtech-editor #hgtech-editor-toolbar li a').hover (function () {
		 $ ('.hgtech-editor #hgtech-editor-description').css ({'visibility' : 'visible',
		 													'height' : '60px', 
		 													'left' : '0',
		 													'background' : "#F3EED5",
		 													'font-size' : '13px',
			 												'margin' : '3px 0',
		 													'padding' : '0px 25px'})
			 											.html ('<p style="font-size : 13px;">' + $ (this).html ());
	}, function () {
		$ (this).css ({'color' : '#2D2D2D'});
		$ ('.hgtech-editor #hgtech-editor-description').css ({'visibility' : 'hidden',
																'overflow' : 'hidden',
																'height' : '0'});
									
	});
//
//	$ ('.hgtech-editor #hgtech-editor-toolbar li ul li').css ({'float' : 'none',
//																'position' : 'static',
//																'height' : '0',
//																'line-height' : '0',
//																'background' : 'none'});
//
//	$ ('.hgtech-editor #hgtech-editor-toolbar li').hover (function () {
//		$ (this).find ('ul li').css ({'height' : '30px',
//										'line-height' : '30px',
//										'padding' : '5px 0'});
//	}, function () {
//		$ (this).find ('ul li').css ({'height' : '0',
//										'line-height' : '0'
//										});
//	});

	
	if (config.Server = (config.Server || '')) {
		$ ('.hgtech-editor').attr ({'action' : config.Server});
	}

	if (config.imageServer = (config.imageServer || '')) {
		$ ('.hgtech-editor-dialog #hgtech-editor-dialog #hgtech-editor-dialog-imageform').attr ({'action' : config.imageServer});
	}

	$ ('.hgtech-editor-dialog #hgtech-editor-dialog a').click (function () {
		$ ('.hgtech-editor-dialog').css ({'visibility' : 'hidden'});	
	});

	$ ('.hgtech-editor #hgtech-editor-toolbar #hgtech-editor-toolbar-image').click (function () {
		$ ('.hgtech-editor-dialog').css ({'visibility' : 'visible'});
	});

	$ ('.hgtech-editor #hgtech-editor-toolbar #hgtech-editor-toolbar-bold').click (function (e) {
		insertAtCaret ('****', 2);
		$ ('.hgtech-editor #hgtech-editor-textarea').trigger ('keyup');
	});

	$ ('.hgtech-editor #hgtech-editor-toolbar #hgtech-editor-toolbar-italic').click (function (e) {
		insertAtCaret ('**', 1);
		$ ('.hgtech-editor #hgtech-editor-textarea').trigger ('keyup');
	});

	$ ('.hgtech-editor #hgtech-editor-toolbar #hgtech-editor-toolbar-boxtag').click (function (e) {
		insertAtCaret ('#[]', 1);
		$ ('.hgtech-editor #hgtech-editor-textarea').trigger ('keyup');
	});

	$ ('.hgtech-editor #hgtech-editor-toolbar #hgtech-editor-toolbar-hline').click (function (e) {
		insertAtCaret ('----');
		$ ('.hgtech-editor #hgtech-editor-textarea').trigger ('keyup');
	});

//	$ ('.hgtech-editor #hgtech-editor-toolbar #hgtech-editor-toolbar-canvas').click (function (e) {
//		insertAtCaret ('<canvas id="hgtech-editor-canvas"></canvas>');
//		$ ('.hgtech-editor #hgtech-editor-textarea').trigger ('keyup');
//		$ ('.hgtech-editor #hgtech-editor-preview #hgtech-editor-canvas').
//	});

	$ ('.hgtech-editor #hgtech-editor-textarea').keyup (function (event) {
		var textarea = $ (this);
		//alert (textarea.val ());
		var source = textarea.val ();
		//$ ('.hgtech-editor #hgtech-editor-source').val (source);
		source = source.replace (/^[^\S\n]{4}(.*)$/gm, '<div style="background : #F3EED5;"><code><span>$1</span></code></div>') 
		.replace (/\*\*([^*|^\s]+)\*\*/g, '<b>$1</b>')
		.replace (/\*([^*|^\s]+)\*/g, '<i>$1</i>')
		//.replace (/^(<[^\sbi]*>)*([^\S\n])/gm, '&nbsp');

		var regexImageLink = /^\[([^\[\]]*)\]:([^\[\]\n]*)$/gm;
		var imageLink;
		imageLink = source.match (regexImageLink);


		if (imageLink) {
			for (var i = 0; i < imageLink.length ; i ++) {

				var offset = imageLink [i].replace (regexImageLink, '$1');
				var link = imageLink [i].replace (regexImageLink, '$2');
				var reg = new RegExp ('!\\[([^\\[\\]]*)\\]\\[(' + offset + ')\\]');
				source = source.replace (regexImageLink, '')
								.replace (reg, "<img alt='$1' src='" + link + "' style='max-width : 640px'></img>");
			}
		}


		source = source.replace (/^-{3,}$/gm, "<hr style='border-bottom : 1px solid #ccc; margin-bottom : 5px;'>")
		//box code
					.replace (/#\[([^\]\[]*)\]/g, '<div style="display : inline-block; border : thin dotted #07c; max-width : 50%">$1</div>')
					.replace (/([^>])(\n\r?)/g, '$1<br/>')
					.replace (/((<[^<>\S\n]*>)*)(([^<>\S\n\r])*\n\r?)/g, '<br/>')
					.replace (/<\/span>(\n\r?)*<\/code><\/div>(\n\r?)*<br\/>(\n\r?)*<div[^<>]*><code>(\n\r?)*<span>/g, '<br/>')
					.replace (/(<hr[^<>]*>)<br\/>/g, '$1') 
					.replace (/^(<[^\sbi]*>)*([^\S\n])/gm, '&nbsp'); // 2014 08 04
		// image tag
		$ ('.hgtech-editor #hgtech-editor-preview').html (source);
		$ ('.hgtech-editor #hgtech-editor-htmlcode').val (source);
	});

	config.ajax = config.ajax || '';

	if (config.ajax) {
	$ ('.hgtech-editor').submit (function (e) {
		e.preventDefault ();
		var form = $ (this);
		var formdata = $ ('.hgtech-editor').serialize ();
		//var txt = encodeURIComponent ($ ('.hgtech-editor #hgtech-editor-preview').html ());
		//formdata = formdata.replace (/htmlcode=[^&]*&/, 'htmlcode='+ txt + '&');
		$.ajax ({
			url : $ (this).attr ('action'),
			type : 'post',
			data : formdata,
			success : config.success = (config.success || function () {}),
			error : config.error = (config.error || function () {})
		});
	});
	}
	
	$ ('#hgtech-editor-dialog-imageform').submit (function (e) {
		e.preventDefault ();
		$ (this).find ('a').trigger ('click');
		var dataform = new FormData (this);
		$.ajax ({
			url : $ (this).attr ('action'),
			type : 'post',
			data : dataform,
			mimeType : 'multipart/form-data',
			processData : false,
			contentType : false,
			success : function (data) {
				insertAtCaret (data, 0);
				$ ('.hgtech-editor #hgtech-editor-textarea').trigger ('keyup');
			},
			error : function (err) {
				alert ('image send error.');
			}
		});

	});	
}
}) (jQuery);
