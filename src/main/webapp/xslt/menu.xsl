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
	<xsl:param name="tournaments"/>
	<xsl:param name="roles"/>
	<xsl:param name="pilot"/>
	<xsl:param name="user"/>
	<xsl:param name="type"/>
	<xsl:template match="/menu">
		<xsl:choose>
			<xsl:when test="$type = 'main'"><xsl:call-template name="main"/></xsl:when>
			<xsl:when test="$type = 'user'"><xsl:call-template name="user"/></xsl:when>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="main">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
         	<div class="menu_section">
	            <h3>&nbsp;</h3>
	            <ul class="nav side-menu">
					<xsl:call-template name="drawLevel">
						<xsl:with-param name="level" select="number(0)"/>
						<xsl:with-param name="items" select="node/node[count(menu[@name='main_menu']) != 0]"/>
						<xsl:with-param name="pattern" select="$lang"/>
					</xsl:call-template>
				</ul>
			</div>
		</div>
	</xsl:template>
<!--
//
//
//
-->
<xsl:template name="drawLevel">
	<xsl:param name="level"/>
	<xsl:param name="items"/>
	<xsl:param name="pattern"/>
	<xsl:if test="count($items) != 0">
		<xsl:variable name="padding" select="$level * 20"/>
		<xsl:for-each select="$items">
			<xsl:variable name="item" select="current()"/>
			<xsl:variable name="class">
				<xsl:choose>
					<xsl:when test="string-length(@class) != 0"><xsl:value-of select="@class"/></xsl:when>
				</xsl:choose>
			</xsl:variable>
			<xsl:if test="string-length(condition) = 0 or contains($tournaments, concat('|',condition,'|'))">
				<xsl:variable name="role"><xsl:call-template name="checkRoles"/></xsl:variable>
				<xsl:if test="count(role) = 0 or $role = 'true'">
					<xsl:choose>
						<xsl:when test="@pilot='true'">
							<xsl:for-each select="/menu/pilots/pilot">
								<li>
								<xsl:choose>
									<xsl:when test="$level = 0">
										<a><i class="fa {$class}"></i><xsl:call-template name="getTitle"><xsl:with-param name="item" select="$item"/></xsl:call-template>&#160;<xsl:value-of select="@name"/><span class="fa fa-chevron-down"></span></a>
									</xsl:when>
									<xsl:otherwise>
										<a href="{$pattern}/{@name}/"><xsl:if test="string-length($class)"><xsl:attribute name="class"><xsl:value-of select="$class"/></xsl:attribute></xsl:if><xsl:call-template name="getTitle"><xsl:with-param name="item" select="$item"/></xsl:call-template>&#160;<xsl:value-of select="@name"/></a>
									</xsl:otherwise>
								</xsl:choose>
								<xsl:if test="count($item/node) != 0">
									<ul class="nav child_menu">
									<xsl:call-template name="drawLevel">
										<xsl:with-param name="level" select="$level + 1"/>
										<xsl:with-param name="items" select="$item/node"/>
										<xsl:with-param name="pattern" select="concat($pattern,'/', @name)"/>
									</xsl:call-template>
									</ul>
								</xsl:if>
								</li>
							</xsl:for-each>
						</xsl:when>
						<xsl:otherwise>
							<li>
							<xsl:choose>
								<xsl:when test="$level = 0">
									<a><i class="fa {$class}"></i><xsl:call-template name="getTitle"><xsl:with-param name="item" select="$item"/></xsl:call-template><span class="fa fa-chevron-down"></span></a>
								</xsl:when>
								<xsl:otherwise>
									<a href="{$pattern}/{@pattern}/"><xsl:if test="string-length($class)"><xsl:attribute name="class"><xsl:value-of select="$class"/></xsl:attribute></xsl:if><xsl:call-template name="getTitle"><xsl:with-param name="item" select="$item"/></xsl:call-template></a>
								</xsl:otherwise>
							</xsl:choose>
							<xsl:if test="count(node[count(menu[@name='main_menu']) != 0]) != 0">
								<ul class="nav child_menu">
								<xsl:call-template name="drawLevel">
									<xsl:with-param name="level" select="$level + 1"/>
									<xsl:with-param name="items" select="node[count(menu[@name='main_menu']) != 0]"/>
									<xsl:with-param name="pattern" select="concat($pattern,'/', @pattern)"/>
								</xsl:call-template>
								</ul>
							</xsl:if>
							</li>
						</xsl:otherwise>
					</xsl:choose>
					
				</xsl:if>
			</xsl:if>
		</xsl:for-each>
	</xsl:if>
