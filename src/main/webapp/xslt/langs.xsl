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
	<xsl:param name="type"/>
	<xsl:template match="/data">
		<xsl:if test="$politic != 'none'">
			<xsl:for-each select="item/itemlist[@name='languages']/item">
				<span class="text-uppercase"><a href="{field[@name='href']/@value}" role="button">
					<xsl:choose>
						<xsl:when test="field[@name='current']/@value = 'true'">
							<xsl:attribute name="class">btn btn-default disabled</xsl:attribute>
						</xsl:when>
						<xsl:otherwise>
							<xsl:attribute name="class">btn btn-default</xsl:attribute>
						</xsl:otherwise>
					</xsl:choose>
					<xsl:value-of select="field[@name='language_id']/@value" disable-output-escaping="yes"/></a>
				</span>
			</xsl:for-each>
		</xsl:if>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>