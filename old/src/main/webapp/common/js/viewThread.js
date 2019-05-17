$(function () {
	renderPostList(posts);
});

//$("#content").empty();
function renderPostList(postList) {
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

function getNewPosts() {
	var threaduid = $('#threaduid').val();
	var lastpost = $('#threaduid').val();
	var data = new FormData();
	
	if (posts.length > 0) {
		lastpost = posts[posts.length - 1].uid;
	}
	
	data.append('threaduid', threaduid);
	data.append('lastpostuid', lastpost);
	
	$.ajax({
		url: 'getNewPosts.json',
		data: data,
		cache: false,
		contentType: false,
		processData: false,
		async: true,
		type: 'POST',
		success: function (data) {
			if (data.success) {
				if (data.data != null) {
					for (var i = 0; i < data.data.length; i++) {
						posts.push(data.data[i]);
					}
					renderPostList(data.data);
				} else {
					alert("No message");
				}
			} else {
				alert(data.message);
			}
		},
		error: function (jqXHR, exception) {
			alert(exception);
		}
	});
	
}