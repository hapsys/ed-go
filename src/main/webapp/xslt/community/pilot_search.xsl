<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE xsl:stylesheet [
	<!ENTITY nbsp "&#160;">
]>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:i10n="org.c3s.edgo.utils.I10N">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:param name="root"/>
	<xsl:param name="language_id"/>
	<xsl:param name="default"/>
	<xsl:param name="suffix"/>
	<xsl:param name="tournaments"/>
	<xsl:param name="roles"/>
	<xsl:param name="mode"/>
	<xsl:template match="/data">
		<xsl:choose>
			<xsl:when test="$mode = 'canvas'"><xsl:call-template name="canvas"/></xsl:when>
			<xsl:when test="$mode = 'faction_list'"><xsl:call-template name="faction_list"/></xsl:when>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="canvas">
        <div class="page-title pilot-search">
          <div class="title_left">
            <h3></h3>
          </div>
          <div class="title_right">
            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                <input type="text" class="form-control" placeholder="Search for..."/>
            </div>
          </div>
        </div>
        <div class="clearfix"></div>
        <div class="row">
			<div class="col-md-12">
				<div class="x_panel">
					<div class="x_content">
						<div class="row pilot-search-result">
							<div class="pilot-search-details skeleton hidden">
								<div class="well profile_view">
									<div class="col-sm-12">
										<div class="left col-xs-12">
											<h2 class="search-pilot-name">Nicole Pearson</h2>
											<p class="search-pilot-aka">
												<strong>About: </strong>
												Web Designer / UX / Graphic Artist / Coffee Lover
											</p>
											<!-- 
											<ul class="list-unstyled">
												<li>
													<i class="fa fa-building"></i>
													Address:
												</li>
												<li>
													<i class="fa fa-phone"></i>
													Phone #:
												</li>
											</ul>
											 -->
										</div>
									</div>
									<div class="col-xs-12 bottom text-center">
										<div class="col-xs-12 col-sm-6 emphasis">
											<!-- 
											<p class="ratings">
												<a>4.0</a>
												<a href="#">
													<span class="fa fa-star"></span>
												</a>
												<a href="#">
													<span class="fa fa-star"></span>
												</a>
												<a href="#">
													<span class="fa fa-star"></span>
												</a>
												<a href="#">
													<span class="fa fa-star"></span>
												</a>
												<a href="#">
													<span class="fa fa-star-o"></span>
												</a>
											</p>
											-->
										</div>
										<div class="col-xs-12 col-sm-6 emphasis">
											<!--
											<button type="button" class="btn btn-success btn-xs">
												<i class="fa fa-user">
												</i>
												<i class="fa fa-comments-o"></i>
											</button>
											<button type="button" class="btn btn-primary btn-xs">
												<i class="fa fa-user">
												</i>
												View Profile
											</button>
											-->
											&#160;
										</div>
									</div>
								</div>
							</div>
        				</div>
        			</div>
        		</div>
        	</div>
        </div>
		<script type="text/javascript" src="{$root}/js/search.js"></script>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="faction_list">
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>