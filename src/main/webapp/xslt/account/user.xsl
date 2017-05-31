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
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							<xsl:value-of select="i10n:tr('profile-settings')"/> <small>(<xsl:value-of select="i10n:tr('profile-description')"/>)</small>
						</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal account-form">
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name"><xsl:value-of select="i10n:tr('last-login-time')"/></label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<h5><xsl:value-of select="field[@name='prevLoginTime']/@value"/></h5>
								</div>
							</div>			
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="email"><xsl:value-of select="i10n:tr('email-login')"/></label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <h5><xsl:value-of select="field[@name='email']/@value"/></h5>
		                        </div>
							</div>			
							<div class="form-group password-switch">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="password"><xsl:value-of select="i10n:tr('password')"/></label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <h5><a class="password-change" href="#"><xsl:value-of select="i10n:tr('password-change')"/></a></h5>
		                        </div>
							</div>			
							<div class="form-group password-switch hidden">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="old_password"><xsl:value-of select="i10n:tr('old-password')"/> <span class="required">*</span>
								</label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="password" id="old_password" name="old_password" required="required" class="form-control col-md-7 col-xs-12"/>
		                        </div>
							</div>			
							<div class="form-group password-switch hidden">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="new_password"><xsl:value-of select="i10n:tr('new-password')"/> <span class="required">*</span>
								</label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="password" id="new_password" name="new_password" required="required" class="form-control col-md-7 col-xs-12"/>
		                        </div>
							</div>			
							<div class="form-group password-switch hidden">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="confirm_new_password"><xsl:value-of select="i10n:tr('confirm-new-password')"/> <span class="required">*</span>
								</label>
		                        <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input type="password" id="confirm_new_password" name="confirm_new_password" required="required" class="form-control col-md-7 col-xs-12"/>
		                        </div>
							</div>
							<div class="ln_solid password-switch hidden"></div>			
							<div class="form-group password-switch hidden">
		                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
		                          <button type="button" class="btn btn-primary password-cancel"><xsl:value-of select="i10n:tr('cancel')"/></button>
		                          <button type="button" class="btn btn-success password-save"><xsl:value-of select="i10n:tr('save-password')"/></button>
		                        </div>
							</div>			
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row width-650 user-info">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							<xsl:value-of select="i10n:tr('user-access-settings')"/> <small>(<xsl:value-of select="i10n:tr('user-access-description')"/>)</small>
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
							<input type="text" readonly="readonly" class="form-control" id="accountId" value="{field[@name='userUuid']/@value}"/>
							<div><span><button class="btn clipboard-copy btn-sm" data-clipboard-target="#accountId">Copy to clipboard</button></span></div>
						</p>
						<p>
							<label for="accessKey"><xsl:value-of select="i10n:tr('client-key')"/></label>
							<textarea rows="5" readonly="readonly" id="accessKey" class="form-control">
								<xsl:value-of select="item[@name='userKey']/field[@name='publicKey']/@value"/>
							</textarea>
							<div><span><button class="btn btn-primary btn-sm key-generate">Generate new key</button></span><span><button class="btn btn-sm clipboard-copy" style="margin-left: 50px;" data-clipboard-target="#accessKey">Copy to clipboard</button></span></div>
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