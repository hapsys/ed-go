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
	String lang_id = cms.getFixedParameter("language_id").toString();
	String isDefault = cms.getFixedParameter("default").toString();
	
	String rootLang = root + ("true".equals(isDefault)?"":"/" + lang_id);
	
	String langs = cms.getData("langs");
	String path_ctx = cms.getData("path");

	String[] params = {"type:main"};
	String main_menu = cms.getData("menu_main", params);
	String user_menu = cms.getData("menu_main", new String[]{"type:user"}, ContentObject.CONTENT_LAST, "_____user_menu");

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
	
	//
	String markdown = cms.getData("markdown");
%>
<!DOCTYPE html>
<html lang="<%=lang_id%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ED - <%=title%></title>

<!-- Bootstrap -->
<link href="<%=root%>/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="<%=root%>/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!-- NProgress -->
<link href="<%=root%>/vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="<%=root%>/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- bootstrap-progressbar -->
<link href="<%=root%>/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
<!-- JQVMap -->
<link href="<%=root%>/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
<!-- Animate.css -->
<link href="<%=root%>/vendors/animate.css/animate.min.css" rel="stylesheet">
<!-- Datepicker.css -->
<link href="<%=root%>/vendors/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<!-- Switchery -->
<link href="<%=root%>/vendors/switchery/dist/switchery.min.css" rel="stylesheet">
<!-- Datatables -->
<link href="<%=root%>/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="<%=root%>/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
<link href="<%=root%>/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="<%=root%>/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
<link href="<%=root%>/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

<!-- Choosen -->
<link rel="stylesheet" href="<%=root%>/css/chosen.css" type="text/css"/>
<link rel="stylesheet" href="<%=root%>/css/bootstrap-chosen.css" type="text/css"/>
<!-- Custom Theme Style -->
<link href="<%=root%>/css/custom/custom.css" rel="stylesheet">

<link rel="stylesheet" href="<%=root%>/css/sites.css"  rel="stylesheet">
<script type="text/javascript">
	site_root = "<%=rootLang%>";
</script>

<!-- jQuery -->
<script src="<%=root%>/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="<%=root%>/vendors/moment/min/moment-with-locales.min.js"></script>

<script src="<%=root%>/vendors/bootstrap/js/transition.js"></script>
<script src="<%=root%>/vendors/bootstrap/js/collapse.js"></script>
<script src="<%=root%>/vendors/bootstrap/dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
moment.locale('<%=lang_id%>');
</script>

</head>
<body>
  <body class="nav-md">
  	<!-- Popup -->
  	<div class="popup">
	    <div class="popup-item">
	        <img src="<%=root%>/images/preloader.png" alt="" />
	        <div>Please wait...</div>
	    </div>
	</div>
  	<!-- Popup -->
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col menu_fixed">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="<%=root%>/" class="site_title"><i class="fa fa-eye"></i><span style="font-size: 18px;"> ED Global Observer</span></a>
            </div>

            <div class="clearfix"></div>
		
            <!-- menu profile quick info -->
            
            <!-- 
            <div class="profile">
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>John Doe</h2>
              </div>
            </div>
            -->
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <%=main_menu%>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>
              <ul class="nav navbar-nav navbar-right">
              	<%=user_menu%>
              	<!-- 
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="<%=root%>/images/img.jpg" alt="">hapsys@mmmm.nnn
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>
                -->

				<!-- 
                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">6</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>See All Alerts</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
                -->
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
        	<div>
	            <div class="page-title">
	              <div class="title_left">
	        		<div><%=path_ctx%></div>
	                <h3><%=title%></h3>
	              </div>
	              <div class="title_right">
	                <div class="col-md-5 col-sm-5 col-xs-12 pull-right text-right">
	                	<%=langs%>
	                </div>
	              </div>
	            </div>
	
	            <div class="clearfix"></div>
	            <%=content%>
		 		<% if (includeFile != null) { %>
		 		<jsp:include page="<%=includeFile%>"/>
		 		<% } %>
		 		<%=markdown%>
	 		</div>
        </div>
        <!-- /page content -->
        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>
	
	
</body>
    <!-- FastClick -->
    <script src="<%=root%>/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="<%=root%>/vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="<%=root%>/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="<%=root%>/vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="<%=root%>/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- bootstrap-datetimepicker -->
    <script src="<%=root%>/vendors/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <!-- iCheck -->
    <script src="<%=root%>/vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="<%=root%>/vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="<%=root%>/vendors/Flot/jquery.flot.js"></script>
    <script src="<%=root%>/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="<%=root%>/vendors/Flot/jquery.flot.time.js"></script>
    <script src="<%=root%>/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="<%=root%>/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="<%=root%>/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="<%=root%>/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="<%=root%>/vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="<%=root%>/vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="<%=root%>/vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="<%=root%>/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="<%=root%>/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- jQuery Sparklines -->
    <script src="<%=root%>/vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
    <!-- easy-pie-chart -->
    <script src="<%=root%>/vendors/jquery.easy-pie-chart/dist/jquery.easypiechart.min.js"></script>
    <!-- Switchery -->
    <script src="<%=root%>/vendors/switchery/dist/switchery.min.js"></script>

    <!-- Clipboard -->
    <script src="<%=root%>/vendors/clipboard.js/clipboard.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="<%=root%>/js/custom/custom.js"></script>
    <!-- Choosen -->
	<script type="text/javascript" src="<%=root%>/js/chosen/chosen.jquery.min.js"></script>
	<script type="text/javascript" src="<%=root%>/js/chosen/ajax-chosen.js"></script>
    <!-- Json -->
    <script src="<%=root%>/js/json/jquery.json.min.js"></script>

	<script type="text/javascript" src="<%=root%>/js/proxy.js"></script>
	<script type="text/javascript" src="<%=root%>/js/store.js"></script>
	<script type="text/javascript" src="<%=root%>/js/validate.js"></script>
	<script type="text/javascript" src="<%=root%>/js/form.js"></script>
	<script type="text/javascript" src="<%=root%>/js/auto-update.js"></script>
</html>
<c3s:debug level="E_ALL"/>
<%-- 
--%>

