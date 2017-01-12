<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:i10n="org.c3s.edgo.utils.I10N">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:param name="mode"/>
	<xsl:template match="/*">
		<xsl:choose>
			<xsl:when test="$mode = 'pilots_control'"><xsl:call-template name="pilots_control"/></xsl:when>
			<xsl:when test="$mode = 'pilots_control_update'"><xsl:call-template name="pilots_control_update"/></xsl:when>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="pilots_control">
		<div class="row width-650 pilots-content">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						<xsl:value-of select="i10n:tr('pilots-link-title')"/> <small>(<xsl:value-of select="i10n:tr('pilots-link-description')"/>)</small>
					</h2>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<form class="pilots-link-form">
						<div id="loaded-table">
							<xsl:call-template name="pilots_control_update"/>
						</div>
						<p>
							<button type="button" class="btn btn-success update"><xsl:value-of select="i10n:tr('pilots-link-update')"/></button>
						</p>
					</form>
				</div>
			</div>
		</div>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="pilots_control_update">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th><xsl:value-of select="i10n:tr('pilots-link-link')"/></th>
					<th><xsl:value-of select="i10n:tr('pilots-link-name')"/></th>
					<th><xsl:value-of select="i10n:tr('pilots-link-linked')"/></th>
					<th><xsl:value-of select="i10n:tr('pilots-link-ignored')"/></th>
				</tr>
			</thead>
			<tbody>
				<xsl:for-each select="item[field[@name='parentPilotId']/@value = '']">
					<xsl:variable name="pilot_id" select="field[@name='pilotId']/@value"/>
					<tr>
						<td>
							<label><input type="checkbox" class="flat lnk-link" value="{$pilot_id}">
								<xsl:if test="field[@name='isIgnored']/@value = 1">
									<xsl:attribute name="disabled">disabled</xsl:attribute>
								</xsl:if>
							</input></label>
						</td>
						<td><xsl:value-of select="field[@name='pilotName']/@value"/></td>
						<td>
							<xsl:if test="count(/data/item[field[@name='parentPilotId']/@value = $pilot_id]) != 0">
								<ul class="list-unstyled">
									<xsl:for-each select="/data/item[field[@name='parentPilotId']/@value = $pilot_id]">
										<li><abbr title="{i10n:tr('pilots-link-unlink')}"><input type="checkbox" class="flat lnk-unlink" value="{field[@name='pilotId']/@value}" checked="checked"/></abbr>&#160;<xsl:value-of select="field[@name='pilotName']/@value"/></li>
									</xsl:for-each>
								</ul>					
							</xsl:if>
						</td>
						<td>
							<label>
								<input type="checkbox" class="js-switch lnk-hide" value="{$pilot_id}">
									<xsl:if test="field[@name='nameOther']/@value != 0">
										<xsl:attribute name="disabled">disabled</xsl:attribute>
									</xsl:if>
									<xsl:if test="field[@name='isIgnored']/@value = 1">
										<xsl:attribute name="checked">checked</xsl:attribute>
									</xsl:if>
								</input>&#160;<xsl:value-of select="i10n:tr('pilots-link-hidden')"/> 
							</label>
						</td>
					</tr>
				</xsl:for-each>
			</tbody>
		</table>
	</xsl:template>
<!--
//
//
//
-->
	
</xsl:stylesheet>