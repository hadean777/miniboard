<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>miniboard</title>

<c:set var="url">${pageContext.request.requestURL}</c:set>
<c:set var="baseUrl">${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}</c:set>

<!-- Styles -->
    <link rel="stylesheet" href="${baseUrl}/libs/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${baseUrl}/css/styles.css">
    <script src="<c:url value="/libs/jquery-1.11.2.js"/>"></script>
    <script src="<c:url value="/libs/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="${baseUrl}/libs/jquery.tmpl.js" type="text/javascript"></script>
	<script src="${baseUrl}/libs/jsrender.min.js" type="text/javascript"></script>
<decorator:head />
</head>
<body>
<decorator:body />
</body>
</html>