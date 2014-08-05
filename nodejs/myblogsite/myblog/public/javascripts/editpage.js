$ (function () {
	var config = {};
	config.ajax = false;
	config.Server = '/postArticle';
	config.imageServer = '/upload';

	$ ('.editor').hgtech_editor (config);

});