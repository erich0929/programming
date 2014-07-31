var express = require('express');
var controller = require ('../controllers');
var router = express.Router();


/* GET home page. */
router.get('/', controller.index);
router.get ('/article', controller.article);
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
