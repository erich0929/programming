function insertAtCaret(text, backend) {
    var backend = backend || 0;
    var txtarea = document.getElementById('hgtech-editor');
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
	$ ('.hgtech-form .hgtech-editor').keyup (function (event) {
        var textarea = $ (this);
        var comment = textarea.val ();
        comment = comment.replace (/^[^\S\n]{4}(.*)$/gm, '<code><span>$1</span></code>') 
        comment = comment.replace (/\*\*([^*|^\s]+)\*\*/g, '<b>$1</b>');
        comment = comment.replace (/\*([^*|^\s]+)\*/g, '<i>$1</i>')


        comment = comment.replace (/^(<[^\s]*>)*([^\S\n])/gm, '&nbsp');
        var regexImageLink = /^\[([^\[\]]*)\]:([^\[\]\n]*)$/gm;
        var imageLink;
        imageLink = comment.match (regexImageLink);
       

   	   if (imageLink) {
     	for (var i = 0; i < imageLink.length ; i ++) {
        		
        		var offset = imageLink [i].replace (regexImageLink, '$1');
        		var link = imageLink [i].replace (regexImageLink, '$2');
        		//alert (offset + ' ' + link);
        		var reg = new RegExp ('!\\[([^\\[\\]]*)\\]\\[(' + offset + ')\\]');
        		comment = comment.replace (regexImageLink, '');
        		comment = comment.replace (reg, "<img alt='$1' src='" + link + "'></img>");
        	}
    	   }
     
                          // .replace (/!\[([^\[\]]*)\]\[([^\[\]]*)\]/g, "<img href='$1'>")
        comment = comment.replace (/^-{3,}$/gm, "<hr style='border-bottom : 1px solid #ccc; margin-bottom : 5px;'>")
        //box code
        					.replace (/#\[([^\]\[]*)\]/g, '<div style="display : inline-block; border : thin dotted #07c; max-width : 50%">$1</div>')
        					//.replace (/\n\r?/g, '<br/>')
        					.replace (/((<[^<>\S\n]*>)*)(([^<>\S\n\r])*\n\r?)/g, '<br/>')
        					.replace (/<\/code>(\n\r?)*<br\/>(\n\r?)*<code>/g, '<br/>')
        					.replace (/(<hr[^<>]*>)<br\/>/g, '$1')
        // image tag
  					
        //comment = comment.replace (/^\n\r?/gm, '<br/>');
        $ ('.hgtech-form .hgtech-preview').html (comment);
	});
});

$ (function () {
	$ ('.hgtech-form').submit (function (e) {
		e.preventDefault ();
		var form = $ (this);
		var formdata = $ ('.hgtech-form').serialize ();
		var txt = encodeURIComponent ($ ('.hgtech-form .hgtech-preview').html ());
		formdata = formdata.replace (/comment=[^&]*&/, 'comment='+ txt + '&');
		//alert (formdata);	
		$.ajax ({
			url : $ (this).attr ('action'),
			type : 'post',
			data : formdata,
			success : function (data) {
				location.reload ();
			},
			error : function () {

			}
		});
		return false;
	});
});

$ (function () {


	$ ('.hgtech-form .hgtech-toolbar .bold').click (function (e) {
		insertAtCaret ('****', 2);
		$ ('.hgtech-form .hgtech-editor').trigger ('keyup');
	});

	$ ('.hgtech-form .hgtech-toolbar .italic').click (function (e) {
		insertAtCaret ('**', 1);
		$ ('.hgtech-form .hgtech-editor').trigger ('keyup');
	});

	$ ('.hgtech-form .hgtech-toolbar .boxtag').click (function (e) {
		insertAtCaret ('#[]', 1);
		$ ('.hgtech-form .hgtech-editor').trigger ('keyup');
	});

	$ ('.hgtech-form .hgtech-toolbar .hline').click (function (e) {
		insertAtCaret ('----');
		$ ('.hgtech-form .hgtech-editor').trigger ('keyup');
	});
});

$ (function () {
	var dialog = $ ('.hgtech-dialog #dialog-form').dialog ({
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


	$ ('.hgtech-form .hgtech-toolbar .image').click (function (e) {
		dialog.dialog ('open');
		//insertAtCaret ('image tag', 3);
		//$ ('.hgtech-form .hgtech-editor').trigger ('keyup');
	});

	$ ('.hgtech-dialog-imageform').submit (function (e) {
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
				$ ('.hgtech-form .hgtech-editor').trigger ('keyup');
			},
			error : function (err) {
				console.log (err);
			}
		});
		
	});
});