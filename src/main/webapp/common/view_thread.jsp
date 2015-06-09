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
<div class="form-group row" style="margin: 10px; padding: 5px; border: 1px solid grey">
	<div class="col-sm-4"><p class="lead"><b>${threadUid}</b></p></div>	
	<div class="col-sm-8"> <p class="lead"><b>${threadName}</b></p></div>
	<div class="col-sm-12"><p align="justify">${threadMessage}</p></div>
</div>

<div class="panel panel-default" style="margin-left:20px;">
		      <div class="panel-body form-group" id="content" style="margin-bottom:0px;"></div>
</div>
<script type="text/x-jquery-tmpl" id="post_template">
	<div class="form-group post-record row" style="padding: 5px; border: 1px solid grey">
		
 		<div class="col-sm-4">
			<label for="\${uid}">\${uid}</label>
		</div>
		<div class="col-sm-8">
			\${name}
		</div>
		<div class="col-sm-12">
			<p align="justify">{{html message}}</p>
		</div>
	</div>
</script>
	<div class="form-group" style="margin: 10px;">
		<input id="threaduid" type="hidden" value="${threadUid}"></input>
		<label for="postname">Post name:</label>
  		<input class="form-control" id="postname" type="text"></input>
  		<label for="postmes">Your post:</label>
  		<textarea class="form-control" rows="15" id="postmes"></textarea>
  		<button type="button" class="btn btn-default" onclick="addPost()" style="margin: 6px">Add post</button><br>
	</div>
<script src="../common/js/viewThread.js"></script>
</body>
</html>