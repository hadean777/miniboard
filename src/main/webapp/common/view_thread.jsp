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
	<div class="form-group">
		<input id="threaduid" type="hidden" value=${threadUid}></input>
		<label for="postname">Post name:</label>
  		<input class="form-control" id="postname" type="text"></input>
  		<label for="postmes">Your post:</label>
  		<textarea class="form-control" rows="15" id="postmes"></textarea>
  		<button type="button" class="btn btn-default" onclick="addPost()" style="margin: 6px">Add post</button><br>
	</div>
<script src="../common/js/viewThread.js"></script>
</body>
</html>