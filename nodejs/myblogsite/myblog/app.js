var express = require('express');
var path = require('path');
var favicon = require('static-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var multipart = require ('connect-multiparty');


//session-module
var session = require ('express-session');

//connect-mongoskin
var SKINSTORE = require ('connect-mongoskin');

var routes = require('./routes/index');
var users = require('./routes/users');

//controllers
var controllers = require ('./controllers');

//models
var model = require ('./models/model.js');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(favicon());
app.use(logger('dev'));

app.use (bodyParser ());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded());
app.use(cookieParser());
app.use (multipart ());

//app.use(require('stylus').middleware(path.join(__dirname, 'public')));
app.use(express.static(path.join(__dirname, 'public')));

// session middleware
app.use (session ({
			secret : 'hgtech-session',
			cookie : { maxAge : null },//maxAge : 1000000 }, // use session-cookies, not persistant cookies.
			store : new SKINSTORE (model.session_db)
		})
);

//insert repository information into request using middleware
app.use (function (req, res, next) {
    var repository = req.url.replace (/\/([^\/\?\.]*).*/i, '$1');
    req.repository = repository;
    console.log ("Request's repository : " + req.repository);
    next ();
});



app.use('/', routes);
app.use('/users', users);

//console.log (model.repositories.length);
//for (var i=0; i < model.repositories.length; i++) {
//    routes.get ('/' + model.repositories[i].name, controller.article);
//    console.log ('route init!!');
//}

/// catch 404 and forwarding to error handler
app.use(function(req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

/// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
    app.use(function(err, req, res, next) {
        res.status(err.status || 500);
        res.render('error', {
            message: err.message,
            error: err
        });
    });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
        message: err.message,
        error: {}
    });
});


//app.get ('/', controllers.index);

module.exports = app;
