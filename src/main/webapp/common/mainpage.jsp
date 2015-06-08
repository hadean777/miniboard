<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
<script type="text/javascript">
var threads = ${threadsObj};
</script>
</head>
<body>
<div class="panel panel-default" style="margin-left:20px;">
		      <div class="panel-heading">Thread list:</div>
		      <div class="panel-body form-group" id="content" style="margin-bottom:0px;"></div>
</div>
<div style="margin:20px;">
			<button type="button" class="btn btn-default" onclick="createNewThread()">Create New Thread</button>
</div>
<script type="text/x-jquery-tmpl" id="thread_template">
	<div class="form-group thread-record row">
 		<div class="col-md-10" style="padding: 5px; border: 1px solid grey">
			<label for="\${uid}" style="margin: 6px;">\${uid}</label>
			<label for="\${name}" style="margin: 6px;">\${name}</label>
			<button type="button" class="btn btn-default" onclick="replyOnThread(\${uid})">Reply</button>
		</div>
	</div>
</script>
<script src="../common/js/mainPage.js"></script>
</body>
</html>