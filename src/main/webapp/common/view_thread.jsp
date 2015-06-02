<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thread ${threadUid}</title>
<script type="text/javascript">
var posts = ${postsObj};
</script>
</head>
<body>
<div class="form-group">
${threadUid}	${threadName}<br>
${threadMessage}
</div>
<div class="panel panel-default" style="margin-left:20px;">
		      <div class="panel-body form-group" id="content" style="margin-bottom:0px;"></div>
</div>
<script type="text/x-jquery-tmpl" id="post_template">
	<div class="form-group post-record row">
 		<div class="col-md-10">
			<label for="\${uid}" style="margin-top: 6px;">\${uid}</label>
			<label for="\${name}" style="margin-top: 6px;">\${name}</label><br>
			<label for="\${message}" style="margin-top: 6px;">\${message}</label>
		</div>
	</div>
</script>
</body>
</html>