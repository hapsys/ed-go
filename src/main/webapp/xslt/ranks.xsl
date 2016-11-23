<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template name="combat">
		<xsl:param name="rank"/>
		<xsl:param name="lang"/>
		<xsl:choose>
			<xsl:when test="$rank = 8">Elite</xsl:when>
			<xsl:when test="$rank = 7">Deadly</xsl:when>
			<xsl:when test="$rank = 6">Dangerous</xsl:when>
			<xsl:when test="$rank = 5">Master</xsl:when>
			<xsl:when test="$rank = 4">Expert</xsl:when>
			<xsl:when test="$rank = 3">Competent</xsl:when>
			<xsl:when test="$rank = 2">Novice</xsl:when>
			<xsl:when test="$rank = 1">Mostly Harmless</xsl:when>
			<xsl:otherwise>Harmless</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="trade">
		<xsl:param name="rank"/>
		<xsl:param name="lang"/>
		<xsl:choose>
			<xsl:when test="$rank = 8">Elite</xsl:when>
			<xsl:when test="$rank = 7">Tycoon</xsl:when>
			<xsl:when test="$rank = 6">Entrepreneur</xsl:when>
			<xsl:when test="$rank = 5">Broker</xsl:when>
			<xsl:when test="$rank = 4">Merchant</xsl:when>
			<xsl:when test="$rank = 3">Dealer</xsl:when>
			<xsl:when test="$rank = 2">Peddler</xsl:when>
			<xsl:when test="$rank = 1">Mostly Pennliess</xsl:when>
			<xsl:otherwise>Penniless</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="explore">
		<xsl:param name="rank"/>
		<xsl:param name="lang"/>
		<xsl:choose>
			<xsl:when test="$rank = 8">Elite</xsl:when>
			<xsl:when test="$rank = 7">Pioneer</xsl:when>
			<xsl:when test="$rank = 6">Ranger</xsl:when>
			<xsl:when test="$rank = 5">Pathfinder</xsl:when>
			<xsl:when test="$rank = 4">Explorer</xsl:when>
			<xsl:when test="$rank = 3">Surveyor</xsl:when>
			<xsl:when test="$rank = 2">Scout</xsl:when>
			<xsl:when test="$rank = 1">Mostly Aimless</xsl:when>
			<xsl:otherwise>Aimless</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="cqc">
		<xsl:param name="rank"/>
		<xsl:param name="lang"/>
		<xsl:choose>
			<xsl:when test="$rank = 8">Elite</xsl:when>
			<xsl:when test="$rank = 7">Legend</xsl:when>
			<xsl:when test="$rank = 6">Hero</xsl:when>
			<xsl:when test="$rank = 5">Champion</xsl:when>
			<xsl:when test="$rank = 4">Professional</xsl:when>
			<xsl:when test="$rank = 3">Semi Professional</xsl:when>
			<xsl:when test="$rank = 2">Amateur</xsl:when>
			<xsl:when test="$rank = 1">Mostly Helpless</xsl:when>
			<xsl:otherwise>Helpless</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="empire">
		<xsl:param name="rank"/>
		<xsl:param name="lang"/>
		<xsl:choose>
			<xsl:when test="$rank = 14">King</xsl:when>
			<xsl:when test="$rank = 13">Prince</xsl:when>
			<xsl:when test="$rank = 12">Duke</xsl:when>
			<xsl:when test="$rank = 11">Marquis </xsl:when>
			<xsl:when test="$rank = 10">Earl</xsl:when>
			<xsl:when test="$rank = 9">Count</xsl:when>
			<xsl:when test="$rank = 8">Viscount </xsl:when>
			<xsl:when test="$rank = 7">Baron</xsl:when>
			<xsl:when test="$rank = 6">Lord</xsl:when>
			<xsl:when test="$rank = 5">Knight</xsl:when>
			<xsl:when test="$rank = 4">Squire</xsl:when>
			<xsl:when test="$rank = 3">Master</xsl:when>
			<xsl:when test="$rank = 2">Serf</xsl:when>
			<xsl:when test="$rank = 1">Outsider</xsl:when>
			<xsl:otherwise>None</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="federation">
		<xsl:param name="rank"/>
		<xsl:param name="lang"/>
		<xsl:choose>
			<xsl:when test="$rank = 14">Admiral</xsl:when>
			<xsl:when test="$rank = 13">Vice Admiral</xsl:when>
			<xsl:when test="$rank = 12">Rear Admiral</xsl:when>
			<xsl:when test="$rank = 11">Post Captain</xsl:when>
			<xsl:when test="$rank = 10">Post Commander</xsl:when>
			<xsl:when test="$rank = 9">Lt. Commander</xsl:when>
			<xsl:when test="$rank = 8">Lieutenant</xsl:when>
			<xsl:when test="$rank = 7">Ensign</xsl:when>
			<xsl:when test="$rank = 6">Warrant Officer</xsl:when>
			<xsl:when test="$rank = 5">Chief Petty Officer</xsl:when>
			<xsl:when test="$rank = 4">Petty Officer</xsl:when>
			<xsl:when test="$rank = 3">Midshipman</xsl:when>
			<xsl:when test="$rank = 2">Cadet</xsl:when>
			<xsl:when test="$rank = 1">Recruit</xsl:when>
			<xsl:otherwise>None</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>