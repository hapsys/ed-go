<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:i10n="org.c3s.edgo.utils.I10N">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
<!--
//
//
//
-->
	<xsl:template name="lastseen">
		<xsl:param name="lang"/>
		<xsl:param name="sec"/>
		<xsl:param name="min"/>
		<xsl:param name="hou"/>
		<xsl:param name="day"/>
		<xsl:param name="mon"/>
		<xsl:param name="yea"/>
		<xsl:choose>
			<xsl:when test="$lang = 'ru'">
				<xsl:if test="$yea != 0"><xsl:value-of select="$yea"/> г </xsl:if>	
				<xsl:if test="$mon != 0"><xsl:value-of select="$mon"/> мес </xsl:if>	
				<xsl:if test="$day != 0"><xsl:value-of select="$day"/> дн </xsl:if>	
				<xsl:if test="$hou != 0"><xsl:value-of select="$hou"/> час </xsl:if>	
				<xsl:if test="$min != 0"><xsl:value-of select="$min"/> мин </xsl:if>	
				<xsl:if test="$sec != 0"><xsl:value-of select="$sec"/> сек </xsl:if>	
			</xsl:when>
			<xsl:otherwise>
				<xsl:if test="$yea != 0"><xsl:value-of select="$yea"/> y </xsl:if>	
				<xsl:if test="$mon != 0"><xsl:value-of select="$mon"/>mon </xsl:if>	
				<xsl:if test="$day != 0"><xsl:value-of select="$day"/> d </xsl:if>	
				<xsl:if test="$hou != 0"><xsl:value-of select="$hou"/> h </xsl:if>	
				<xsl:if test="$min != 0"><xsl:value-of select="$min"/> min </xsl:if>	
				<xsl:if test="$sec != 0"><xsl:value-of select="$sec"/> sec </xsl:if>	
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	
</xsl:stylesheet>
