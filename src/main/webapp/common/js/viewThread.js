$(function () {
	renderPostList(posts);
});

function renderPostList(postList) {
	$("#content").empty();
	for (var i = 0; i < postList.length; i++) {
		$('#post_template').tmpl(postList[i]).appendTo('#content');
	}
}

function addPost() {
	var mes = $('#postmes').val();
	var name = $('#postname').val();
	var threaduid = $('#threaduid').val();
	var data = new FormData();
	
	data.append('threaduid', threaduid);
	data.append('name', name);
	data.append('data', mes);
	
	$.ajax({
		url: 'viewThread.do',
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
				alert(data.message);
			}
		},
		error: function (jqXHR, exception) {
			alert(exception);
		}
	});
}