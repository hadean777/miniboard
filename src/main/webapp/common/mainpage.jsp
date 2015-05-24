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
<p>This is main page</p>
<div class="panel panel-default" style="margin-left:20px;">
		      <div class="panel-heading">Thread list:</div>
		      <div class="panel-body form-group" id="content" style="margin-bottom:0px;"></div>
</div>
<div style="margin:20px;">
			<button type="button" class="btn btn-default" onclick="createNewThread()">Create New Thread</button>
</div>
<script type="text/x-jquery-tmpl" id="thread_template">
	<div class="form-group thread-record row">
 		<div class="col-md-10">
			<label for="\${uid}" style="margin-top: 6px;">\${uid}</label>
			<button type="button" class="btn btn-default">Reply</button>
		</div>
	</div>
</script>
<script src="../common/js/mainPage.js"></script>
</body>
</html>