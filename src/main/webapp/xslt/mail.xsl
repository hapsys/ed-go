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
	<xsl:param name="pilot"/>
	<xsl:param name="type"/>
<!--
//
//
//
-->
	<xsl:template match="/*">
		<xsl:choose>
			<xsl:when test="$type = 'register' or $type = 'registration'"><xsl:call-template name="registration"/></xsl:when>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="registration">
<h3>Добрый день.</h3>

<p>
Вы успешно зарегистрировались на сайте <xsl:value-of select="@site_name"/> , но Вам необходимо 
подтвердить Ваш адрес электронной почты.
</p>

<p>
Для подтверждения адреса вам необходимо перейти по ссылке <a href="{@hash_url}"><xsl:value-of select="@hash_url"/></a>
</p>


<p>
С уважением,<br/>
администрация нашего зачипательского ресурса.
</p>		
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>