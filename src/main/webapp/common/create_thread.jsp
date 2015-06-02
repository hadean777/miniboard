<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create new thread</title>
</head>
<body>
<div class="form-group">
  <label for="message1">Message:</label>
  <textarea class="form-control" rows="15" id="message1"></textarea>
  <button type="button" class="btn btn-default" onclick="createThread()">Create New Thread</button><br>
<!-- <button type="button" class="btn btn-default" onclick="createThreadV2($('#message1').val())">Create New Thread v2</button> -->
</div>
<script src="../common/js/createThread.js"></script>
</body>
</html>