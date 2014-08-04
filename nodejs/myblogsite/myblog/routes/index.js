var express = require('express');
var controller = require ('../controllers/index.js');
var router = express.Router();
var model = require ('../models/model.js')

/* GET home page. */
router.get('/', controller.index);

model.metaCollection.find ({}).toArray (function (err, result) {
	for (var i =0 ; i < result.length ; i++) {
		console.log ("Repositories : ");
		console.log (result [i].name);
		model.repositories.push ({collection : model.db.collection (result [i].name), name : result [i].name});
		console.log ('/' + model.repositories [i].name);
		console.log (controller.article);
		console.log ('model init in the router : ' + model.repositories.length);
		router.get ('/' + model.repositories [i].name, controller.article);
		router.post ('/' + model.repositories [i].name, controller.postArticle);
	}
});

//router.get ('/article', controller.article);
router.post ('/comment', controller.comment);
router.get ('/signup', controller.signup);
router.post ('/signup/auth', controller.signup_beforeAuth);
router.get ('/signup/auth', controller.signup_afterAuth);
router.get ('/signup/auth/err', controller.signup_auth_err);
router.get ('/login', controller.login);
router.post ('/login/auth', controller.login_auth);
router.get ('/images', controller.images);
router.post ('/upload', controller.upload);
router.get ('/edit', controller.edit);

module.exports = router;
