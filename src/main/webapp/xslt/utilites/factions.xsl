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
            <h3></h3>
          </div>
          <div class="title_right">
            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
              <div class="input-group">
				<select name="faction" id="faction" type="text" class="form-control" data-placeholder="Select faction...">
					<option></option>
				</select>
                <span class="input-group-btn" style="padding-left: 1px;">
                  <button class="btn btn-default" id="show-faction-info" type="button">Show!</button>
                </span>
              </div>
            </div>
          </div>
        </div>
        <div class="clearfix"></div>
        <p id="factions">
        </p>
		<script type="text/javascript" src="{$root}/js/factions.js"></script>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="faction_list">
		<table class="table table-bordered">
			<!-- xsl:variable name="colspan" select="1 + count(item[1]/influenceFactions/item[1]/influenceDates/item)"/ -->
			<xsl:for-each select="item">
				<tr>
					<td><h2><xsl:value-of select="field[@name='systemName']/@value"/></h2></td>
					<xsl:for-each select="influenceFactions/item[1]/influenceDates/item">
						<th class="faction-border" style="padding-top:20px;"><xsl:value-of select="field[@name='date']/@value"/></th>
					</xsl:for-each>
				</tr>
				<xsl:for-each select="influenceFactions/item">
					<tr>
						<xsl:variable name="is_current">
							<xsl:if test="field[@name='factionId']/@value = /*/@faction_id">faction-current</xsl:if>
						</xsl:variable>
						<td class="{$is_current}">
							<xsl:value-of select="field[@name='factionName']/@value"/>
							<br/>
							<small><xsl:value-of select="item[@name='factionInfo']/field[@name='allegiance']/@value"/> / <xsl:value-of select="item[@name='factionInfo']/field[@name='government']/@value"/></small> 
						</td>
						<xsl:for-each select="influenceDates/item">
							<xsl:variable name="class">
								<xsl:if test="string-length(field[@name='influence']/@value) != 0 and field[@name='inherited']/@value = 'true'">faction-inherited</xsl:if>
							</xsl:variable>
							<td class="{$is_current} {$class}">
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