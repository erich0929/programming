var model = require ('../models/model.js');
var fs = require ('fs');
var crypto = require ('crypto');
var randString = require ('randomstring');

exports.main = function (req, res) {
	res.render ('main', {});

}

exports.index = function (req, res) {
	var currentPage = req.query.page || 0;
	if (currentPage == 0) currentPage = 1;
	var articlePerPage = 10;
	
	var totalPage = 0;
	
	var repository = model.getRepository (req.repository);
	repository.count (function (err, count){ 
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
										  	  session : req.session,
										  	  repository : req.repository
						 				 	 });
							}
					);
	});

};

exports.article = function (req, res) {
	req.query.article_id = req.query.article_id || '';	
	var id = req.query.article_id;

	if (!id)  {
		exports.index (req, res, repository);
	} else {
		var repository = model.getRepository (req.repository);
		repository.findOne ({ _id : new model.ObjectID (id) }, function (err, article) {
						if (article === '') {
							res.redirect ('/');
						} else {
							req.session.backpage = req.session.currentPage;
							req.session.currentPage = '/article?article_id=' + id;
							res.render ('article', { article : article,
													session : req.session,
							   						repository : req.repository
							});
						}
		});
	}
};

exports.comment = function (req, res) {
	var body = req.body;
	if (body.article_id && body.name && body.email && body.htmlcode && body.source && body.repository) {
		var comment = {};
		comment.name = body.name;
		comment.email = body.email;
		comment.comment = body.htmlcode;
		comment.source = body.source;
		comment.posted_at = new Date ();
		var repository = model.getRepository (body.repository);
		repository.update ({_id : new model.ObjectID (body.article_id) }, {'$push' : {comments : comment}},
				function (err) {
					if (err) throw err;
		});
		console.log ('Great! your comment is posted.');
		console.log ('posted contents : ');
		console.log (comment);
		
		res.json ('posted');
	} else {
		console.log ('Sorry, please go back.');
		res.json ('failed');	
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
		var rename = randString.generate (7) + parseInt (Math.random () * 1000);
		var filepath = '/home/erich0929/programming/nodejs/myblogsite/myblog/public/files/' + rename;
		
		//console.log ('image file path : ' + filepath);

		fs.writeFile (filepath, data, function (err) {
			if (err) {
				throw err;
			} else {
				var referString = randString.generate (4);
				var imagetag = "![Destription][" + referString + "]\n\n";
				var imageUrl = '[' + referString + ']: ' + 'http://' + req.headers.host + '/images?image=' + rename; 
				//localhost or http://www.hgtech.com is preferred to req.header.host!!
				var alltags = imagetag + imageUrl;
				console.log ('response tag : ' + alltags);
				res.send (alltags);
			}
		});
	});
};

exports.edit = function (req, res) {
	var repository = '';
	if (req.session.user) {
		if (req.session.user.username === 'erich0929') {

			if (req.query.article_id && req.query.repository) {
				model.collection.findOne ({_id : new model.ObjectID (req.query.article_id)}, function (err, article) {
					if (err) {
						res.redirect ('/');
					} else {
						res.render ('edit', {session : req.session,
											article : article,
											repository : req.query.repository});
					}
				});
			} else {
				var article = {};
				article._id = '';
				article.title = '';
				article.source = ''
				article.tags = [];
	
				res.render ('edit', {session : req.session,
									article : article,
									repositories : model.repositories});

			}
		}else {
			res.redirect ('/');
		}

	} else {
		res.redirect ('/');
	}
	
}

exports.postArticle = function (req, res) {
	var body = req.body;
	body.article_id = body.article_id || '';
	var repository = body.repository.replace (/http:\/\/[^\/]*\/([^\/.?]*).*/i,'$1');
	console.log ('Requested rep to post a article : ' + repository);
	repository = model.getRepository (repository);
	body.tags = body.tags || [];
	body.tags = body.tags.split (/[\s,&-]+/);
	if (body.article_id) {
		if (body.htmlcode && body.source && body.title && body.tags) {
			repository.update ({_id : new model.ObjectID (body.article_id)}, {'$set' : {title : body.title,
																					content : body.htmlcode,
																					tags : body.tags,
																					source : body.source,
																					saved_at : new Date ()}}, 
								function (err) {
									res.render ('postArticleErr', {error : err});
			});
		} else {
			res.render ('postArticleErr', {error : 'Validation Error!'});
		}
	
	} else {
		if (body.htmlcode && body.source && body.title && body.tags) {
			repository.insert ({title : body.title, content : body.htmlcode, 
								tags : body.tags, source : body.source, saved_at : new Date ()}, 
								function (err, result) {
									if (err) {
										res.render ('postArticleErr', {error : err});
									}
									if (result) {
										console.log ('posting success');
										res.redirect ('/');
									}
			});
		} else {
			res.render ('postArticleErr', {error : 'Validation Error!'});
		}

	}
}
