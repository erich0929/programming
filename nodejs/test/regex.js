var str = "http://blog.erich0929.com/economics.rep?article_id=&&";
console.log (str.replace (/http:\/\/[^\/]*\/([^\/.?]*).*/i,'$1'));
	
