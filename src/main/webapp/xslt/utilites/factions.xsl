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
        <div class="page-title">
          <div class="title_left">
          	<form class="form-inline date-range-form" style="position: relative; visibility: hidden;">
			  <div id="select-date-start" class="form-group data">
					<input id="start-date-selected" class="form-control hidden" type="text" style="border:none;" value="{/*/@start_date}"/>
					<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
					<span style="padding-left: 5px; padding-right: 5px;"></span>
					<b class="caret"></b>
			  </div>
			  <div class="form-group">
			  	<label for="exampleInputName2" style="margin-left: 5px; margin-right: 5px;">-</label>
			  </div>
			  <div id="select-date-end" class="form-group data">
				<input id="end-date-selected" class="form-control hidden" type="text" style="border:none;" value="{/*/@end_date}"/>
				<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
				<span style="padding-left: 5px; padding-right: 5px;"></span>
				<b class="caret"></b>
			  </div>
			</form>
          	<!-- 
            <div class="col-md-7 col-sm-7 col-xs-12 form-group pull-right">
				<div class="filter">
					<div id="select-date-end" class="pull-left data" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
						<input id="end-date-selected" class="form-control hidden" type="text" style="border:none;" value="{/*/@end_date}"/>
						<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
						<span style="padding-left: 5px; padding-right: 5px;"></span>
						<b class="caret"></b>
					</div>
					<div class="pull-leftdata" style="background: #fff; cursor: pointer; padding: 5px 10px;">
						-
					</div>
					<div id="select-date-start" class="pull-right data" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
						<input id="start-date-selected" class="form-control hidden" type="text" style="border:none;" value="{/*/@start_date}"/>
						<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
						<span style="padding-left: 5px; padding-right: 5px;"></span>
						<b class="caret"></b>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			 -->
          </div>
          <div class="title_right">
            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right">
            	<!-- 
	            <table class="table">
	            	<tr>
	            		<td class="col-md-4 col-sm-4">
	            			<form class="form-inline">	
				              <div class="form-group">
				              	<label>BGS time:</label>
				              	<select name="update" class="form-control" style="display: inline;">
				              		<xsl:for-each select="time">
				              			<option value="{@value}:00"><xsl:value-of select="@value"/></option>
				              		</xsl:for-each>
				              	</select>
				              </div>
			              	</form>
	            		</td>
	            		<td class="col-md-8 col-sm-8">
	            -->
	            		<!-- 
			              -->
			              <div class="input-group">
							<select name="faction" id="faction" type="text" class="form-control" data-placeholder="Select faction...">
								<option></option>
							</select>
			                <span class="input-group-btn" style="padding-left: 1px;">
			                  <button class="btn btn-default" id="show-faction-info" type="button">Show!</button>
			                </span>
			              </div>
			   <!-- 
	            		</td>
	            	</tr>
	            </table>
	            -->
            </div>
          </div>
        </div>
        <div class="clearfix"></div>
		<div class="col-md-12 col-sm-12 col-xs-12 text-center">
			<ul class="pagination pagination-split">
			</ul>
		</div>
        <div class="clearfix"></div>
        <p id="factions" style="position:relative; height: 100%; overflow-x: hidden; overflow-y: auto;">
        </p>
		<script type="text/javascript" src="{$root}/js/factions.js"></script>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="faction_list">
		<input type="hidden" name="loaded_max_date" value='/*/@maxDate'/>
		<input type="hidden" name="loaded_min_date" value='/*/@minDate'/>
		<table class="table table-bordered">
			<!-- xsl:variable name="colspan" select="1 + count(item[1]/influenceFactions/item[1]/influenceDates/item)"/ -->
			<xsl:for-each select="item">
				<tr>
					<td><h2><xsl:value-of select="field[@name='systemName']/@value"/></h2></td>
					<xsl:for-each select="influenceFactions/item[1]/influenceDates/item">
						<th class="faction-border can-hided hidden" style="padding-top:20px;"><nobr><xsl:value-of select="field[@name='date']/@value"/></nobr></th>
					</xsl:for-each>
				</tr>
				<xsl:for-each select="influenceFactions/item">
					<tr>
						<xsl:variable name="is_current">
							<xsl:if test="field[@name='factionId']/@value = /*/@faction_id">faction-current</xsl:if>
						</xsl:variable>
						<td class="{$is_current}">
							<nobr><xsl:value-of select="field[@name='factionName']/@value"/></nobr>
							<br/>
							<small><nobr><xsl:value-of select="item[@name='factionInfo']/field[@name='allegiance']/@value"/> / <xsl:value-of select="item[@name='factionInfo']/field[@name='government']/@value"/></nobr></small> 
						</td>
						<xsl:for-each select="influenceDates/item">
							<xsl:variable name="class">
								<xsl:if test="string-length(field[@name='influence']/@value) != 0 and field[@name='inherited']/@value = 'true'">faction-inherited</xsl:if>
							</xsl:variable>
							<td class="{$is_current} can-hided hidden {$class}">
								<xsl:if test="string-length(field[@name='influence']/@value) != 0">
									<xsl:value-of select="round(number(field[@name='influence']/@value) * 10000) div 100"/>%
									<xsl:value-of select="i10n:tr(field[@name='state']/@value)"/>
								</xsl:if>
							</td>
						</xsl:for-each>
					</tr>
				</xsl:for-each>
			</xsl:for-each>
		</table>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>