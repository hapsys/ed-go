<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:param name="root"/>
	<xsl:param name="language_id"/>
	<xsl:param name="mode"/>
	<xsl:template match="/*">
		<xsl:choose>
			<xsl:when test="$mode = 'view'"><xsl:call-template name="view_form"/></xsl:when>
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
						<xsl:value-of select="item[@name='userKey']/field[@name='publicKey']/@value"/>
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
	<xsl:template name="email">
		<div class="content-wrapper clearfix">
            <div class="panel panel-login">
                <div class="panel-body">
                    <div class="panel-body-form">
                        <p>CONFIRM YOUR EMAIL. To complete the signup process, we need to confirm that you own the email address you used to set up the account.</p>
                        <p>You will receive your activation link by email within a few minutes. Look in your SPAM folder if you do not see it right away.</p>
                        <p>If you do not receive the verification email in 15 minutes, try to  <a href="{$root}/account/resend-email/">resend an email</a>.</p>
                    </div>
                </div>
                <div class="panel-footer clearfix">
                    Back to <a href="{$root}/logout/">Login</a>
                </div>
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