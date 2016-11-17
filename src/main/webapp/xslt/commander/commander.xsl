<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:param name="root"/>
	<xsl:param name="politic"/>
	<xsl:param name="language_id"/>
	<xsl:param name="default"/>
	<xsl:param name="suffix"/>
	<xsl:param name="tournaments"/>
	<xsl:param name="roles"/>
	<xsl:param name="mode"/>
	<xsl:template match="/*">
		<xsl:choose>
			<xsl:when test="$mode = 'info'"><xsl:call-template name="view_info"/></xsl:when>
			<xsl:when test="$mode = 'ships'"><xsl:call-template name="view_ships"/></xsl:when>
			<xsl:when test="$mode = 'view_ship'"><xsl:call-template name="view_ship"/></xsl:when>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_info">
	
			<div><h5><xsl:value-of select="field[@name='pilotName']/@value"/></h5></div>
		
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_ships">
	
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<div><h5><xsl:value-of select="field[@name='pilotName']/@value"/></h5></div>

		<div>
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Ship</th>
						<th>System</th>
						<th>#</th>
						<th>Ship</th>
						<th>System</th>
					</tr>
				</thead>
				<tbody>
					<xsl:for-each select="itemlist[@name='pilotShips']/item">
						<xsl:sort case-order="upper-first" data-type="text" order="ascending" select="field[@name='ship']/field[@name='name']/@value"/>
						<xsl:if test="position() mod 2 = 1"><xsl:text disable-output-escaping="yes">&lt;tr&gt;</xsl:text></xsl:if>
							<td>
								<xsl:value-of select="field[@name='linkShipId']/@value"/>
							</td>
							<td>
								<a href="{$lang}/{../../field[@name='pilotName']/@value}/ships/{field[@name='linkShipId']/@value}/">
									<xsl:value-of select="field[@name='ship']/field[@name='name']/@value"/>
								</a>
							</td>
							<td>
							</td>
						<xsl:if test="position() mod 2 = 0"><xsl:text disable-output-escaping="yes">&lt;/tr&gt;</xsl:text></xsl:if>
					</xsl:for-each>
					<xsl:if test="count(itemlist[@name='pilotShips']/item) mod 2 = 1"><td colspan="3"></td><xsl:text disable-output-escaping="yes">&lt;/tr&gt;</xsl:text></xsl:if>
				</tbody>
				
			</table>

		
		</div>
	
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_ship">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<table class="table">
			<thead>
				<tr>
					<th class="col-md-3">Weapon</th>
					<th class="col-md-3">Utility</th>
					<th class="col-md-3">Essential</th>
					<th class="col-md-3">Internal</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<xsl:for-each select="itemlist/item[field[@name='slot']/field[@name='slotType']/field[@name='id']/@value='50']">
							<xsl:sort case-order="upper-first" data-type="text" order="ascending" select="field[@name='slot']/field[@name='uniq']/@value"/>
							<div><xsl:call-template name="module_name"/></div>
						</xsl:for-each>
					</td>
					<td>
						<xsl:for-each select="itemlist/item[field[@name='slot']/field[@name='slotType']/field[@name='id']/@value='10']">
							<xsl:sort case-order="upper-first" data-type="text" order="ascending" select="field[@name='slot']/field[@name='uniq']/@value"/>
							<div><xsl:call-template name="module_name"/></div>
						</xsl:for-each>
					</td>
					<td>
						<xsl:for-each select="itemlist/item[field[@name='slot']/field[@name='slotType']/field[@name='id' and (@value='30' or @value='40')]]">
							<xsl:sort case-order="upper-first" data-type="text" order="ascending" select="field[@name='slot']/field[@name='uniq']/@value"/>
							<div><xsl:call-template name="module_name"/></div>
						</xsl:for-each>
					</td>
					<td>
						<xsl:for-each select="itemlist/item[field[@name='slot']/field[@name='slotType']/field[@name='id']/@value='20']">
							<xsl:sort case-order="upper-first" data-type="text" order="ascending" select="field[@name='slot']/field[@name='uniq']/@value"/>
							<div><xsl:call-template name="module_name"/></div>
						</xsl:for-each>
					</td>
				</tr>
			</tbody>
		</table>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="module_name">
		<xsl:choose>
			<xsl:when test="string-length(field[@name='module']/field[@name='name']/@value) = 0">
				<xsl:value-of select="field[@name='module']/field[@name='moduleGroup']/field[@name='name']/@value"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="field[@name='module']/field[@name='name']/@value"/>
			</xsl:otherwise>
		</xsl:choose>		
		<xsl:text> - </xsl:text><xsl:value-of select="field[@name='module']/field[@name='moduleRating']/@value"/><xsl:value-of select="field[@name='module']/field[@name='moduleClass']/@value"/>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>