</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="getTitle">
		<xsl:param name="item"/>
		<xsl:choose>
			<xsl:when test="string-length($item/title[@lang = $language_id]/text()) != 0"><xsl:value-of select="$item/title[@lang = $language_id]/text()" disable-output-escaping="yes"/></xsl:when>
			<xsl:when test="string-length($item/title[@lang = $language_id]/@value) != 0"><xsl:value-of select="$item/title[@lang = $language_id]/@value" disable-output-escaping="yes"/></xsl:when>
			<xsl:otherwise><xsl:value-of select="$item/@title" disable-output-escaping="yes"/></xsl:otherwise>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="checkRoles">
		<xsl:call-template name="checkRole">
			<xsl:with-param name="items" select="role"/>
			<xsl:with-param name="pos" select="number(1)"/>
		</xsl:call-template>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="checkRole">
		<xsl:param name="items"/>
		<xsl:param name="pos"/>
		<xsl:if test="$pos &lt;= count($items)">
			<xsl:choose>
				<xsl:when test="contains($roles, concat('|',$items[$pos],'|'))">true</xsl:when>
				<xsl:otherwise>
					<xsl:call-template name="checkRole">
						<xsl:with-param name="items" select="$items"/>
						<xsl:with-param name="pos" select="number($pos) + 1"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="user">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<xsl:choose>
			<xsl:when test="string-length($user) = 0">
				<xsl:for-each select="node/node/node[count(menu[@name='user_menu']) != 0]">
					<xsl:variable name="role"><xsl:call-template name="checkRoles"/></xsl:variable>
					<xsl:if test="count(role) = 0 or $role = 'true'">
						<li class="">
							<a class="ref-user-menu" href="{$lang}/{../@pattern}/{@pattern}"><i class="{@fa-class}" aria-hidden="true"></i>&#160;<xsl:call-template name="getTitle"><xsl:with-param name="item" select="."/></xsl:call-template></a>
						</li>
					</xsl:if>
				</xsl:for-each>
			</xsl:when>
			<xsl:otherwise>
				<li class="">
					<a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
					<xsl:value-of select="$user"/>&#160;<span class="fa fa-angle-down"></span>
					</a>
					<ul class="dropdown-menu dropdown-usermenu pull-right">
					<xsl:for-each select="node/node/node[count(menu[@name='user_menu']) != 0]">
						<xsl:variable name="class">
							<xsl:choose>
								<xsl:when test="string-length(@class) != 0"><xsl:value-of select="@class"/></xsl:when>
							</xsl:choose>
						</xsl:variable>
						<xsl:variable name="role"><xsl:call-template name="checkRoles"/></xsl:variable>
						<xsl:if test="count(role) = 0 or $role = 'true'">
							<li class="">
								<a class="{$class}" href="{$lang}/{../@pattern}/{@pattern}"><xsl:if test="@fa-class != ''"><i class="{@fa-class}" aria-hidden="true"></i>&#160;</xsl:if><xsl:call-template name="getTitle"><xsl:with-param name="item" select="."/></xsl:call-template></a>
							</li>
						</xsl:if>
					</xsl:for-each>
					</ul>
				</li>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>
