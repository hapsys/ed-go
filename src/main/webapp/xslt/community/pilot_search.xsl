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
            <div class="col-md-5 col-sm-5 col-xs-12 input-group form-group pull-right ">
            	<span class="input-group-addon"><i class="fa fa-search fa-fw"></i></span>
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
											<p class="search-pilot-ranks">
												<img id="combat" width="30" height="30" title="Combat rank" src="{$root}/images/ranks/combat/rank-1.png"/>
												<img id="trade" width="30" height="30" title="Trade rank" src="{$root}/images/ranks/trade/rank-1.png"/>
												<img id="explore" width="30" height="30" title="Explorer rank" src="{$root}/images/ranks/explore/rank-1.png"/>
											</p>
											<p>
												&#160;
											</p>
											 -->
										</div>
									</div>
									<div class="col-xs-12 bottom text-center">
										<div class="col-xs-12 col-sm-5 emphasis">
											<p class="pilot-result-action">
												<a href="#" class="action-friendship" title="Request friendship"><span class="fa fa-handshake-o"></span></a>
												<a href="#" class="action-observe" title="Observe"><span class="fa fa-eye"></span></a>
												<a href="#" class="action-message" title="Send message"><span class="fa fa-envelope-o"></span></a>
											</p>
										</div>
										<div class="col-xs-12 col-sm-7 emphasis">
											<p class="pilot-result-links">
												<a href="#" class="access_blog" title="Pilot page"><span class="fa fa-address-card-o"></span></a>
												<a href="#" class="access_activity" title="Pilot activity"><span class="fa fa-bar-chart"></span></a>
												<a href="#" class="access_systems" title="Pilot systems path"><span class="fa fa-star-o"></span></a>
												<a href="#" class="access_ships" title="Pilot ships"><span class="fa fa-rocket"></span></a>
												<a href="#" class="access_missions" title="Pilot missions"><span class="fa fa-bolt"></span></a>
												<a href="#" class="access_powers" title="Pilot power play"><span class="fa fa-flag"></span></a>
												<a href="#" class="access_materials" title="Pilot materials"><span class="fa fa-tint"></span></a>
												<a href="#" class="access_gallery" title="Pilot gallery"><span class="fa fa-image"></span></a>
											</p>
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