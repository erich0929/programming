var model = require ('../models/model.js');
var fs = require ('fs');

exports.index = function (req, res) {
	var currentPage = req.query.page || 0;
	if (currentPage == 0) currentPage = 1;
	var articlePerPage = 10;
	
	var totalPage = 0;
	model.collection.count (function (err, count){ 
		totalPage = Math.ceil (count / articlePerPage);
		if (currentPage > totalPage) currentPage = totalPage;
		var skip = (currentPage - 1) * articlePerPage;
		model.collection.find ({})
					.sort ({'saved_at' : 1 })
			  		.skip (skip)
			  		.limit (articlePerPage)
			  		.toArray (function (err, result) {
			  			req.session.backpage = req.session.currentPage;
			  			req.session.currentPage = '/';
						res.render ('index', {result : result,
										  	  currentPage : currentPage,
										  	  totalPage : totalPage,
										  	  session : req.session
						 				 	 });
							}
					);
	});

};

exports.article = function (req, res) {
	var id = req.query.article_id;
	if (!id)  res.redirect ('/');
	model.collection.findOne ({ _id : new model.ObjectID (id) }, function (err, article) {
						if (article.length === 0) {
							res.redirect ('/');
						} else {
							req.session.backpage = req.session.currentPage;
							req.session.currentPage = '/article?article_id=' + id;
							res.render ('article', { article : article,
						   							session : req.session
							});
						}
	});
};

exports.comment = function (req, res) {
	var body = req.body;
	if (body.article_id && body.name && body.email && body.comment) {
		var comment = {};
		comment.name = body.name;
		comment.email = body.email;
		comment.comment = body.comment;
		comment.posted_at = new Date ();

		model.collection.update ({_id : new model.ObjectID (body.article_id) }, {'$push' : {comments : comment}},
				function (err) {
					if (err) throw err;
		});
		console.log ('Great! your comment is posted.');
	} else {
		console.log ('Sorry, please go back.');	
	}
};

exports.signup = function (req, res) {
	req.session.backpage = req.session.currentPage;
	req.session.currentPage = '/signup';
	res.render ('signup', {session : req.session, 
						  returnUrl : req.query.returnUrl
						  }
	);
};

exports.signup_beforeAuth = function (req, res) {
	if (req.body.email && req.body.username && req.body.password) {
		req.session.sendmailFlag = req.session.sendmailFlag || [];
		for (var i=0; i < req.session.sendmailFlag.length ; i++) {
			var alreadySubmit;
			if (req.session.sendmailFlag [i] === req.body.username) {
				alreadySubmit = true;
			}
		}
		if (alreadySubmit) {
			res.json ({'message' : 'Your information is already send to your e-mail.'});
		} else {

			model.is_unique_username (req.body.username, function (bool) {
				if (bool) {
					model.beforeAuth_db.insert ({'created_at' : new Date (), 
												'email' : req.body.email,
												'username' : req.body.username,
												'password' : req.body.password
												}, function (err, result) {
													if (err) {
														console.log (err);
														res.json ('Username you\'ve putted is already exited, please put another username.');
													} else {
														var user = result [0];
														console.log (user);
														obj = {"to" : req.body.email, 
														       "link" : 'http://' + req.headers.host 
														       + '/signup/auth?user_id=' + encodeURIComponent (user._id)
														       + '&returnUrl=' + encodeURIComponent (req.query.returnUrl) };
														model.sendmail (obj);
														
														req.session.sendmailFlag.push (user.username);
														res.json ({"message" : "We've send email to your email account. please confirm."});
													}
												});
				} else {
					res.json ({"message" :'Username you\'ve putted is already exited, please put another username.'});
				}
			});
		}
	} else {
		res.json ({ 'message' : 'Rewrite please...'});
	}

};

exports.signup_afterAuth = function (req, res) {
	var user_id = req.query.user_id;
	var returnUrl = req.query.returnUrl;
	if (!user_id || !returnUrl) {
		res.redirect ('/');
	} else {
		model.beforeAuth_db.findOne ({_id : new model.ObjectID (user_id)}, 
			function (err, result) {
				if (result) {
					model.afterAuth_db.insert ({'email' : result.email, 
										        'username' : result.username, 
											   'password' : result.password, 
											   'created_at' : new Date ()
										   	   }, 
										   function (err, result) {
												if (err) { 
													console.log (err); 
												} else {
													console.log (result.username + ' authorized as account of ' + result.email);
													req.session.user = result.username;
													res.redirect (returnUrl);
												}
										   }
					);
				} else {
					req.session.auth_err = 'expired_err';
					req.session.returnUrl = returnUrl;
					res.redirect ('/signup/auth/err?returnUrl=' + returnUrl);
				}	
			}
		);
	}
};

exports.signup_auth_err = function (req, res) {
	if (req.session.auth_err == 'expired_err') {
		req.session.backpage = req.session.currentPage;
		req.session.currentPage = '/signup/auth/err';
		res.render ('auth_err', {returnUrl : req.query.returnUrl, session : req.session});
	} else {
		res.redirect ('/');
	}
};


exports.login = function (req, res) {
	req.session.backpage = req.session.currentPage;
	req.session.currentPage = '/login';
	res.render ('login', {session : req.session, 
						 returnUrl : req.query.returnUrl});
};

exports.login_auth = function (req, res) {
	req.session.backpage = req.session.currentPage;
	req.session.currentPage = '/login';	
	if (req.session.backpage === '/login') {
		model.afterAuth_db.findOne ({username : req.body.username,
									password : req.body.password
									},
									function (err, user) {
										if (user) {
											req.session.user = user;
											var returnUrl = 'http://' + req.headers.host + req.query.returnUrl;
											res.json ({'returnUrl' : returnUrl, 
														'message' : 'redirect'});
										} else {
											res.json ({'message' : 'We can not find account you\' inputted. Or Password can be not correct. please confirm.'});
										}
									}
		);
	}
};

exports.images = function (req, res) {
	var imagefile = req.query.image;
	var filepath = '/home/erich0929/programming/nodejs/myblogsite/myblog/public/files/' + imagefile;
	res.sendfile (filepath, function (err) {
		if (err) {
			throw err;
		} else {
			console.log ('image file send : ' + filepath);
		}
	});
};

exports.upload = function (req, res) {
	fs.readFile (req.files.uploadfile.path, function (err, data) {
		var filepath = '/home/erich0929/programming/nodejs/myblogsite/myblog/public/files/' + req.files.uploadfile.name;
		
		//console.log ('image file path : ' + filepath);

		fs.writeFile (filepath, data, function (err) {
			if (err) {
				throw err;
			} else {
				var imageUrl = 'http://' + req.headers.host + '/images?image=' + req.files.uploadfile.name;
				//console.log ('imageUrl : ' + imageUrl);
				res.send (imageUrl);
			}
		});
	});
};