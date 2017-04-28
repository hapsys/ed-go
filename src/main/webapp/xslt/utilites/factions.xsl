<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE xsl:stylesheet [
	<!ENTITY nbsp "&#160;">
]>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
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
                <span class="input-group-btn">
                  <button class="btn btn-default" id="show-faction-info" type="button">Go!</button>
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
			<tr>
				<th>System</th>
				<th>Faction</th>
				<xsl:for-each select="item[1]/influenceFactions/item[1]/influenceDates/item">
					<th colspan="2" class="faction-border"><xsl:value-of select="field[@name='date']/@value"/></th>
				</xsl:for-each>
			</tr>
			<xsl:for-each select="item">
				<tr>
					<td rowspan="{count(influenceFactions/item)}"><xsl:value-of select="field[@name='systemName']/@value"/></td>
					<xsl:variable name="is_current">
						<xsl:if test="influenceFactions/item[1]/field[@name='factionId']/@value = /*/@faction_id">faction-current</xsl:if>
					</xsl:variable>
					<td class="{$is_current}"><xsl:value-of select="influenceFactions/item[1]/field[@name='factionName']/@value"/></td>
					<xsl:for-each select="influenceFactions/item[1]/influenceDates/item">
						<xsl:variable name="class">
							<xsl:if test="string-length(field[@name='influence']/@value) != 0 and field[@name='inherited']/@value = 'true'">faction-inherited</xsl:if>
						</xsl:variable>
						<td class="{$is_current} {$class}">
							<xsl:if test="string-length(field[@name='influence']/@value) != 0">
								<xsl:value-of select="floor(number(field[@name='influence']/@value) * 100)"/>%
							</xsl:if>
						</td>
						<td class="{$class}"><xsl:value-of select="field[@name='state']/@value"/></td>
					</xsl:for-each>
				</tr>
				<xsl:for-each select="influenceFactions/item">
					<xsl:if test="position() != 1">
						<tr>
							<xsl:variable name="is_current">
								<xsl:if test="field[@name='factionId']/@value = /*/@faction_id">faction-current</xsl:if>
							</xsl:variable>
							<td class="{$is_current}"><xsl:value-of select="field[@name='factionName']/@value"/></td>
							<xsl:for-each select="influenceDates/item">
								<xsl:variable name="class">
									<xsl:if test="string-length(field[@name='influence']/@value) != 0 and field[@name='inherited']/@value = 'true'">faction-inherited</xsl:if>
								</xsl:variable>
								<td class="{$is_current} {$class}">
									<xsl:if test="string-length(field[@name='influence']/@value) != 0">
										<xsl:value-of select="floor(number(field[@name='influence']/@value) * 100)"/>%
									</xsl:if>
								</td>
								<td class="{$is_current} {$class}"><xsl:value-of select="field[@name='state']/@value"/></td>
							</xsl:for-each>
						</tr>
					</xsl:if>
				</xsl:for-each>
				<xsl:if test="position() != last()">
					<tr class="faction-delimer">
						<xsl:variable name="colspan" select="2 + 2 * count(influenceFactions/item[1]/influenceDates/item)"/>
						<td colspan="{$colspan}">&#160;</td>
					</tr>
				</xsl:if>
			</xsl:for-each>
		</table>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>