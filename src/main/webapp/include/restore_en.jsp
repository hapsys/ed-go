<%@page import="java.util.Calendar"%>
<%@page import="org.c3s.web.context.ApplicationContext"%>
<%@page import="org.c3s.content.ContentObject"%>
<%@page import="org.c3s.edgo.utils.I10N"%>
<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%
	ContentObject cms = ContentObject.getInstance();
	boolean isLogin = cms.getFixedParameter("current_url").toString().endsWith("login/");
	String root = cms.getFixedParameter("root").toString();
	String lang_id = cms.getFixedParameter("language_id").toString();
	String isDefault = cms.getFixedParameter("default").toString();
	String rootLang = root + ("true".equals(isDefault)?"":"/" + lang_id);
%>
<div class="login">

  <div class="login_wrapper">
    <div class="animate form login_form">
      <section class="login_content">
        <form class="restore-form">
			<h1>New password</h1>
        	<section class="form-section">
				<div>
					<input type="hidden"id="__common"/>
				</div>
				<div>
					<input type="text" class="form-control" placeholder="Email" id="email" name="email"/>
				</div>
				<div>
				  <button type="submit" class="btn btn-default submit">Get password</button>
				</div>
			</section>
        	<section class="result-section hidden">
        		<h4>See new password at your email: <span></span></h4>
        	</section>
          <div class="clearfix"></div>

			<div class="separator">
				<p class="change_link">
					<a href="<%=rootLang%>/account/login/" class="clear-errors"> Log In </a> <a href="<%=rootLang%>/account/registration/" class="clear-errors"> Create Account </a>
				</p>
	
				<div class="clearfix"></div>
				<br />
				<div>
					<h1>
						<i class="fa fa-eye"></i> ED Global Observer
					</h1>
					<p>©2016-<%=Calendar.getInstance().get(Calendar.YEAR)%> All Rights Reserved ED Global Observer Team. Privacy and Terms</p>
				</div>
			</div>
        </form>
      </section>
    </div>
  </div>
</div>
