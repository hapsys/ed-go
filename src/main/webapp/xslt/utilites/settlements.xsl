<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE xsl:stylesheet [
	<!ENTITY nbsp "&#160;">
]>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:param name="root"/>
	<xsl:param name="language_id"/>
	<xsl:param name="default"/>
	<xsl:param name="suffix"/>
	<xsl:param name="tournaments"/>
	<xsl:param name="roles"/>
	<xsl:param name="mode"/>
	<xsl:template match="/data">
		<xsl:choose>
			<xsl:when test="$mode = 'canvas'"><xsl:call-template name="canvas"/></xsl:when>
	</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="canvas">
		<p>
			For details see <a class="btn btn-default" target="_blank" href="https://docs.google.com/spreadsheets/d/1Y6jupbLF5RSunI4MEZkRfGmZGDt742HjeGuIyvvlQzQ/edit#gid=726725669">settlements type table</a>
		</p>
		<form class="search-settlements">
			<dl class="dl-vertical">
				<dt>
				<ul class="list-inline">
					<xsl:for-each select="item/itemlist">
						<li><ul class="list-unstyled">
							<xsl:for-each select="item">
								<li>
									<div class="checkbox">
										<label>
											<input type="checkbox" name="stype" value="{field[@name='type']/@value}" id="{field[@name='type']/@value}"/>&#160;<xsl:value-of select="field[@name='title']/@value"/>
										</label>
									</div>							
								</li>
							</xsl:for-each>
						</ul>
						</li>
					</xsl:for-each>
				</ul>
				</dt>
				<dt>Current system</dt>
				<dd>
					<select name="system" id="system" type="text" class="form-control" data-placeholder="Select current system...">
						<option></option>
					</select>
				</dd>
			</dl>
			<p class="text-right">
				<button type="button" class="btn btn-success btn-xs show-visited" data-toggle="modal" data-target="#modalVisited">Show visited</button>
				&#160;
				<button type="button" class="btn btn-danger btn-xs clear-visited">Clear visited</button>
			</p>
			<button type="submit" class="btn btn-primary fixed">Search</button>
		</form>
		<p>
		<table class="table table-bordered table-systems">
			<tr>
				<th>№</th>
				<th>Name</th>
				<th>Type</th>
				<th>System</th>
				<th>Planet</th>
				<th>To destination (ly)</th>
				<th>Destination to Sol (ly)</th>
				<th class="col-md-1"></th>
			</tr>
		</table>
		</p>
		<p class="text-right">
			Based on <a class="btn btn-default" target="_blank" href="https://docs.google.com/spreadsheets/d/1UxvrHe8qy1Pzzyo11Grqw6AkE8Acmch60NOR5MDzs1U/edit#gid=0">table by DJa</a>
		</p>
		<!-- Modal -->
		<div class="modal fade" id="modalVisited" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><xsl:text disable-output-escaping="yes">&amp;times;</xsl:text></span></button>
		        <h4 class="modal-title" id="myModalLabel">Stored visited settlements</h4>
		      </div>
		      <div class="modal-body">
				<table class="table table-bordered table-visited">
					<tr>
						<th>№</th>
						<th>Name</th>
						<th>Type</th>
						<th>System</th>
						<th>Planet</th>
						<th>Sol dest</th>
						<th>TTL</th>
						<th class="col-md-1"></th>
					</tr>
				</table>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>	
		<script type="text/javascript" src="{$root}/js/settlements.js"></script>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>