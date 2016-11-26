<%@page import="org.c3s.content.ContentObject"%>
<%@page import="org.c3s.edgo.utils.I10N"%>
<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%
	String l = (String)ContentObject.getInstance().getFixedParameter("language_id");
%>
<form class="login-form">
    <div class="form-group">
    	<input type="hidden" id="__common"/> 
    </div>
    <div class="form-group">
        <input type="text" placeholder="Email" class="form-control" id="email" name="email"/>
    </div>
    <div class="form-group">
        <input type="password" placeholder="<%=I10N.tr("Password", l) %>" class="form-control" id="password" name="password"/>
    </div>
    <button type="submit" class="btn btn-default"><%=I10N.tr("login", l) %></button>
</form>
    