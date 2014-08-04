$ (function () {
	var config = {};
	
	config.success = function (data) {
				if (data == 'posted') {
					window.location.reload ();
					$ ('.hgtech-editor')[0].reset ();
				}
				else {
					alert (data);
					$ ('#CommentToComment').html ('Fail to post Comment.');
				}
	}
	config.location = 'prepend';

	config.Server = '/comment';
	config.imageServer = '/upload';

	config.ajax = true;

	$ ('.editor').hgtech_editor (config);
});