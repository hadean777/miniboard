$(function () {
	renderPostList(posts);
});

function renderPostList(postList) {
	$("#content").empty();
	for (var i = 0; i < postList.length; i++) {
		$('#post_template').tmpl(postList[i]).appendTo('#content');
	}
}