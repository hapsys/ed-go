<%@page import="org.c3s.utils.JSONUtils"%><%@page import="com.google.gson.Gson"%><%@page import="org.c3s.content.ContentObject"%><%@page language="java" contentType="application/json"%><% 
	Object obj = ContentObject.getInstance().getObject("json");
	String result = JSONUtils.toJson(obj);
	//response.addHeader("Content-Type", "application/json");
	response.addHeader("Access-Control-Allow-Origin", "*");
%><%=result%>