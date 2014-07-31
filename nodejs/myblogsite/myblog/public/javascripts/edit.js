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


$ (function () {
	$ ('.hgtech-editor #hgtech-editor-textarea').keyup (function (event) {
        var textarea = $ (this);
        var source = textarea.val ();
        $ ('.hgtech-editor #hgtech-editor-source').val (source);
        sourcesource = source.replace (/^[^\S\n]{4}(.*)$/gm, '<code><span>$1</span></code>') 
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
        		//alert (offset + ' ' + link);
        		var reg = new RegExp ('!\\[([^\\[\\]]*)\\]\\[(' + offset + ')\\]');
        		source = source.replace (regexImageLink, '')
        						 .replace (reg, "<img alt='$1' src='" + link + "' style='max-width : 640px'></img>");
        	}
    	   }
     
                          // .replace (/!\[([^\[\]]*)\]\[([^\[\]]*)\]/g, "<img href='$1'>")
        source = source.replace (/^-{3,}$/gm, "<hr style='border-bottom : 1px solid #ccc; margin-bottom : 5px;'>")
        //box code
        					.replace (/#\[([^\]\[]*)\]/g, '<div style="display : inline-block; border : thin dotted #07c; max-width : 50%">$1</div>')
        					//.replace (/\n\r?/g, '<br/>')
        					.replace (/((<[^<>\S\n]*>)*)(([^<>\S\n\r])*\n\r?)/g, '<br/>')
        					.replace (/<\/code>(\n\r?)*<br\/>(\n\r?)*<code>/g, '<br/>')
        					.replace (/(<hr[^<>]*>)<br\/>/g, '$1')
        // image tag
  					
        //source = source.replace (/^\n\r?/gm, '<br/>');
        $ ('.hgtech-editor #hgtech-editor-preview').html (source);
	});
});

$ (function () {
	$ ('.hgtech-editor').submit (function (e) {
		e.preventDefault ();
		var form = $ (this);
		var formdata = $ ('.hgtech-editor').serialize ();
		var txt = encodeURIComponent ($ ('.hgtech-editor #hgtech-editor-preview').html ());
		formdata = formdata.replace (/htmlcode=[^&]*&/, 'htmlcode='+ txt + '&');
		//alert (formdata);	
		$.ajax ({
			url : $ (this).attr ('action'),
			type : 'post',
			data : formdata,
			success : function (data) {
				if (data == 'posted') {
					window.location.reload ();
					$ ('.hgtech-editor')[0].reset ();
				}
				else {
					alert (data);
					$ ('#CommentToComment').html ('Fail to post Comment.');
				}
			},
			error : function () {

			}
		});
		
	});
});

$ (function () {


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
});

$ (function () {
	var dialog = $ ('.hgtech-editor-dialog #hgtech-editor-dialog').dialog ({
		autoOpen : false,
		height : 300,
		width  : 350,
		modal : true,
		buttons : {
			Cancel : function () {
				dialog.dialog ('close');
			}
		},
		close : function () {
			//form [0].reset ();
			//allFields.removeClass ('ui-state-error');
		}
	});


	$ ('.hgtech-editor #hgtech-editor-toolbar #hgtech-editor-toolbar-image').click (function (e) {
		dialog.dialog ('open');
		//insertAtCaret ('image tag', 3);
		//$ ('.hgtech-form .hgtech-editor').trigger ('keyup');
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
				//alert (data);
				//dialog.dialog ('close');
				insertAtCaret (data, 0);
				$ ('.hgtech-editor #hgtech-editor-textarea').trigger ('keyup');
			},
			error : function (err) {
				console.log (err);
			}
		});
		
	});
});