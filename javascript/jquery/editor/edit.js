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
	$.fn.editor = function (config) {
		config = config || {};
		this.append ('<div style="display : table;"><div class="hlist"><ul id="hgtech-editor-toolbar"><li><a id="hgtech-editor-toolbar-image">image</a></li><li><a id="hgtech-editor-toolbar-hline">Hline</a></li><li><a id="hgtech-editor-toolbar-bold">Bold</a></li><li><a id="hgtech-editor-toolbar-boxtag">Box</a></li><li><a id="hgtech-editor-toolbar-italic">Italic</a></li><li><a id="hgtech-editor-toolbar-code">Code</a></li></ul></div><div id="hgtech-editor-description" style="visibility : hidden; overflow : hidden; height : 0; margin : 3px 0; padding : 0px 25px;"></div><textarea rows="7" cols="82" name="htmlcode" value="" id="hgtech-editor-textarea"></textarea><div id="hgtech-editor-preview" style="clear: both; padding: 3px; border: 2px dotted #ccc;font-size: 107%;line-height: 130%;width: 660px;word-wrap: break-word; margin-bottom : 10px; margin-top : 10px;"></div><input type="submit" value="submit"><div class="hgtech-editor-dialog"><div id="hgtech-editor-dialog"><form action="#" id="hgtech-editor-dialog-imageform" method="post" enctype="multipart/form-data"><label>Image from  your desktop</label><input type="file" name="uploadfile"><input type="submit" name="Submit" value="Submit"></form><a href="#">close</a></div></div>');

	this.addClass ('hgtech-editor');		
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

	$ ('.hgtech-editor-dialog div').css ({
		'width' : '300px',
		'margin' : '100px auto',
		'background-color' : '#fff',
		'border': '1px solid #000',
		'padding' : '15px',
		'text-align': 'center'
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

	$ ('.hgtech-editor #hgtech-editor-textarea').keyup (function (event) {
		var textarea = $ (this);
		var source = textarea.val ();
		$ ('.hgtech-editor #hgtech-editor-source').val (source);
		source = source.replace (/^[^\S\n]{4}(.*)$/gm, '<code><span>$1</span></code>') 
		.replace (/\*\*([^*|^\s]+)\*\*/g, '<b>$1</b>')
		.replace (/\*([^*|^\s]+)\*/g, '<i>$1</i>')
		.replace (/^(<[^\s]*>)*([^\S\n])/gm, '&nbsp');

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
		.replace (/\n\r?/g, '<br/>')
		.replace (/((<[^<>\S\n]*>)*)(([^<>\S\n\r])*\n\r?)/g, '<br/>')
		.replace (/<\/code>(\n\r?)*<br\/>(\n\r?)*<code>/g, '<br/>')
		.replace (/(<hr[^<>]*>)<br\/>/g, '$1') 
		// image tag
		$ ('.hgtech-editor #hgtech-editor-preview').html (source);
	});

	$ ('.hgtech-editor').submit (function (e) {
		e.preventDefault ();
		var form = $ (this);
		var formdata = $ ('.hgtech-editor').serialize ();
		var txt = encodeURIComponent ($ ('.hgtech-editor #hgtech-editor-preview').html ());
		formdata = formdata.replace (/htmlcode=[^&]*&/, 'htmlcode='+ txt + '&');
		$.ajax ({
			url : $ (this).attr ('action'),
			type : 'post',
			data : formdata,
			success : config.success = (config.success || function () {}),
			error : config.error = (config.error || function () {})
		});
	});

	$ ('#hgtech-editor-dialog-imageform').submit (function (e) {
		e.preventDefault ();
		dialog.dialog ('close');
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
