var Token = function (spec) {
	var pattern = spec //정규식 객체
	
	this.match = function (string) {
				var result = pattern.exec (string);
				return result;
			 }
};

module.exports = Token;
