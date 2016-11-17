<%-- 
    Document   : index
    Created on : 16.03.2010, 23:13:13
    Author     : admin
--%>
<%@page import="org.c3s.web.debug.Debug"%>
<%@page import="org.c3s.content.PathElement"%>
<%@page import="java.util.List"%>
<%@page import="org.c3s.content.ContentObject"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@page import="org.c3s.web.context.PageRequestContext"%>
<%@taglib prefix="c3s" uri="http://c3s-project.org/c3s-taglib"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ContentObject cms = ContentObject.getInstance();

	String root = cms.getFixedParameter("root").toString();
	
	String langs = cms.getData("langs");
	String path_ctx = cms.getData("path");

	String[] params = {"type:main"};
	String main_menu = cms.getData("menu_main", params);

	String content = cms.getData("content");
	content += cms.getData("view_ctx");
	content += cms.getData("form_ctx");
	
	String includeFile = cms.getInclude("content_include");
	try {
		if (includeFile != null) {
			if (!includeFile.endsWith(".jsp")) {
				content += cms.getIncludeContent("content_include");
				includeFile = null;
			} else if (!includeFile.startsWith("/")) {
				includeFile = "/" + includeFile;
			}
		}
	} catch (Exception e) {
		Debug.getInstance().out(e.getMessage(), Debug.E_ALL);
	}

	List<PathElement> path = cms.getPath();
	String title = path.get(path.size()-1).getTitle();

%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>E:D - <%=title%></title>
<link rel="stylesheet" href="<%=root%>/css/bootstrap/dark-theme.min.css"/>
<!-- 
<link rel="stylesheet" href="<%=root%>/css/theme/helper.css"/>
<link rel="stylesheet" href="<%=root%>/css/theme/style.css"/>
<link rel="stylesheet" href="<%=root%>/css/bootstrap/bootstrap.min.css"/>
<link rel="stylesheet" href="<%=root%>/css/chosen.css" type="text/css"/>
<link rel="stylesheet" href="<%=root%>/css/bootstrap-chosen.css" type="text/css"/>
 -->
<link rel="stylesheet" href="<%=root%>/css/sites.css" type="text/css"/>
<script type="text/javascript">
	site_root = "<%=root%>";
</script>

<script type="text/javascript" src="<%=root%>/js/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="<%=root%>/js/form/jquery.form.js"></script>
<script type="text/javascript" src="<%=root%>/js/json/jquery.json.min.js"></script>
<script type="text/javascript" src="<%=root%>/js/chosen/chosen.jquery.min.js"></script>
<script type="text/javascript" src="<%=root%>/js/chosen/ajax-chosen.js"></script>
<script type="text/javascript" src="<%=root%>/js/bootstrap/bootstrap.min.js"></script>

<script type="text/javascript" src="<%=root%>/js/proxy.js"></script>
<script type="text/javascript" src="<%=root%>/js/store.js"></script>
<script type="text/javascript" src="<%=root%>/js/validate.js"></script>
<script type="text/javascript" src="<%=root%>/js/form.js"></script>

</head>
<body>
	
	<div class="container">
		<div class=row>
			<div class="pull-right"><%=langs%></div>
		</div>
		<div class=row>
			<div class="col-md-3">
			</div>		
			<div class="col-md-9">
				<%=path_ctx%>
			</div>
		</div>
		<div class=row>
			<div class="col-md-3">
		 		<%=main_menu%>
			</div>		
			<div class="col-md-9">
				<h2><%=title%></h2>
		 		<%=content%>
		 		<% if (includeFile != null) { %>
		 		<jsp:include page="<%=includeFile%>"/>
		 		<% } %>
			</div>
			<!-- 		
			<div class="col-md-2">right</div>
			 -->		
		</div>
	</div>
</body>
</html>
<c3s:debug level="E_ALL"/>
<%-- 
--%>

