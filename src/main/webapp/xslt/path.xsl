<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE xsl:stylesheet [
	<!ENTITY nbsp "&#160;">
]>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:template match="/data">
		<!--
		<a href="/index.html">Главная</a> 
		<xsl:for-each select="item"><xsl:text disable-output-escaping="yes">  &amp;raquo; </xsl:text><xsl:choose>
				<xsl:when test="position() != last()">
					<a href="{field[@name='href']/@value}"><xsl:value-of select="field[@name='title']/@value"/></a>
				</xsl:when>
				<xsl:otherwise><xsl:value-of select="field[@name='title']/@value"/></xsl:otherwise>
			</xsl:choose>
		</xsl:for-each>
		-->
		<xsl:if test="count(item) &gt; 0">
			<div class="nav">
				<a href="/">Главная</a>
				<xsl:for-each select="item"><xsl:choose>
						<xsl:when test="position() != last()"><xsl:text disable-output-escaping="yes">  &amp;raquo; </xsl:text><a href="{field[@name='href']/@value}"><xsl:value-of select="field[@name='title']/@value"/></a></xsl:when>
						<xsl:otherwise><!-- xsl:value-of select="field[@name='title']/@value"/ --></xsl:otherwise>
					</xsl:choose>
				</xsl:for-each>
			</div>
		</xsl:if>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>