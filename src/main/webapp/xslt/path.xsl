<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE xsl:stylesheet [
	<!ENTITY nbsp "&#160;">
]>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:param name="root"/>
	<xsl:param name="politic"/>
	<xsl:param name="language_id"/>
	<xsl:param name="default"/>
	<xsl:param name="suffix"/>
	<xsl:param name="roles"/>
	<xsl:param name="pilotEncoded"/>
	<xsl:param name="pilotReal"/>
	<xsl:param name="type"/>
	<xsl:template match="/data">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<xsl:if test="count(item) &gt; 1">
			<ol class="breadcrumb">
				<xsl:for-each select="item"><xsl:choose>
						<xsl:when test="position() != last()">
							<li>
							<a href="{$lang}{@href}" class="text-primary">
								<xsl:value-of select="@title"/><xsl:if test="position() = 2 and string-length($pilotReal) != 0 and contains(@href, concat($pilotEncoded,'/'))">&#160;<xsl:value-of select="$pilotReal"/></xsl:if>
							</a>
							</li>
						</xsl:when>
						<xsl:otherwise></xsl:otherwise>
					</xsl:choose>
				</xsl:for-each>
			</ol>
		</xsl:if>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>