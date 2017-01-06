<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:i10n="org.c3s.edgo.utils.I10N">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:param name="root"/>
	<xsl:param name="politic"/>
	<xsl:param name="language_id"/>
	<xsl:param name="default"/>
	<xsl:param name="suffix"/>
	<xsl:param name="mode"/>
	<xsl:template match="/*">
		<xsl:choose>
			<xsl:when test="$mode = 'view'"><xsl:call-template name="view_form"/></xsl:when>
			<xsl:when test="$mode = 'client'"><xsl:call-template name="view_client"/></xsl:when>
			<xsl:when test="$mode = 'email'"><xsl:call-template name="email"/></xsl:when>
			<xsl:when test="$mode = 'resend-email'"><xsl:call-template name="resend-email"/></xsl:when>
			<xsl:when test="$mode = 'email-confirm'"><xsl:call-template name="email-confirm"/></xsl:when>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_form">
		<div class="row width-650">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						<xsl:value-of select="i10n:tr('profile-settings')"/> <small>(<xsl:value-of select="i10n:tr('profile-description')"/>)</small>
					</h2>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<form class="form-horizontal account-form">
						<div class="form-group">
							<label for="lastLoginTime" class="col-md-4 control-label">Last login time</label>
							<div class="col-md-8">
								<xsl:value-of select="field[@name='prevLoginTime']/@value"/>
							</div>
						</div>			
						<div class="form-group">
							<label for="email" class="col-md-4 control-label">Email</label>
							<div class="col-md-8">
								<input type="email" readonly="readonly" class="form-control" id="email" value="{field[@name='email']/@value}"/>
							</div>
						</div>			
					</form>
				</div>
			</div>
		</div>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_client">
		<div class="row width-650">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						<xsl:value-of select="i10n:tr('client-title')"/> <small>(<xsl:value-of select="i10n:tr('client-description')"/>)</small>
					</h2>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<form class="client-program-form">
						<p>
							<label for="accountId"><xsl:value-of select="i10n:tr('client-id')"/></label>
							<input type="email" readonly="readonly" class="form-control" id="accountId" value="{field[@name='userUuid']/@value}"/>
							<div><span><a href="#" class="clipboard-copy" data-clipboard-target="#accountId">Copy to clipboard</a></span></div>
						</p>
						<p>
							<label for="accessKey"><xsl:value-of select="i10n:tr('client-key')"/></label>
							<textarea rows="5" readonly="readonly" id="accessKey" class="form-control">
								<xsl:value-of select="item[@name='userKey']/field[@name='publicKey']/@value"/>
							</textarea>
							<div><span><a href="#" class="key-generate">Generate new key</a></span><span><a href="#" class="clipboard-copy" style="margin-left: 50px;" data-clipboard-target="#accessKey">Copy to clipboard</a></span></div>
						</p>
					</form>
				</div>
			</div>
		</div>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="email">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<div class="center_wrapper">
			<div class="center_form">
				<section class="login_content">
					<xsl:choose>
						<xsl:when test="$language_id = 'ru'">
							<div class="text-left">
		                        <p>Подтверждение почты. Для завершения процесса регистрации вам необходимо подтвердить почту своего аккаунта.</p>
		                        <p>Вы получите письмо с активацией в течении нескольких минут. Если в течении некоторого времени вы не видите письма, поищите его в папке СПАМ.</p>
		                        <p>Если вы не получили письмо с верификацией в течении 15 минут, попытайтесь  <a href="{$root}/account/resend-email/">перепослать почту</a>.</p>
		                    </div>
			                <div class="panel-footer clearfix">
			                    Перейти на <a href="{$lang}/logout/" class="logout-login">Логин</a>
			                </div>
						</xsl:when>
						<xsl:otherwise>
							<div class="text-left">
		                        <p>CONFIRM YOUR EMAIL. To complete the signup process, we need to confirm that you own the email address you used to set up the account.</p>
		                        <p>You will receive your activation link by email within a few minutes. Look in your SPAM folder if you do not see it right away.</p>
		                        <p>If you do not receive the verification email in 15 minutes, try to  <a href="{$root}/account/resend-email/">resend an email</a>.</p>
		                    </div>
			                <div class="panel-footer clearfix">
			                    Back to <a href="{$lang}/logout/" class="logout-login">Login</a>
			                </div>
						</xsl:otherwise>
					</xsl:choose>
                </section>
            </div>
        </div>
    </xsl:template>
<!--
//
//
//
-->
	<xsl:template name="resend-email">
		<div class="content-wrapper clearfix">
            <div class="content-header">
                <h1>resend activation email</h1>
            </div>
            <div class="panel panel-login">
                <div class="panel-body">
                    <div class="panel-body-form">
                        <form action="" class="form-email-resend">
                            <div class="form-group">
                                <input type="email" class="form-control" name="email" value="{field[@name='email']/@value}" id="email"/>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">resend email</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="panel-footer clearfix">
                    Back to <a href="{$root}logout/"> Login</a>
                </div>
            </div>
        </div>		
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="email-confirm">
		<div class="panel-body">
			<div class="content-header">
				<h1>verify your email</h1>
			</div>
			<div class="panel-body-form">
				<xsl:choose>
					<xsl:when test="@success = 'true'">
						<p>Thank you for validating your E-Mail address! To start please clicking the following link:</p>
						<p>
							<a href="{$root}">return to site</a>
						</p>
					</xsl:when>
					<xsl:otherwise>
						<p>Thereis error validating your E-Mail address! Please check confirmation URL.</p>
					</xsl:otherwise>
				</xsl:choose>
				<p>&#160;</p>
				<p>Regards,<br/>
	ED-GO Dashboard Team</p>
			</div>
		</div>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>