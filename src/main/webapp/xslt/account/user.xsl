<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:param name="root"/>
	<xsl:param name="language_id"/>
	<xsl:param name="mode"/>
	<xsl:template match="/*">
		<xsl:choose>
			<xsl:when test="$mode = 'view'"><xsl:call-template name="view_form"/></xsl:when>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_form">
		<form class="form-horizontal account-form">
			<div class="form-group">
				<label for="lastLoginTime" class="col-md-4 control-label">Last login time</label>
				<div class="col-md-8">
					<xsl:value-of select="field[@name='prevLoginTime']/@value"/>
				</div>
			</div>			
			<div class="form-group">
				<label for="accountId" class="col-md-4 control-label">Account ID</label>
				<div class="col-md-8">
					<input type="email" readonly="readonly" class="form-control" id="accountId" value="{field[@name='userUuid']/@value}"/>
				</div>
			</div>			
			<div class="form-group">
				<label for="email" class="col-md-4 control-label">Email</label>
				<div class="col-md-8">
					<input type="email" readonly="readonly" class="form-control" id="email" value="{field[@name='email']/@value}"/>
				</div>
			</div>			
			<div class="form-group">
				<label for="accessKey" class="col-md-4 control-label">Remote Access Key</label>
				<div class="col-md-8">
					<textarea rows="5" readonly="readonly" id="accessKey" class="form-control">
						<xsl:value-of select="field[@name='userKey']/field[@name='privateKey']/@value"/>
					</textarea>
					<div><a href="#" class="key-generate">Generate New Key</a></div>
				</div>
			</div>			
		</form>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>