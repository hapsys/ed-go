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
%>
<div class="login">
<style  type="text/css" scoped>
	<% if (isLogin) { %>
.registration_form {
  z-index: 21;
  opacity: 0;
  width: 100%; }

.login_form {
  z-index: 22; }
	<% } else { %>
.registration_form {
  z-index: 22; }

.login_form {
  z-index: 21;
  opacity: 0;
  width: 100%; }
	
	<% } %>
</style>
	<div>
		<a class="hiddenanchor" id="signup"></a> 
		<a class="hiddenanchor" id="signin"></a>

		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
					<form action="" class="login-form">
						<h1>Login To Site</h1>
						<div>
							<input type="hidden"id="__common"/>
						</div>
						<div>
							<input type="text" class="form-control" placeholder="Email" id="email" name="email"/>
						</div>
						<div>
							<input type="password" class="form-control" placeholder="Password" id="password" name="password"/>
						</div>
						<div style="margin-bottom: 20px; text-align: left;">
							<input type="checkbox" class="form-control flat" id="store" name="store" checked="checked"/>
							stay logged
						</div>
						<div>
							<button type="submit" class="btn btn-default submit">Log in</button> <a
								class="reset_pass" href="<%=root%>/account/restore/">Lost your password?</a>
						</div>

						<div class="clearfix"></div>

						<div class="separator">
							<p class="change_link">
								New to site? <a href="#signup" class="to_register clear-errors"> Create
									Account </a>
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

			<div id="register" class="animate form registration_form">
				<section class="login_content">
					<form action="" class="register-form">
						<h1>Create Account</h1>
						<div>
							<input type="hidden"id="__common"/>
						</div>
						<div>
							<input type="email" class="form-control" placeholder="Email" name="regemail" id="regemail"/>
						</div>
						<div>
							<input type="password" class="form-control" placeholder="Password"  name="regpassword" id="regpassword"/>
						</div>
						<div>
							<input type="password" class="form-control" placeholder="Confirm Password" name="regconfirm" id="regconfirm"/>
						</div>
						<div>
 							<button type="submit" class="btn btn-default submit">Submit</button>
						</div>
						<div class="clearfix"></div>
						<div class="separator">
							<p class="change_link">
								Already a member ? <a href="#signin" class="to_register clear-errors">
									Log in </a>
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
</div>
