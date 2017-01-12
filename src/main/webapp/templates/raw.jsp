<%@page import="org.c3s.content.ContentObject"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<% 
	String obj = ContentObject.getInstance().getData("json", new String[]{}, ContentObject.CONTENT_LAST);
	response.addHeader("Access-Control-Allow-Origin", "*");
%><%=obj%>