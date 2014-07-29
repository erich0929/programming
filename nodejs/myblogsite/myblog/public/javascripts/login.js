$ (function () {
	$ ('.hgtech-login').submit (function (e) {
		e.preventDefault ();
		$.ajax ({
			url : $ (this).attr ('action'),
			type : 'post',
			data : $ (this).serialize (),
			success : function (data) {
				if (data.returnUrl) {
					location.href = data.returnUrl;
				} else {
					$ ('.login-msg').html (data.message);
				}
			}
		});
		return false;
	});
});
