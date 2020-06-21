<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!-- saved from url=(0047)http://list.jd.com/list.html?cat=1315,1343,1355 -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="utf-8" http-equiv="charset">
<title>新闻搜索 </title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resource'/>/base.css" media="all">
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
		var curpage = ${result.curPage};
		var sumpage = ${result.pageCount};
		curpage = curpage + p;
		if(curpage == 0 || curpage>sumpage){
			alert("已经没有了哦");
		}else{
			document.getElementById("page").value = curpage;
			queryList();
		}
	}
</script>
</head>
<body class="root61">
<div id="o-header-2013">
	<div class="w" id="header-2013">
		<!-- <div id="logo-2013" class="ld"><a hidefocus="true"><b></b><img src="logo.png" width="270" height="60"></a></div>-->
		<!--logo end-->
		<div id="search-2013">
			<div class="i-search ld">
				<ul id="shelper" class="hide"></ul>
				<form id="actionForm" action="list.action" method="GET">
				<div class="form">
					<input type="text" class="text" accesskey="s" name="queryString" id="key" value="${queryString }"
						autocomplete="off" onkeydown="javascript:if(event.keyCode==13) {query()}">
					<input type="submit" value="搜索" class="button" onclick="query()">
				</div>
				<input type="hidden" name="page" id="page" value="${result.curPage }"/> 
				</form>
			</div>
			<div id="hotwords"></div>
		</div>
		<!--search end-->
		<!--my360buy end-->
		<!--settleup end-->
	</div>
	<!--header end-->
</div>
<div class="w main">
<div class="right-extra">
<!--新闻列表开始-->
<div id="filter">
	<div class="cls"></div>
	<div class="fore1">
		<dl class="activity">
			<dd></dd>
		</dl>
		<div class="pagin pagin-m">
			<span class="text"><i>${result.curPage}</i>/${result.pageCount}</span>
			<a href="javascript:changePage(-1)" class="prev">上一页<b></b></a>
			<a href="javascript:changePage(1)" class="next">下一页<b></b></a>
		</div>
		<div class="total">
			<span>共<strong>${result.recordCount}</strong>条新闻
			</span>
		</div>
		<span class="clr"></span>
	</div>
</div>

<div id="plist" class="m plist-n7 plist-n8 prebuy">
	<ul class="list-h">
		<c:forEach var="item" items="${result.newsList}">
		<li id="${item.id }">
			<div class="lh-wrap">
				<div class="p-name">
					<a target="_blank" href="${item.newsurl}">${item.title}</a>
					<p>${item.summary}<br>来源：<a target="_blank" href="${item.websiteurl}">${item.website}</a> &nbsp; &nbsp; &nbsp; 时间：${item.time}</p>
				</div>
			</div>
		</li>
		</c:forEach>
	</ul>
</div>


<span class="clr"></span>
<div id="Collect_Tip" class="Tip360 w260"></div>

</div><!--<div class="w main">-->
</body>
</html>