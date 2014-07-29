$ (function () {
	$ ('.hgtech-dialog hgtech-dialog-imageform').submit (function (e) { // Report : 이중선택자를 잘못 사용하여 백색페이지에 데이터가 쓰이는 것.
		e.preventDefault ();
		$.ajax ({
			url : $ (this).attr ('action'),
			type : 'post',
			data : $ (this).serialize (),
			success : function (data) {
				if (data.imageUrl) {
					alert (data.imageUrl);
					insetAtCaret (data.imageUrl, 0);
					$ ('.hgtech-form .hgtech-editor').trigger ('keyup');
				}
			}
		});
		return false;
	});
});
