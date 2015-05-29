$(function () {
	renderThreadList(threads);
});

function renderThreadList(threadList) {
	$("#content").empty();
	for (var i = 0; i < threadList.length; i++) {
		$('#thread_template').tmpl(threadList[i]).appendTo('#content');
	}
}

function createNewThread() {
	window.location.replace("../create_thread.do");
}