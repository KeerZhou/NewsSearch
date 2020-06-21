<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="utf-8" http-equiv="charset">
<title>新闻搜索</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource'/>/base.css" media="all">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource'/>/search.css" media="all">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource'/>/plist20131112.css" media="all">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource'/>/list-page-20141009.css" media="all">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource'/>/pop_compare.css" media="all">
<script type="text/javascript"
	src="<c:url value='/resource'/>/jquery-1.2.6.pack.js"></script>
	
<script type="text/javascript">
	function query() {
		//执行关键词查询时清空过滤条件
		document.getElementById("page").value="";
		//执行查询
		queryList();
	}
	function queryList() {
		//提交表单
		document.getElementById("actionForm").submit();
	}
	function filter(key, value) {
		document.getElementById(key).value=value;
		queryList();
	}
	function sort() {
		var s = document.getElementById("sort").value;
		if (s != "1") {
			s = "1";
		} else {
			s = "0";
		}
		document.getElementById("sort").value = s;
		queryList();
	}
	function changePage(p) {
		var curpage = Number(document.getElementById("page").value);
		curpage = curpage + p;
		document.getElementById("page").value = curpage;
		queryList();
	}
</script>
</head>
<body>
	<div class="searchhead"><img class="logo" src="resource/img/logo.png"></div>
	<div id="search-2020">
		<div class="i-search ld">
			<form id="actionForm" action="newsList.action" method="GET">
			<div class="form">
				<input type="text" class="text" accesskey="s" name="queryString" id="key" value="${queryString }"
					autocomplete="off" onkeydown="javascript:if(event.keyCode==13) {query()}">
				<input type="submit" value="搜索" class="button">
			</div>
			</form>
		</div>
		<div id="hotwords"></div>
	</div>
</body>
</html>