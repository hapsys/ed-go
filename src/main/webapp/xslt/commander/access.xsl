<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:i10n="org.c3s.edgo.utils.I10N">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:param name="root"/>
	<xsl:param name="politic"/>
	<xsl:param name="language_id"/>
	<xsl:param name="default"/>
	<xsl:param name="suffix"/>
	<xsl:param name="mode"/>
	<xsl:param name="pilot"/>
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
		<div class="row width-650 pilot-access-info">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							<xsl:value-of select="i10n:tr('pilot-access-settings')"/> <small>(<xsl:value-of select="i10n:tr('pilot-access-description')"/>)</small>
						</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<table class="table">
							<tr>
								<th></th>
								<xsl:for-each select="/item/relations/item">
									<th><xsl:value-of select="i10n:tr(field[@name='name']/@value)"/></th>
								</xsl:for-each>
							</tr>
							<xsl:for-each select="/item/info/item">
								<xsl:variable name="info_id" select="field[@name='infoId']/@value"/>
								<tr>
									<th><xsl:value-of select="i10n:tr(field[@name='infoUniq']/@value)"/></th>
									<xsl:for-each select="/item/relations/item">
										<xsl:variable name="relation" select="field[@name='name']/@value"/>
										<td>
											<input type="checkbox" class="flat lnk-link" value="1" name="level[{$info_id}][{$relation}]">
												<xsl:if test="/item/levels/item[field[@name='infoId']/@value = $info_id and field[@name='relateTo']/@value = $relation]/field[@name='mask']/@value != 0">
													<xsl:attribute name="checked">checked</xsl:attribute>
												</xsl:if>
											</input>
										</td>
									</xsl:for-each>
								</tr>
							</xsl:for-each>
						</table>
						<p><button type="button" class="btn btn-success update-access"><xsl:value-of select="i10n:tr('save-settings')"/></button></p>
					</div>
				</div>
			</div>
		</div>
		<script>
			pilot = '<xsl:value-of select="$pilot"/>';
		</script>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>