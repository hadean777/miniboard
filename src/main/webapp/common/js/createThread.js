$(function () {
	
});

function createThread() {
	var mes = $('#message1').val();
//	alert(mes);
	var data = new FormData();
	
//	data.append('name', name);
	data.append('data', mes);
	
	$.ajax({
		url: 'createThread.do',
		data: data,
		cache: false,
		contentType: false,
		processData: false,
		async: false,
		type: 'POST',
		success: function (data) {
			if (data.success) {
				window.location.replace("viewThread.do?uid=" + data.data);
			} else {
				alert("Error");
			}
		},
		error: function (jqXHR, exception) {
			alert("Ajax Error");
		}
	});
}

/*function createThreadV2(mes) {
	alert(mes);
}*/