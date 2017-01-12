<%@page import="java.util.Calendar"%>
<%@page import="org.c3s.web.context.ApplicationContext"%>
<%@page import="org.c3s.content.ContentObject"%>
<%@page import="org.c3s.edgo.utils.I10N"%>
<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%
	ContentObject cms = ContentObject.getInstance();
	String lang_id = cms.getFixedParameter("language_id").toString();
%>

		<div class="center_wrapper">
			<div class="center_form">
				<section class="login_content">
					<% if ("ru".equals(lang_id)) { %>
						<div class="text-left">
							<ul>
								<li><a href="https://yadi.sk/d/Y9Azikk233V3PB">Скачать с Yandex Disk</a></li>
							</ul>
							<ul>
								<li><a href="https://github.com/hapsys/ed-go-client">Исходники на github</a></li>
							</ul>
	                    </div>
			        <% } else { %>
						<div class="text-left">
							<ul>
								<li><a href="https://yadi.sk/d/Y9Azikk233V3PB">Download from Yandex Disk</a></li>
							</ul>
							<ul>
								<li><a href="https://github.com/hapsys/ed-go-client">Source files on github</a></li>
							</ul>
	                    </div>
			        <% } %>
                </section>
            </div>
        </div>

