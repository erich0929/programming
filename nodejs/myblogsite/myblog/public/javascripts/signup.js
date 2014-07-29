$ (function () {
	$ ('.hgtech-signup').submit (function (e) {
		e.preventDefault ();
		$.ajax ({
			url : $ (this).attr ('action'),
			type : 'post',
			data : $ (this).serialize (),
			success : function (data) {
				$ ('.hgtech-signup-msg').html (data.message);
			}
		});
		return false;
	});
});