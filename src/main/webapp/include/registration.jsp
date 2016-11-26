<%@page import="org.c3s.content.ContentObject"%>
<%@page import="org.c3s.edgo.utils.I10N"%>
<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%
	String l = (String)ContentObject.getInstance().getFixedParameter("language_id");
	String root = (String)ContentObject.getInstance().getFixedParameter("root");
%>
<div class="content-wrapper clearfix">
	<div class="content-header">
		<h4>
			CREATE YOUR DASHBOARD ACCOUNT
		</h4>
	</div>
	<div class="panel">
		<div class="panel-body">
			<div class="panel-body-form">
				<form action="" class="register-form">
					<div class="form-group">
						<input type="email" placeholder="Email" class="form-control" name="email"/>
					</div>
					<div class="row">
						<div class="col-xs-6">
							<div class="form-group">
								<input type="password" placeholder="<%=I10N.tr("Password", l) %>" class="form-control" name="password"/>
							</div>
						</div>
						<div class="col-xs-6">
							<div class="form-group">
								<input type="password" placeholder="<%=I10N.tr("Repeat Password", l) %>" class="form-control" name="confirm"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
							<p><input type="checkbox" id="agree-terms-service" class="checkbox" name="capabilities"/><label for="agree-terms-service"> By selecting the checkbox you agree to ED-GO Dashboard <a href="#">Terms
								of Service.</a></label></p>
							</div>
						</div>
					</div>
					<button id="create-account" type="submit" class="btn btn-primary" disabled="disabled" >CREATE YOUR DASHBOARD ACCOUNT</button>
				</form>
			</div>
		</div>
		<div class="panel-footer clearfix">
			Already have an account? <a href="<%=root%>/account/login/">Login</a>
		</div>
	</div>
</div>