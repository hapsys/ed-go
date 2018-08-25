<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:i10n="org.c3s.edgo.utils.I10N">
	<xsl:output encoding="utf-8" indent="yes" method="html"/>
	<xsl:decimal-format name="revards" grouping-separator=" " digit="#"/>
	<xsl:include href="../ranks.xsl"/>
	<xsl:include href="../dates.xsl"/>
	<xsl:param name="root"/>
	<xsl:param name="politic"/>
	<xsl:param name="language_id"/>
	<xsl:param name="default"/>
	<xsl:param name="suffix"/>
	<xsl:param name="tournaments"/>
	<xsl:param name="roles"/>
	<xsl:param name="mode"/>
	<xsl:param name="pilot"/>
	<xsl:template match="/*">
		<xsl:choose>
			<xsl:when test="$mode = 'info'"><xsl:call-template name="view_info"/></xsl:when>
			<xsl:when test="$mode = 'ships'"><xsl:call-template name="view_ships"/></xsl:when>
			<xsl:when test="$mode = 'view_ship'"><xsl:call-template name="view_ship"/></xsl:when>
			<xsl:when test="$mode = 'view_power'"><xsl:call-template name="view_power"/></xsl:when>
			<xsl:when test="$mode = 'view_missions'"><xsl:call-template name="view_missions"/></xsl:when>
			<xsl:when test="$mode = 'locations'"><xsl:call-template name="view_locations"/></xsl:when>
			<xsl:when test="$mode = 'materials'"><xsl:call-template name="view_materials"/></xsl:when>
			<xsl:when test="$mode = 'gallery'"><xsl:call-template name="view_gallery"/></xsl:when>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_info">

		<div class="clearfix"></div>
		<!-- Location -->
		<div class="x_panel updated-by-time" data-update-function="updateUserInfo" data-update-interval="30000">
			<div class="x_title">
				<h2>
					<xsl:value-of select="i10n:tr('Last Info')"/>
					<small></small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="col-md-4 col-xs-12 widget widget_tally_box">
					<div class="x_panel">
						<div class="x_title">
							<h2><xsl:value-of select="i10n:tr('last-seen')"/></h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<table class="table">
								<tr>
									<td colspan="2" >
										<span id="lastSeen"><xsl:value-of select="item[@name='lastInfo']/field[@name='lastSeen']/@value"/></span>
										<xsl:value-of select="i10n:tr('ago')"/>
									</td>
								</tr>
								<tr>
									<td class="col-md-2"><xsl:value-of select="i10n:tr('Mode')"/>:</td>
									<td id="gameMode">
										<xsl:value-of
											select="item[@name='lastInfo']/field[@name='gameMode']/@value"
											disable-output-escaping="yes" />
									</td>
								</tr>
								<tr>
									<xsl:if test="string-length(item[@name='lastInfo']/field[@name='gameGroup']/@value) = 0">
										<xsl:attribute name="class">hidden</xsl:attribute>
									</xsl:if>
									<td class="col-md-2"><xsl:value-of select="i10n:tr('Group')"/>:</td>
									<td class="hided" id="gameGroup">
										<xsl:value-of
											select="item[@name='lastInfo']/field[@name='gameGroup']/@value"
											disable-output-escaping="yes" />
									</td>
								</tr>
								<tr>
									<td class="col-md-2"><xsl:value-of select="i10n:tr('Query')"/>:</td>
									<td style="padding-top: 4px;">
										<span id="queredEvents" style="padding-top: 0px;"><xsl:value-of select="item[@name='lastInfo']/field[@name='queredEvents']/@value"/></span>&#160;<xsl:value-of select="i10n:tr('events')"/>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-xs-12 widget widget_tally_box">
					<div class="x_panel">
						<div class="x_title">
							<h2><xsl:value-of select="i10n:tr('Current location')"/></h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<table class="table">
								<tr>
									<td class="col-md-2"><xsl:value-of select="i10n:tr('System')"/>:</td>
									<td id="systemName">
										<xsl:value-of
											select="item[@name='lastInfo']/field[@name='systemName']/@value"
											disable-output-escaping="yes" />
									</td>
								</tr>
								<tr>
									<xsl:if test="string-length(item[@name='lastInfo']/field[@name='stationName']/@value) = 0">
										<xsl:attribute name="class">hidden</xsl:attribute>
									</xsl:if>
									<td class="col-md-2"><xsl:value-of select="i10n:tr('Station')"/>:</td>
									<td class="hided" id="stationName">
										<xsl:value-of
											select="item[@name='lastInfo']/field[@name='stationName']/@value"
											disable-output-escaping="yes" />
									</td>
								</tr>
								<tr>
									<xsl:if test="string-length(item[@name='lastInfo']/field[@name='bodyName']/@value) = 0">
										<xsl:attribute name="class">hidden</xsl:attribute>
									</xsl:if>
									<td class="col-md-2"><xsl:value-of select="i10n:tr('Body')"/>:</td>
									<td class="hided" id="bodyName">
										<xsl:value-of select="item[@name='lastInfo']/field[@name='bodyName']/@value"
											disable-output-escaping="yes" />
									</td>
								</tr>
								<tr>
									<td class="col-md-2"><xsl:value-of select="i10n:tr('Fly mode')"/>:</td>
									<td id="flyMode">
										<xsl:value-of select="item[@name='lastInfo']/field[@name='flyMode']/@value"
											disable-output-escaping="yes" />
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<!-- Ranks -->
		<div class="x_panel">
			<div class="x_title">
				<h2>
					Ranks
					<small></small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<!-- Combat -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='lastInfo']/field[@name='progressCombat']/@value" />
					<div class="x_panel ui-ribbon-container fixed_height_250">
						<div class="x_title">
							<h2>Combat</h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">

							<div style="text-align: center; margin-bottom: 17px">
								<span class="chart" data-percent="{$percent}">
									<span class="percent"></span>
								</span>
							</div>

							<h3 class="name_title">
								<xsl:call-template name="combat">
									<xsl:with-param name="rank"
										select="number(item[@name='lastInfo']/field[@name='combat']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
				<!-- Trade -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='lastInfo']/field[@name='progressTrade']/@value" />
					<div class="x_panel ui-ribbon-container fixed_height_250">
						<div class="x_title">
							<h2>Trade</h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">

							<div style="text-align: center; margin-bottom: 17px">
								<span class="chart" data-percent="{$percent}">
									<span class="percent"></span>
								</span>
							</div>

							<h3 class="name_title">
								<xsl:call-template name="trade">
									<xsl:with-param name="rank"
										select="number(item[@name='lastInfo']/field[@name='trade']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
				<!-- Explore -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='lastInfo']/field[@name='progressExplore']/@value" />
					<div class="x_panel ui-ribbon-container fixed_height_250">
						<div class="x_title">
							<h2>Explore</h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">

							<div style="text-align: center; margin-bottom: 17px">
								<span class="chart" data-percent="{$percent}">
									<span class="percent"></span>
								</span>
							</div>

							<h3 class="name_title">
								<xsl:call-template name="explore">
									<xsl:with-param name="rank"
										select="number(item[@name='lastInfo']/field[@name='explore']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
				<!-- CQC -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='lastInfo']/field[@name='progressCqc']/@value" />
					<div class="x_panel ui-ribbon-container fixed_height_250">
						<div class="x_title">
							<h2>CQC</h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">

							<div style="text-align: center; margin-bottom: 17px">
								<span class="chart" data-percent="{$percent}">
									<span class="percent"></span>
								</span>
							</div>

							<h3 class="name_title">
								<xsl:call-template name="cqc">
									<xsl:with-param name="rank"
										select="number(item[@name='lastInfo']/field[@name='cqc']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
				<!-- empire -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='lastInfo']/field[@name='progressEmpire']/@value" />
					<div class="x_panel ui-ribbon-container fixed_height_250">
						<div class="x_title">
							<h2>Empire</h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">

							<div style="text-align: center; margin-bottom: 17px">
								<span class="chart" data-percent="{$percent}">
									<span class="percent"></span>
								</span>
							</div>

							<h3 class="name_title">
								<xsl:call-template name="empire">
									<xsl:with-param name="rank"
										select="number(item[@name='lastInfo']/field[@name='empire']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
				<!-- federation -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='lastInfo']/field[@name='progressFederation']/@value" />
					<div class="x_panel ui-ribbon-container fixed_height_250">
						<div class="x_title">
							<h2>Federation</h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">

							<div style="text-align: center; margin-bottom: 17px">
								<span class="chart" data-percent="{$percent}">
									<span class="percent"></span>
								</span>
							</div>

							<h3 class="name_title">
								<xsl:call-template name="federation">
									<xsl:with-param name="rank"
										select="number(item[@name='lastInfo']/field[@name='federation']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<!-- Activity -->
		<div class="x_panel">
			<div class="x_title">
				<h2>
					Activity
					<small>monthly</small>
				</h2>
				<div class="filter">
					<div id="select-month" class="pull-right data" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
						<input id="date-selected" class="form-control hidden" type="text" style="border:none;" value="{/*/@maxdate}"/>
						<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
						<span style="padding-left: 5px; padding-right: 5px;"><xsl:value-of select="/*/@currentdate"/></span>
						<b class="caret"></b>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<canvas id="mybarChart"></canvas>
			</div>
		</div>
		<script>
			$(function() {
				$('.chart').easyPieChart({
					easing: 'easeOutElastic',
					delay: 3000,
					barColor: '#26B99A',
					trackColor: '#fff',
					scaleColor: false,
					lineWidth: 20,
					trackWidth: 16,
					lineCap: 'butt',
					onStep: function(from, to, percent) {
						$(this.el).find('.percent').text(Math.round(percent));
					}
				});
				
				var lastdate = moment(Date.parse("<xsl:value-of select="/*/@maxdate"/>").getTime());
				var pilot = '<xsl:value-of select="$pilot"/>';
				
				var mybarChart = null;
				
				var setDateLabel = function(date) {
					//var m = moment(date.getTime());
					//console.log(m.locale());
					var month = date.format('MMMM');
					var year = ' ' + date.year();
					$("#select-month").find("span").html(month + year);
				} 
				
				setDateLabel(lastdate);
				
				//console.log(lastdate.getMonth());
				var drawChart = function(date, callback) {
					var month_year = '' + date.format('YYYY-MM');
					var checkDate = new Date(date.year(), date.month() + 1, 0);
					var daysCount = checkDate.getDate();
					if (checkDate.getTime() > (new Date()).getTime()) {
						daysCount = (new Date()).getDate();
					}
					var data = {
						showdate: month_year,
					};
					//console.log(data);
					proxy.makeCall('post', '/ajax/pilots/'+ pilot + '/activity/', null, null, data, function(result) {
						if (result.error || result.status == 403) {
						} else {
						
							var mom = moment(date);
							var monthLabel = mom.format('MMM'); 
							
							var _labes = [];
							var _data = [];
							var _open = [];
							var _group = [];
							var _solo = [];
							for(i=1; i &lt;= daysCount; i++) {
								_labes.push(i + ' ' + monthLabel);
								_data.push(0);
								_open.push(0);
								_group.push(0);
								_solo.push(0);
							}
							for(i=0; i &lt; result.days.length; i++) {
								var current = result.days[i];
								_data[current.eventDate - 1] = current.times;
								_open[current.eventDate - 1] = current.timesOpen?current.timesOpen:0;
								_group[current.eventDate - 1] = current.timesGroup?current.timesGroup:0;
								_solo[current.eventDate - 1] = current.timesSolo?current.timesSolo:0;
							}
							if (mybarChart != null) {
								mybarChart.destroy();
							}
						    var ctx = document.getElementById("mybarChart");
						    mybarChart = new Chart(ctx, {
						      type: 'horizontalBar',
						      data: {
						        labels: _labes,
						        datasets: [
							        {
							          label: 'Common # hours in game in ' + mom.format('MMMM'),
							          backgroundColor: "#03586A",
							          data: _data
							        },
							        {
							          label: 'Open # hours in game in ' + mom.format('MMMM'),
							          backgroundColor: "#FF0000",
							          data: _open
							        },
							        {
							          label: 'Group # hours in game in ' + mom.format('MMMM'),
							          backgroundColor: "#00FF00",
							          data: _group
							        },
							        {
							          label: 'Solo # hours in game in ' + mom.format('MMMM'),
							          backgroundColor: "#0000FF",
							          data: _solo
							        },
						        ]
						      },
						
						      options: {
						        scales: {
						          yAxes: [{
						            ticks: {
						              beginAtZero: true
						            }
						          }]
						        }
						      }
						   });
						   if (callback) {
						   	callback();
						   }
						}
					});
					return false;
				}
				
				drawChart(lastdate);
				
				$("#select-month").datetimepicker({
					format: "YYYY-MM",
                	viewMode: 'months',
					maxDate: "<xsl:value-of select="/*/@maxdate"/>".replace(/\-\d+$/, ''),
					minDate: "<xsl:value-of select="/*/@mindate"/>".replace(/\-\d+$/, ''),
            	}).on('dp.change', function(e) {
            		//console.log(e.date);
            		setDateLabel(e.date);
            		drawChart(e.date);
            	});
            	
            	$("#select-month").on('click', function() {
            		$("#select-month").data("DateTimePicker").viewMode('months');
            		$("#select-month").data("DateTimePicker").toggle();
            	});
				
				updateUserInfo = function() {
					proxy.makeCall('post', '/ajax/pilots/'+ pilot + '/update-user-info/', null, null, null, function(result) {
						if (result.info &amp;&amp; result.info.lastInfo) {
							$('.hided').each(function() {
								$($(this).parents('tr')[0]).addClass('hidden');
							});  
							for (k in result.info.lastInfo) {
								var v = result.info.lastInfo[k];
								var elm = $('#' + k);
								if (elm.length) {
									if (elm.hasClass('hided')) {
										var tr = $(elm).parents('tr')[0];
										if (v) {
											$(tr).removeClass('hidden');
										}
									}
									elm.html(v);
								}
							};
						}
					});	
				}
			});
		</script>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_ships">
	
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<!-- 
		<div><h3><xsl:value-of select="field[@name='pilotName']/@value"/></h3></div>
		 -->
		<div class="" role="tabpanel" data-example-id="togglable-tabs">
			<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
				<li role="presentation" class="active"><a href="#ship_tab_content" id="ships-tab" role="tab" data-toggle="tab" aria-expanded="true"><xsl:value-of select="i10n:tr('ships_ships')"/></a></li>
				<li role="presentation" class=""><a href="#module_tab_content" role="tab" id="modules-tab" data-toggle="tab" aria-expanded="false"><xsl:value-of select="i10n:tr('ships_modules')"/></a></li>
				<li role="presentation" class=""><a href="#stored_tab_content" role="tab" id="stored-tab" data-toggle="tab" aria-expanded="false"><xsl:value-of select="i10n:tr('stored_modules')"/></a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div role="tabpanel" class="tab-pane fade active in" id="ship_tab_content" aria-labelledby="ships-tab">
					<xsl:for-each select="additionOne/item">
						<div class="col-md-4 col-xs-12 widget widget_tally_box">
							<xsl:variable name="class">
								<xsl:if test="field[@name='isMain']/@value = 1">ship-active</xsl:if>
							</xsl:variable>
							<div class="x_panel ship-{field[@name='shipUniq']/@value} {$class}">
								<div class="x_title">
									<h2><a href="{$lang}/{../../field[@name='pilotName']/@value}/ships/{field[@name='linkShipId']/@value}/">
											<xsl:value-of select="field[@name='shipName']/@value"/>&#160;<i class="fa fa-share fa-fw" aria-hidden="true"></i>
										</a></h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<table style="font-weight: bold;">
										<tr>
											<td class="col-md-1">System:</td>
											<td>
												<xsl:choose>
													<xsl:when test="string-length(field[@name='systemName']/@value) != 0">
														<xsl:value-of select="field[@name='systemName']/@value"/><br/>
													</xsl:when>
													<xsl:otherwise>
														<xsl:value-of select="/item/item[@name='location']/field[@name='systemName']/@value"/><br/>
													</xsl:otherwise>
												</xsl:choose>
											</td>
										</tr>
										<tr>
											<td class="col-md-1">Station:</td>
											<td>
												<xsl:choose>
													<xsl:when test="string-length(field[@name='systemName']/@value) != 0">
														<xsl:value-of select="field[@name='stationName']/@value"/>
													</xsl:when>
													<xsl:otherwise>
														<xsl:value-of select="/item/item[@name='location']/field[@name='stationName']/@value"/>
													</xsl:otherwise>
												</xsl:choose>
											</td>
										</tr>
										<tr>
											<td class="col-md-1">Distance:</td>
											<td>
												<xsl:value-of select="translate(format-number(field[@name='distance']/@value, '###,###,###,###.00'),',',' ')"/> ly
											</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</xsl:for-each>
				</div>
				<div role="tabpanel" class="tab-pane fade in" id="module_tab_content" aria-labelledby="modules-tab">
					<table class="table">
						<tr>
							<th>Module</th>
							<th>Class</th>
							<th><nobr>Ships Count</nobr></th>
							<th>Ships</th>
						</tr>
						<xsl:for-each select="additionTwo/item">
							<tr>
								<td>
									<nobr>
									<xsl:value-of select="field[@name='commonModuleName']/@value"/>
									<xsl:if test="string-length(field[@name='moduleWeaponMode']/@value) != 0">&#160;<img width="15" height="15" src="{$root}/images/weapon/ed-{field[@name='moduleWeaponMode']/@value}.png" title="{field[@name='moduleWeaponMode']/@value}"/></xsl:if>
									</nobr>
								</td>
								<td>
									<xsl:value-of select="field[@name='moduleClass']/@value"/>
									<xsl:value-of select="field[@name='moduleRating']/@value"/>								
								</td>
								<td>
									<xsl:value-of select="field[@name='shipsCount']/@value"/>
								</td>
								<td class="ships-list">
									<xsl:value-of select="field[@name='ships']/@value"/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
				<div role="tabpanel" class="tab-pane fade in" id="stored_tab_content" aria-labelledby="strored-tab">
					<table class="table">
						<tr>
							<th>Module</th>
							<th>Class</th>
							<th>Recipie</th>
							<th><nobr>Moduels Count</nobr></th>
							<th><nobr>System/Station</nobr></th>
						</tr>
						<xsl:for-each select="additionThree/item">
							<tr>
								<td>
									<nobr>
									<xsl:value-of select="field[@name='commonModuleName']/@value"/>
									<xsl:if test="string-length(field[@name='moduleWeaponMode']/@value) != 0">&#160;<img width="15" height="15" src="{$root}/images/weapon/ed-{field[@name='moduleWeaponMode']/@value}.png" title="{field[@name='moduleWeaponMode']/@value}"/></xsl:if>
									</nobr>
								</td>
								<td>
									<xsl:value-of select="field[@name='moduleClass']/@value"/>
									<xsl:value-of select="field[@name='moduleRating']/@value"/>								
								</td>
								<td>
									<xsl:if test="string-length(field[@name='recipieName']/@value) != 0">
										<xsl:choose>
											<xsl:when test="field[@name='recipieGrade']/@value = 1"><img src="{$root}/images/engineer_sm.png"/></xsl:when>
											<xsl:when test="field[@name='recipieGrade']/@value = 2"><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/></xsl:when>
											<xsl:when test="field[@name='recipieGrade']/@value = 3"><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/></xsl:when>
											<xsl:when test="field[@name='recipieGrade']/@value = 4"><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/></xsl:when>
											<xsl:when test="field[@name='recipieGrade']/@value = 5"><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/></xsl:when>
										</xsl:choose>
										&#160;
										<xsl:value-of select="i10n:tr(field[@name='recipieName']/@value)"/>
									</xsl:if>
								</td>
								<td>
									<xsl:value-of select="field[@name='moduleCount']/@value"/>
								</td>
								<td>
									<xsl:value-of select="field[@name='modulePlace']/@value"/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<script>
			$(function() {
				$('.ships-list').each(function() {
					var link = [];
					var list = $(this).html();
					list.split(',').forEach(function(v) {
						var l = v.split(':');
						link.push('&lt;a class="text-primary" href="./' + l[1] + '/"&gt;' + l[0] + '&lt;a&gt;');
					});
					$(this).html(link.join(', '));
				});
				
				// check tabs
				$('#myTab').find('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
					//console.log($(e.target).attr('id'));
					var id = $(e.target).attr('id');
					var tabname = id.substring(0, id.indexOf('-'));
					//console.log(tabname);
					window.location.hash = tabname; 
				});
				
				if (window.location.hash.length &gt; 1) {
					var tabname = window.location.hash.substring(1);
					console.log(tabname);
					$('#' + tabname + '-tab').tab('show');
				}
			});
		</script>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_ship">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<p>
			<dl class="dl-horizontal pull-left">
				<dt>System:</dt>
				<dd><xsl:value-of select="item[@name='currentShip']/field[@name='systemName']/@value"/></dd>
				<dt>Station:</dt>
				<dd><xsl:value-of select="item[@name='currentShip']/field[@name='stationName']/@value"/></dd>
			</dl>
		</p>
		<div class="clearfix"></div>
		<table class="table" id="shipTable">
			<thead>
				<tr>
					<th data-width="1%"></th>
					<th data-width="24%">Weapon</th>
					<th data-width="1%"></th>
					<th data-width="24%">Utility</th>
					<th data-width="1%"></th>
					<th data-width="24%">Essential</th>
					<th data-width="1%"></th>
					<th data-width="24%">Internal</th>
				</tr>
			</thead>
			<tbody>
				<xsl:variable name="weapon" select="item[@name='currentShip']/modules/item[field[@name='slotTypeId']/@value='50']"/>
				<xsl:variable name="utility" select="item[@name='currentShip']/modules/item[field[@name='slotTypeId']/@value='10']"/>
				<xsl:variable name="essential" select="item[@name='currentShip']/modules/item[field[@name='slotTypeId' and (@value='30' or @value='40')]]"/>
				<xsl:variable name="internal" select="item[@name='currentShip']/modules/item[field[@name='slotTypeId']/@value='20']"/>
				<xsl:call-template name="module-line">
					<xsl:with-param name="weapon" select="$weapon"/>
					<xsl:with-param name="utility" select="$utility"/>
					<xsl:with-param name="essential" select="$essential"/>
					<xsl:with-param name="internal" select="$internal"/>
					<xsl:with-param name="pos" select="number(1)"/>
				</xsl:call-template>
			</tbody>
		</table>
		<p>
			<a class="text-primary coriolis-link" href="https://coriolis.edcd.io/outfit/" target="_tab">View at coriolis</a>
		</p>
		<script>
			// Make ship 
			var coriolisShip = '<xsl:value-of select="item[@name='currentShip']/modules/item/field[@name='coriolisName']/@value"/>';
			var data = {
				weapons: {
				<xsl:for-each select="item[@name='currentShip']/modules/item[field[@name='slotTypeId']/@value='50']">
					<xsl:value-of select="field[@name='slotUniq']/@value"/>: '<xsl:value-of select="field[@name='coriolisId']/@value"/>',  
				</xsl:for-each>
				},

				unity: {
				<xsl:for-each select="item[@name='currentShip']/modules/item[field[@name='slotTypeId']/@value='10']">
					<xsl:value-of select="field[@name='slotUniq']/@value"/>: '<xsl:value-of select="field[@name='coriolisId']/@value"/>',  
				</xsl:for-each>
				},

				standart : {
				<xsl:for-each select="item[@name='currentShip']/modules/item[field[@name='slotTypeId' and (@value='30' or @value='40')]]">
					<xsl:value-of select="field[@name='slotUniq']/@value"/>: '<xsl:value-of select="field[@name='coriolisId']/@value"/>',  
				</xsl:for-each>
				},

				internal: {
				<xsl:for-each select="item[@name='currentShip']/modules/item[field[@name='slotTypeId']/@value='20']">
					<xsl:sort select="field[@name='linkSize']/@value" data-type="number" order="descending"/>
					<!-- 
					<xsl:sort select="substring(field[@name='slotUniq']/@value, 1, 1)" data-type="text" order="asceding"/>
					 -->
					<xsl:sort select="field[@name='slotUniq']/@value" data-type="text" order="descending"/>
					<xsl:value-of select="field[@name='slotUniq']/@value"/>: '<xsl:value-of select="field[@name='coriolisId']/@value"/>',  
				</xsl:for-each>
			}};
			 
			var orders = ['standart', 'weapons', 'unity', 'internal'];
			
			var linkStr = '';
			
			orders.forEach(function(v, i) {
				//console.log(v);
				//console.log(i);
				//console.log(data[v]);
				for (key in data[v]) {
					var val = data[v][key];
					linkStr += val?val:'-';  
				}
			});
			 
			//console.log(linkStr);
			
			// Load
			$(function() {
				$('.coriolis-link').attr('href', $('.coriolis-link').attr('href') + coriolisShip + '?code=' + linkStr);
				$("#shipTable").bootstrapTable({});
				$('.show-modifyers').on('click', function() {
					$(this).parents('td').find('.modifyer').toggleClass('hidden');
					return false;
				});
			});
		</script>
	</xsl:template>
<!--
//
//
//
-->
		<xsl:template name="module-line">
			<xsl:param name="weapon"/>
			<xsl:param name="utility"/>
			<xsl:param name="essential"/>
			<xsl:param name="internal"/>
			<xsl:param name="pos"/>
			<xsl:if test="count($weapon[$pos]) != 0 or count($utility[$pos]) != 0 or count($essential[$pos]) != 0 or count($internal[$pos]) != 0">
				<tr>
					<td>
						<xsl:value-of select="$weapon[$pos]/field[@name='linkSize']/@value"/>
					</td> 
					<td>
						<xsl:call-template name="module_name">
							<xsl:with-param name="module" select="$weapon[$pos]"/>
						</xsl:call-template>
					</td>
					<td>
						<xsl:value-of select="$utility[$pos]/field[@name='linkSize']/@value"/>
					</td> 
					<td>
						<xsl:call-template name="module_name">
							<xsl:with-param name="module" select="$utility[$pos]"/>
						</xsl:call-template>
					</td>
					<td>
						<xsl:value-of select="$essential[$pos]/field[@name='linkSize']/@value"/>
					</td> 
					<td>
						<xsl:call-template name="module_name">
							<xsl:with-param name="module" select="$essential[$pos]"/>
						</xsl:call-template>
					</td>
					<td>
						<xsl:value-of select="$internal[$pos]/field[@name='linkSize']/@value"/><xsl:if test="substring($internal[$pos]/field[@name='slotUniq']/@value, 1, 8) = 'Military'">M</xsl:if>
					</td> 
					<td>
						<xsl:call-template name="module_name">
							<xsl:with-param name="module" select="$internal[$pos]"/>
						</xsl:call-template>
					</td>
				</tr>
				<xsl:call-template name="module-line">
					<xsl:with-param name="weapon" select="$weapon"/>
					<xsl:with-param name="utility" select="$utility"/>
					<xsl:with-param name="essential" select="$essential"/>
					<xsl:with-param name="internal" select="$internal"/>
					<xsl:with-param name="pos" select="number($pos + 1)"/>
				</xsl:call-template>
			</xsl:if>
		</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="module_name">
		<xsl:param name="module"/>
		<xsl:if test="$module">
			<xsl:value-of select="$module/field[@name='moduleRating']/@value"/><xsl:value-of select="$module/field[@name='moduleClass']/@value"/><xsl:text> </xsl:text>
			<xsl:choose>
				<xsl:when test="string-length($module/field[@name='moduleName']/@value) = 0">
					<xsl:value-of select="$module/field[@name='moduleGroupName']/@value"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$module/field[@name='moduleName']/@value"/>
				</xsl:otherwise>
			</xsl:choose>
			<xsl:if test="string-length($module/field[@name='moduleWeaponMode']/@value) != 0">&#160;<img width="15" height="15" src="{$root}/images/weapon/ed-{$module/field[@name='moduleWeaponMode']/@value}.png" title="{$module/field[@name='moduleWeaponMode']/@value}"/></xsl:if>
			<xsl:if test="$module/field[@name='recipieName']/@value">
				<br/>
				<xsl:choose>
					<xsl:when test="$module/field[@name='recipieLevel']/@value = 1"><img src="{$root}/images/engineer_sm.png"/></xsl:when>
					<xsl:when test="$module/field[@name='recipieLevel']/@value = 2"><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/></xsl:when>
					<xsl:when test="$module/field[@name='recipieLevel']/@value = 3"><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/></xsl:when>
					<xsl:when test="$module/field[@name='recipieLevel']/@value = 4"><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/></xsl:when>
					<xsl:when test="$module/field[@name='recipieLevel']/@value = 5"><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/><img src="{$root}/images/engineer_sm.png"/></xsl:when>
				</xsl:choose>
				<a class="show-modifyers" href="#" style="margin-left: 5px; text-decoration: underline;">
					<xsl:choose>
						<xsl:when test="string-length($module/field[@name='recipieLocName']/@value) != 0"><xsl:value-of select="i10n:tr($module/field[@name='recipieLocName']/@value)"/></xsl:when>
						<xsl:otherwise><xsl:value-of select="i10n:tr($module/field[@name='recipieName']/@value)"/></xsl:otherwise>
					</xsl:choose>
					<xsl:if test="string-length($module/field[@name='effectName']/@value) != 0"> / <xsl:value-of select="$module/field[@name='effectName']/@value"/> </xsl:if>
				</a>
				<xsl:if test="count($module/modifyers/item) != 0">
					<div class="modifyer hidden">
						<xsl:for-each select="$module/modifyers/item">
							<div>&#160;</div>
							<div class="col-md-4">
								<xsl:value-of select="field[@name='direction']/@value"/>
								<xsl:choose>
									<xsl:when test="string-length(field[@name='modifierName']/@value) != 0"><xsl:value-of select="i10n:tr(field[@name='modifierName']/@value)"/></xsl:when>
									<xsl:otherwise><xsl:value-of select="i10n:tr(field[@name='modifierUniq']/@value)"/></xsl:otherwise>
								</xsl:choose>
							</div>
							<div class="col-md-7">
								<xsl:value-of select="field[@name='displayValue']/@value"/>(<xsl:value-of select="field[@name='value']/@value"/>)
							</div>
						</xsl:for-each>
					</div>
				</xsl:if>
				<!-- 
				<table class="table table-condensed">
					<xsl:for-each select="$module/modifyers/item">
						<tr>
							<td width="20px;">&#160;</td>
							<td width="30%"><xsl:value-of select="field[@name='direction']/@value"/>
								<xsl:choose>
									<xsl:when test="string-length(field[@name='modifierName']/@value) != 0"><xsl:value-of select="field[@name='modifierName']/@value"/></xsl:when>
									<xsl:otherwise><xsl:value-of select="field[@name='modifierUniq']/@value"/></xsl:otherwise>
								</xsl:choose>
							</td>
							<td><xsl:value-of select="field[@name='displayValue']/@value"/>(<xsl:value-of select="field[@name='value']/@value"/>)</td>
						</tr>	
					</xsl:for-each>
				</table>
				 -->
			</xsl:if>		
		</xsl:if>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_power">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<div><h3><xsl:value-of select="field[@name='pilotName']/@value"/></h3></div>

		<div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th rowspan="2">Week Start Time</th>
						<th colspan="3">Merits</th>
						<th rowspan="2">Credits Spend</th>
					</tr>
					<tr>
						<th>Delivery</th>
						<th>Killing</th>
						<th>Expansion</th>
					</tr>
				</thead>
				<tbody>
					<xsl:for-each select="item[@name='powers']/weeks/item">
						<xsl:variable name="week"><xsl:value-of select="field[@name='startWeek']/@value"/></xsl:variable>
						<xsl:variable name="week_pos" select="position()"/>
						<tr>
							<td><xsl:value-of select="$week"/></td>	
							<td>
								<xsl:for-each select="/*/item[@name='powers']/meritsDeliver/item[field[@name='startWeek']/@value = $week]">
									<xsl:value-of select="field[@name='quantitySumm']/@value"/> / <xsl:value-of select="field[@name='systemName']/@value"/><br/>
								</xsl:for-each>
							</td>	
							<td>
								<!-- 
								<xsl:for-each select="/*/item[@name='powers']/meritsKill/item[field[@name='startWeek']/@value = $week]">
									<xsl:value-of select="number(field[@name='quantitySumm']/@value) * 30"/> / <xsl:value-of select="field[@name='systemName']/@value"/><br/>
								</xsl:for-each>
								 -->
								<xsl:for-each select="/*/item[@name='powers']/meritsKill/item[field[@name='startWeek']/@value = $week]">
									<xsl:choose>
										<xsl:when test="$week_pos = 1">
											<xsl:choose>
												<xsl:when test="field[@name='isConfirmed']/@value = 1">
													<xsl:value-of select="number(field[@name='quantitySumm']/@value) * 30"/> / <xsl:value-of select="field[@name='systemName']/@value"/><br/>
												</xsl:when>
												<xsl:otherwise>
													<strike><xsl:value-of select="number(field[@name='quantitySumm']/@value) * 30"/></strike> / <xsl:value-of select="field[@name='systemName']/@value"/><br/>
												</xsl:otherwise>
											</xsl:choose>
										</xsl:when>
										<xsl:otherwise>
											<xsl:choose>
												<xsl:when test="field[@name='isConfirmed']/@value = 1">
													<xsl:value-of select="number(field[@name='quantitySumm']/@value) * 30"/> / <xsl:value-of select="field[@name='systemName']/@value"/><br/>
												</xsl:when>
											</xsl:choose>
										</xsl:otherwise>
									</xsl:choose>
								</xsl:for-each>
							</td>	
							<td>
								<xsl:for-each select="/*/item[@name='powers']/meritsWar/item[field[@name='startWeek']/@value = $week]">
									<xsl:choose>
										<xsl:when test="$week_pos = 1">
											<xsl:choose>
												<xsl:when test="field[@name='isConfirmed']/@value = 1">
													<xsl:value-of select="number(field[@name='quantitySumm']/@value) * 10"/> / <xsl:value-of select="field[@name='systemName']/@value"/><br/>
												</xsl:when>
												<xsl:otherwise>
													<strike><xsl:value-of select="number(field[@name='quantitySumm']/@value) * 10"/></strike> / <xsl:value-of select="field[@name='systemName']/@value"/><br/>
												</xsl:otherwise>
											</xsl:choose>
										</xsl:when>
										<xsl:otherwise>
											<xsl:choose>
												<xsl:when test="field[@name='isConfirmed']/@value = 1">
													<xsl:value-of select="number(field[@name='quantitySumm']/@value) * 10"/> / <xsl:value-of select="field[@name='systemName']/@value"/><br/>
												</xsl:when>
											</xsl:choose>
										</xsl:otherwise>
									</xsl:choose>
								</xsl:for-each>
							</td>	
							<td>
								<xsl:for-each select="/*/item[@name='powers']/creditsSpend/item[field[@name='startWeek']/@value = $week]">
									<xsl:value-of select="field[@name='quantitySumm']/@value"/> Cr.<br/>
								</xsl:for-each>
							</td>	
						</tr>
					</xsl:for-each>
				</tbody>
				
			</table>

		
		</div>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_missions">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<xsl:variable name="total" select="format-number(sum(childs/item/field[@name='reward']/@value), '### ### ### ###', 'revards')"/>	
		<xsl:variable name="infH" select="count(childs/item[field[@name='influence' and @value = 'High']])"/>	
		<xsl:variable name="infM" select="count(childs/item[field[@name='influence' and @value = 'Med']])"/>	
		<xsl:variable name="infL" select="count(childs/item[field[@name='influence' and @value = 'Low']])"/>	
		<xsl:variable name="repH" select="count(childs/item[field[@name='reputation' and @value = 'High']])"/>	
		<xsl:variable name="repM" select="count(childs/item[field[@name='reputation' and @value = 'Med']])"/>	
		<xsl:variable name="repL" select="count(childs/item[field[@name='reputation' and @value = 'Low']])"/>
        <div class="page-title">
          <div class="title_left">
          	<form class="form-inline date-range-form" style="position: relative;">
			  <div class="form-group">
			  	<label for="exampleInputName2">Range: </label>
			  </div>
			  <div id="select-date-start" class="form-group data">
					<input id="start-date-selected" class="form-control hidden" type="text" style="border:none;" value="{/*/@start_date}" name="from"/>
					<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
					<span style="padding-left: 5px; padding-right: 5px;"></span>
					<b class="caret"></b>
			  </div>
			  <div class="form-group">
			  	<label for="exampleInputName2" style="margin-left: 5px; margin-right: 5px;">-</label>
			  </div>
			  <div id="select-date-end" class="form-group data">
				<input id="end-date-selected" class="form-control hidden" type="text" style="border:none;" value="{/*/@end_date}" name="to"/>
				<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
				<span style="padding-left: 5px; padding-right: 5px;"></span>
				<b class="caret"></b>
			  </div>
			  <div class="form-group">
			  	<label for="exampleInputName2" style="margin-left: 25px;">System: </label>
			  </div>
			  <div class="form-group data">
			  	<select name="system" class="selectpicker reset-selector" data-live-search="true" title="Select system...">
			  		<option value=""></option>
			  		<xsl:for-each select="additionFour/item">
			  			<option value="{field[@name='systemId']/@value}">
			  				<xsl:if test="field[@name='systemId']/@value = /*/@systemid">
			  					<xsl:attribute name="selected">selected</xsl:attribute>
			  				</xsl:if>
			  				<xsl:value-of select="field[@name='systemName']/@value"/>
			  			</option>
			  		</xsl:for-each> 
			  	</select>
			  </div>
			  <div class="form-group">
			  	<label for="exampleInputName2" style="margin-left: 25px;">Faction: </label>
			  </div>
			  <div class="form-group data">
			  	<select name="faction" class="selectpicker reset-selector" data-live-search="true" title="Select faction...">
			  		<option value=""></option>
			  		<xsl:for-each select="additionThree/item">
			  			<option value="{field[@name='factionId']/@value}">
			  				<xsl:if test="field[@name='factionId']/@value = /*/@factionid">
			  					<xsl:attribute name="selected">selected</xsl:attribute>
			  				</xsl:if>
			  				<xsl:value-of select="field[@name='factionName']/@value"/>
			  			</option>
			  		</xsl:for-each> 
			  	</select>
			  </div>
			  <div class="form-group"><button type="submit" class="btn">Filter</button></div>
			</form>
          </div>
		</div>	
		<div>
		<div class="list-group">
  			<a class="list-group-item show-statistic" href="#">Show statistic<i class="fa fa-sort-down fa-fw" aria-hidden="true"></i></a>
  			<a class="list-group-item hide-statistic hidden" href="#">Hide statistic<i class="fa fa-sort-up fa-fw" aria-hidden="true"></i></a>
			<dl class="dl-horizontal list-group-item statistic hidden" >
				<dt>Missions: </dt>
				<dd class="sum-count"><xsl:value-of select="count(childs/item)"/></dd>
				<dt>Influence: </dt>
				<dd class="sum-influence"><xsl:value-of select="$infH"/>/+++, <xsl:value-of select="$infM"/>/++, <xsl:value-of select="$infL"/>/+</dd>
				<dt>Reputation: </dt>
				<dd class="sum-reputation"><xsl:value-of select="$repH"/>/+++, <xsl:value-of select="$repM"/>/++, <xsl:value-of select="$repL"/>/+</dd>
				<dt>Credits: </dt>
				<dd class="sum-total"><xsl:value-of select="$total"/></dd>
			</dl>
  		</div>	
		<table class="table table-bordered">
			<thead>
				<tr>
					<th width="20px;"></th>
					<th>Complete</th>
					<th>Type</th>
					<th>Inf</th>
					<th>Rep</th>
					<th>Faction</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Passengers</th>
					<th>Credits</th>
					<th>Commodities</th>
					<th>Materials</th>
				</tr>
			</thead>
			<tbody>
				<xsl:for-each select="childs/item">
					<tr>
						<td><input type="checkbox" class="recount"/></td>
						<td><xsl:value-of select="field[@name='missionDate']/@value"/></td>
						<td><xsl:value-of select="field[@name='missionTypeName']/@value"/></td>
						<td class="count-influence" data-influence="{field[@name='influence']/@value}"><xsl:call-template name="showInfRep"><xsl:with-param name="inf" select="field[@name='influence']/@value"/></xsl:call-template></td>
						<td class="count-reputation" data-reputation="{field[@name='reputation']/@value}"><xsl:call-template name="showInfRep"><xsl:with-param name="inf" select="field[@name='reputation']/@value"/></xsl:call-template></td>
						<td><xsl:value-of select="field[@name='factionName']/@value"/></td>
						<td><xsl:value-of select="field[@name='systemName']/@value"/> / <xsl:value-of select="field[@name='stationName']/@value"/></td>
						<td>
							<xsl:if test="string-length(field[@name='targetSystemName']/@value) != 0">
								<xsl:value-of select="field[@name='targetSystemName']/@value"/>
								<xsl:if test="string-length(field[@name='targetStationName']/@value) != 0">
									/ <xsl:value-of select="field[@name='targetStationName']/@value"/>
								</xsl:if>
							</xsl:if>
						</td>
						<td><xsl:value-of select="field[@name='passengers']/@value"/></td>
						<td class="count-rewards" data-rewards="{number(field[@name='reward']/@value)}"><xsl:value-of select="format-number(field[@name='reward']/@value, '### ### ###', 'revards')"/></td>
						<td>
							<xsl:for-each select="field[@name='commodityId']/value">
								<xsl:variable name="id" select="@value"/>
								<xsl:value-of select="/item/additionOne/item[field[@name='commodityId']/@value = $id]/field[@name='commodityName']/@value"></xsl:value-of><br/>
							</xsl:for-each>
						</td>
						<td>
							<xsl:for-each select="field[@name='materialId']/value">
								<xsl:variable name="id" select="@value"/>
								<xsl:value-of select="i10n:tr(/item/additionTwo/item[field[@name='materialId']/@value = $id]/field[@name='materialUniq']/@value)"></xsl:value-of><br/>
							</xsl:for-each>
						</td>
					</tr>
				</xsl:for-each>
			</tbody>
		</table>
		</div>			
		<script type="text/javascript">
			$(function() {
				var dRange = new DateRange();
				
				var mindate = '<xsl:value-of select="/*/@mindate"/>';
				var maxdate = '<xsl:value-of select="/*/@maxdate"/>';
				var start_date = '<xsl:value-of select="/*/@start_date"/>';
				var end_date = '<xsl:value-of select="/*/@end_date"/>';
				dRange.setMinMax(mindate,maxdate);
				dRange.setRange(start_date,end_date);
				
				$('.reset-selector').on('change', function() {
					if ($(this).val()) {
						dRange.setRange(mindate, maxdate);
					} else {
						dRange.setRange(start_date,end_date);
					}
					$('#start-date-selected').val(dRange.getStartDate().format('YYYY-MM-DD'));
					$('#end-date-selected').val(dRange.getEndDate().format('YYYY-MM-DD'));
				});
				
				$('.show-statistic, .hide-statistic').on('click', function() {
					$('.show-statistic, .hide-statistic, .statistic').toggleClass('hidden');
					return false;
				});
				
				// Count statistic
				var dCount = "<xsl:value-of select="count(childs/item)"/>";
				var dTotal = "<xsl:value-of select="$total"/>";
				var dInfH = "<xsl:value-of select="$infH"/>";
				var dInfM = "<xsl:value-of select="$infM"/>";
				var dInfL = "<xsl:value-of select="$infL"/>";
				var dRepH = "<xsl:value-of select="$repH"/>";
				var dRepM = "<xsl:value-of select="$repM"/>";
				var dRepL = "<xsl:value-of select="$repL"/>";
				
				var count = 0, total = 0, inf = {'High': 0, 'Med': 0, 'Low': 0}, rep = {'High': 0, 'Med': 0, 'Low': 0};
				
				var showStatistic = function() {
					var c = dCount, t = dTotal, i = {'High': dInfH, 'Med': dInfM, 'Low': dInfL}, r = {'High': dRepH, 'Med': dRepM, 'Low': dRepL};
					if (count > 0) {
						c = count;
						var absTotal = number_format(Math.abs(total), 0, '', ' '); 
						t = (total &lt; 0?'-':'') + absTotal; 
						i = inf; 
						r = rep;
					}
					$('.sum-count').html(c);
					$('.sum-total').html(t);
					$('.sum-influence').html(i['High'] + '/+++, ' + i['Med'] + '/++, ' + i['Low'] + '/+')
					$('.sum-reputation').html(r['High'] + '/+++, ' + r['Med'] + '/++, ' + r['Low'] + '/+')
				}; 
				
				$('.recount').on('change', function() {
					var sign = $(this).prop('checked')?1:-1;
					var tr = $(this).parents('tr')[0];
					
					count += sign;
					total += sign * parseInt($(tr).find('.count-rewards').data('rewards'));
					var key = $(tr).find('.count-influence').data('influence'); 
					inf[key] += sign;
					key = $(tr).find('.count-reputation').data('reputation'); 
					rep[key] += sign;
					
					showStatistic();
				});
			});
		</script>
		<div class="clearfix"></div>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="showInfRep">
		<xsl:param name="inf"/>
		<xsl:choose>
			<xsl:when test="$inf = 'Low'">+</xsl:when>
			<xsl:when test="$inf = 'Med'">++</xsl:when>
			<xsl:when test="$inf = 'High'">+++</xsl:when>
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_locations1">

		<div class="clearfix"></div>
		<!-- Location -->
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<xsl:value-of select="i10n:tr('Systems Path')"/>
					<small></small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<table id="table-system-path" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>Time</th>
                          <th>Name</th>
                          <th>Position</th>
                          <th>Distance</th>
                        </tr>
                      </thead>
				</table>
			</div>
		</div>
		<script>
			$(function() {
			
				var pilot = '<xsl:value-of select="$pilot"/>';
			
				$('#table-system-path').DataTable({
					ajax: {
						url: site_root + '/ajax/pilots/'+ pilot + '/systems/',
						"dataSrc": "systems",
					},
					"columns": [
						{ "data": "timestamp" },
						{ "data": "systemName" },
						{ "data": "position" },
						{ "data": "distance" },
					],
					/* 
					deferRender: true,
					scrollY: 380,
					scrollCollapse: true,
					scroller: true
					*/
				});				
			});
		</script>
	</xsl:template>	
<!--
//
//
//
-->
	<xsl:template name="view_locations">

		<div class="clearfix"></div>
		<!-- Location -->
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<xsl:value-of select="i10n:tr('Systems Path')"/>
					<small></small>
				</h2>
				<div class="filter">
					<div id="select-date-end" class="pull-right data" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
						<input id="end-date-selected" class="form-control hidden" type="text" style="border:none;" value="{/*/@end_date}"/>
						<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
						<span style="padding-left: 5px; padding-right: 5px;"></span>
						<b class="caret"></b>
					</div>
					<div class="pull-right data" style="background: #fff; cursor: pointer; padding: 5px 10px;">
						-
					</div>
					<div id="select-date-start" class="pull-right data" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
						<input id="start-date-selected" class="form-control hidden" type="text" style="border:none;" value="{/*/@start_date}"/>
						<i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
						<span style="padding-left: 5px; padding-right: 5px;"></span>
						<b class="caret"></b>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="x_content ">
				<table class="table table-striped table-bordered">
	                <thead>
	                  <tr>
	                    <th>Time</th>
	                    <th>Name</th>
	                    <th>Position</th>
	                    <th>Distance</th>
	                    <th>Activity</th>
	                  </tr>
	                </thead>
	                <tbody id="locations-content" class="updated-by-time" data-update-function="updateSystems" data-update-interval="30000">
						<tr class="sceleton hidden">
							<td><nobr class="star-time"></nobr></td>
							<td><nobr class="star-name"></nobr></td>
							<td><nobr class="star-coord"></nobr></td>
							<td><nobr class="star-distance"></nobr></td>
							<td class="star-activity"></td>
						</tr>
	                </tbody>	
				</table>
			</div>
		</div>
		<script>
			$(function() {
			
				var pilot = '<xsl:value-of select="$pilot"/>';
				
				var start_date = moment(Date.parse("<xsl:value-of select="/*/@start_date"/>").getTime());
				var end_date = moment(Date.parse("<xsl:value-of select="/*/@end_date"/>").getTime());
				var update_date = end_date;
				
				var lastSystemId = 0; 
					
				updateSystems = function() {
					//console.log("Try to Update");
					if ("<xsl:value-of select="/*/@end_date"/>" == end_date.format('YYYY-MM-DD')) {
						//console.log("Update");
						var data = {
							startdate: update_date.format('YYYY-MM-DD HH:mm:ss'),
						};
						proxy.makeCall('post', '/ajax/pilots/'+ pilot + '/systems/', null, null, data, function(result) {
							if (result.systems &amp;&amp; result.systems.length &gt; 0) {
								$('#locations-content').find('.bg-new-system').removeClass('bg-new-system');
								update_date = moment(Date.parse(result.systems[0].stationTimestamp?result.systems[0].stationTimestamp:result.systems[0].timestamp).getTime());
								var prev_element = $('.sceleton').next();
								var systems = result.systems.reverse();
								systems.forEach(function(system) {
									var elem = null;
									if (prev_element.attr('id') != '' + system.systemId) {
										elem = $('.sceleton').clone();
										elem.addClass('locations');
										elem.removeClass('sceleton');
										elem.removeClass('hidden');
										elem.addClass('bg-new-system');
										elem.attr('id', system.systemId);
										$('.star-name', elem).html(system.systemName);
										$('.star-coord', elem).html(system.position);
										$('.star-time', elem).html(system.timestamp);
										$('.star-distance', elem).html(system.distance);
										$(elem).insertBefore(prev_element);
										prev_element = elem;
									} else {
										elem = prev_element;
										elem.addClass('bg-new-system');
									}
									if (system.stationId) {
										$('<span class="fa fa-life-ring" aria-hidden="true"> ' + system.stationName + '</span>').appendTo($('.star-activity', elem));
									} else if (system.bodyId) {
										$('<span class="fa fa-circle" aria-hidden="true"> ' + system.bodyName + '</span>').appendTo($('.star-activity', elem));
									} else {
										$('<span class="fa fa-rocket" aria-hidden="true"></span>').appendTo($('.star-activity', elem));
									}
								});
							}
							
						});
					}
				}
			
				var updateLocations = function() {
					var data = {
						startdate: start_date.format('YYYY-MM-DD'),
						enddate: end_date.format('YYYY-MM-DD'),
					};
					proxy.makeCall('post', '/ajax/pilots/'+ pilot + '/systems/', null, null, data, function(result) {
						if (result.systems) {
							if (result.systems.length &gt; 0) {
								//update_date = moment(Date.parse(result.systems[0].timestamp).getTime());
								update_date = moment(Date.parse(result.systems[0].stationTimestamp?result.systems[0].stationTimestamp:result.systems[0].timestamp).getTime());
							}
							$('#locations-content').find('.locations').remove();
							var systems = result.systems.reverse();
							systems.forEach(function(system) {
								var elem = null; 
								if (lastSystemId != system.systemId) {
									lastSystemId = system.systemId;
									elem = $('.sceleton').clone();
									elem.addClass('locations');
									elem.removeClass('sceleton');
									elem.removeClass('hidden');
									elem.attr('id', system.systemId);
									$('.star-name', elem).html(system.systemName);
									$('.star-coord', elem).html(system.position);
									$('.star-time', elem).html(system.timestamp);
									$('.star-distance', elem).html(system.distance);
									
									$(elem).insertAfter('.sceleton');
								} else {
									//elem = $('#' + 'system_' + system.systemId);
									var elems = $('#locations-content').find('.locations');
									elem = elems[0];
								}
								
								if (system.stationId) {
									$('<span class="fa fa-life-ring" aria-hidden="true"> ' + system.stationName + '</span>').appendTo($('.star-activity', elem));
								} else if (system.bodyId) {
									$('<span class="fa fa-circle" aria-hidden="true"> ' + system.bodyName + '</span>').appendTo($('.star-activity', elem));
								} else {
									$('<span class="fa fa-rocket" aria-hidden="true"></span>').appendTo($('.star-activity', elem));
								}
							});
						}
						
					});
				}
				
				//
				var setStartDateLabel = function() {
					$("#select-date-start").find("span").html(start_date.format('DD MMMM YYYY'));
				}
				 
				var setEndDateLabel = function() {
					$("#select-date-end").find("span").html(end_date.format('DD MMMM YYYY'));
				} 
				
				setStartDateLabel();
				setEndDateLabel();
				
				$("#select-date-start").datetimepicker({
					format: "YYYY-MM-DD",
                	viewMode: 'days',
                	
                	viewDate: start_date,
					maxDate: end_date,
					minDate: "<xsl:value-of select="/*/@mindate"/>",
            	}).on('dp.change', function(e) {
            		start_date = moment(e.date);
					setStartDateLabel();
					updateLocations();
            	});
				
            	$("#select-date-start").on('click', function() {
            		$("#select-date-start").data("DateTimePicker").viewDate(start_date);
            		//$("#select-date-start").data("DateTimePicker").viewMode('days');
            		$("#select-date-start").data("DateTimePicker").toggle();
            	});
				
				$("#select-date-end").datetimepicker({
					format: "YYYY-MM-DD",
                	viewMode: 'days',
                	viewDate: end_date,
					maxDate: "<xsl:value-of select="/*/@maxdate"/>",
					minDate: start_date,
            	}).on('dp.change', function(e) {
            		end_date = moment(e.date);
					setEndDateLabel();
					updateLocations();
            	});
				
            	$("#select-date-end").on('click', function() {
            		//$("#select-date-end").data("DateTimePicker").viewMode('days');
            		$("#select-date-end").data("DateTimePicker").toggle();
            	});
				
				updateLocations();
			});
		</script>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_materials">
	
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<div class="page-title">
			<div class="title_left">
				<form class="form-inline">
					<div class="form-group">
						<label>
							<xsl:value-of select="i10n:tr('sort_by')" />
							:&#160;&#160;&#160;
						</label>
						<div class="radio">
							<label>
								<input type="radio" class="flat" value="alphabetical" name="material_sorting">
									<xsl:if test="/*/@sort = 'alphabetical'">
										<xsl:attribute name="checked">checked</xsl:attribute>
									</xsl:if>
								</input>
								&#160;
								<xsl:value-of select="i10n:tr('sort_by_alphabetial')" />
								&#160;&#160;
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" class="flat" value="updated" name="material_sorting">
									<xsl:if test="/*/@sort = 'updated'">
										<xsl:attribute name="checked">checked</xsl:attribute>
									</xsl:if>
								</input>
								&#160;
								<xsl:value-of select="i10n:tr('sort_by_updated')" />
								&#160;&#160;
							</label>
						</div>
						<div class="radio">
							<label>
								<input type="radio" class="flat" value="quantity" name="material_sorting">
									<xsl:if test="/*/@sort = 'quantity'">
										<xsl:attribute name="checked">checked</xsl:attribute>
									</xsl:if>
								</input>
								&#160;
								<xsl:value-of select="i10n:tr('sort_by_quantity')" />
								&#160;&#160;
							</label>
						</div>
					</div>
					<div class="form-group" style="margin-left: 50px;">
						<button type="button" class="btn" data-toggle="modal" data-target="#engeenerModal" id="btn-engeneers"><i class="fa fa-gear"></i> Engeneers Filter</button>
						<button type="button" class="btn hidden" id="main-btn-clear">X</button>
					</div>
				</form>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="form-materials updated-by-time" data-update-function="updateFromServer" data-update-interval="30000">
			<div class="col-md-4 col-xs-12 widget widget_tally_box width-650 encoded" data-material="encoded">
				<div class="x_panel">
					<div class="x_title">
						<h2><xsl:value-of select="i10n:tr('Encoded')"/></h2>
						<i class="fa fa-refresh fa-spin fa-2x fa-fw hidden"></i>
	                    <ul class="nav navbar-right panel_toolbox">
	                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
	                    </ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table">
							<xsl:for-each select="childs/item[field[@name='materialCategoryId']/@value=1]">
								<xsl:call-template name="view-material"></xsl:call-template>
							</xsl:for-each>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-xs-12 widget widget_tally_box width-650 manufactured" data-material="manufactured">
				<div class="x_panel">
					<div class="x_title">
						<h2><xsl:value-of select="i10n:tr('Manufactured')"/></h2>
						<i class="fa fa-refresh fa-spin fa-2x fa-fw hidden"></i>
	                    <ul class="nav navbar-right panel_toolbox">
	                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
	                    </ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table">
							<xsl:for-each select="childs/item[field[@name='materialCategoryId']/@value=2]">
								<xsl:call-template name="view-material"></xsl:call-template>
							</xsl:for-each>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-xs-12 widget widget_tally_box width-650 raw" data-material="raw">
				<div class="x_panel">
					<div class="x_title">
						<h2><xsl:value-of select="i10n:tr('Raw')"/></h2>
						<i class="fa fa-refresh fa-spin fa-2x fa-fw hidden"></i>
	                    <ul class="nav navbar-right panel_toolbox">
	                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
	                    </ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table">
							<xsl:for-each select="childs/item[field[@name='materialCategoryId']/@value=3]">
								<xsl:call-template name="view-material"></xsl:call-template>
							</xsl:for-each>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="materialModalLabel"  id="materialModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true"><xsl:text disable-output-escaping="yes">&amp;times;</xsl:text> 
							</span>
						</button>
						<h4 class="modal-title" id="materialModalLabel">Modal title</h4><small>используется в</small>
					</div>
					<div class="modal-body">
						<table class="table">
						</table>
					</div>
					<!--
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button>
					</div>
					-->
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->		
		<div class="clearfix"></div>
		<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="#engeenerModalLabel"  id="engeenerModal">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true"><xsl:text disable-output-escaping="yes">&amp;times;</xsl:text> 
							</span>
						</button>
						<h4 class="modal-title" id="engeenerModalLabel">Engeneers filter</h4><small>выберите чертежи для фильтрации</small>
					</div>
					<div class="modal-body">
						<div id="engeneerTree">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-danger" id="btn-clear">Clear</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->		
		<script>
		
			// +Tree data
			var tree = [
				<xsl:for-each select="eng_types/item"><xsl:variable name="typeId" select="field[@name='engTypeId']/@value"/>
				{
					text: "<xsl:value-of select="field[@name='localized']/@value"/>",
					selectable: false,
					nodeType: "type",
					state: {
						expanded: false,
					},
					nodes: [
						<xsl:for-each select="/item/eng_blueprints/item[field[@name='engTypeId']/@value = $typeId]"><xsl:variable name="blueprintId" select="field[@name='engBlueprintId']/@value"/>
						{
							text: "<xsl:value-of select="field[@name='localized']/@value"/>",
							selectable: false,
							nodeType: "blueprint",
							nodes: [
								<xsl:for-each select="/item/eng_grades/item[field[@name='engBlueprintId']/@value = $blueprintId]"><xsl:variable name="gradeId" select="field[@name='engGradeId']/@value"/>
								{
									text: "<xsl:value-of select="field[@name='grade']/@value"/> grade " <xsl:if test="count(/item/eng_engeneers/item[field[@name='engGradeId']/@value = $gradeId])">+ "[<xsl:value-of select="/item/eng_engeneers/item[field[@name='engGradeId']/@value = $gradeId]/field[@name='engeneers']/@value"/>]"</xsl:if>,
									selectable: false,
									nodeType: "grade",
									materials: [<xsl:for-each select="/item/eng_materials/item[field[@name='engGradeId']/@value = $gradeId]">
										"<xsl:value-of select="field[@name='materialUniq']/@value"/>",
									</xsl:for-each>],
								},
								</xsl:for-each>
							],
						},
						</xsl:for-each>
					],
				},
				</xsl:for-each>
			]; 
		
			var relation = {};
			
			// -Tree data
			$(function() {
				/*
				+Modal
				*/
				var eng_info = {};
				
				var showMaterialInfo = function(material) {
					if (eng_info[material]) {
						var container = $('#materialModal').find('table');
						$(container).children().remove();
						$('#materialModal').find('h4').html(eng_info[material][0]['materialLoc']);
						eng_info[material].forEach(function(m) {
							$('&lt;tr&gt;&lt;td class="col-md-8"&gt;' + m.engTypeName +' / ' + m.engBlueprintName +'&lt;/td&gt;&lt;td&gt;' + m.engeneers +'&lt;/td&gt;&lt;td width="1%"&gt;' + m.grade +'&lt;/td&gt;&lt;/tr&gt;').appendTo(container);
						});
					}
				}
				
				$('#materialModal').on('show.bs.modal', function(e)  {
					var material = $(e.relatedTarget).parents('tr').attr('id');
					if (eng_info[material]) {
						showMaterialInfo(material);
					} else {
						proxy.makeCall('post', '/ajax/utility/material-grades/', null, null, {material: material}, function(result) {
							eng_info[material] = result['material'];
							//console.log(eng_info[material]);
							showMaterialInfo(material);
						});
					}
				});
				
				/*
				-Modal
				*/
				var pilot = '<xsl:value-of select="$pilot"/>';
			
				var counter = 0;
				
				var send_data = null; 
				
				var material_sorting = '<xsl:value-of select="/*/@sort"/>';
				
				var updating = false;
				
				updateFromServer = function(data, callback) {
					if (!send_data &amp;&amp; !updating) {
						updating = true;
						if (!data) {
							data = {};
						}
						data['material_sorting'] = material_sorting; 
						proxy.makeCall('post', '/ajax/pilots/'+ pilot + '/materials/', null, null, data, function(result) {
							//console.log(result);
							$('.form-materials').find('.material-quantity').each(function() {
								$(this).removeClass('bg-danger bg-info bg-primary').addClass('bg-success');
							});
							if (result.materials) {
								var materials = {};
								result.materials.forEach(function(m, i) {
									if (m.quantity != $('#' + m.materialUniq).find('.button-switch').html()) {
										$('#' + m.materialUniq).find('input').val(m.quantity);
										$('#' + m.materialUniq).find('.material-quantity').removeClass('bg-success bg-info bg-primary bg-danger').addClass(m.updateTime &lt; 31?'bg-info':'bg-primary');
										$('#' + m.materialUniq).find('.button-switch').html(m.quantity);
									} else if (m.updateTime &lt; 61) {
										$('#' + m.materialUniq).find('.material-quantity').removeClass('bg-success bg-info bg-primary bg-danger').addClass(m.updateTime &lt; 31?'bg-info':'bg-primary');
										$('#' + m.materialUniq).find('.button-switch').html(m.quantity);
									}
									if (!materials[m.materialCategoryName]) {
										materials[m.materialCategoryName] = [];
									}
									//m['index'] = i;
									materials[m.materialCategoryName].push(m); 
								});
								
								//console.log(materials);
								for (key in materials) {
									var mType = key.toLowerCase();
									//var trs = $("div." + mType).find("tr");
									materials[key].forEach(function(m, i) {
										var tr = $("div." + mType).find('tr:eq(' + i + ')');
										if (tr.attr('id') != m.materialUniq) {
											var mov = $('#' + m.materialUniq);
											mov.remove().insertBefore(tr);
										}
									});
								}
							}
							//switchClick();
							//updateInputEvents();
							if (callback) {
								callback(result);
							}
							updating = false;
						});
					}
				}
				
				$('input[name=material_sorting]').on('ifChecked', function(e) {
				//$('input[name=material_sorting]').on('change', function(e) {
					material_sorting = $(e.target).attr('value');
					//$("input[name=material_sorting]").val($(e.target).attr('value'));
					//console.log($("input[name=material_sorting]").val());
					//console.log(material_sorting);
					updateFromServer();
				});
				
				// Engeeneers Selectors
				var showHideMaterialRow = function(materials) {
					if (!materials || !materials.length) {
						$('tr.material-row').removeClass('hidden');
					} else {
						var matmap = {};
						materials.forEach(function(v) {
							//matmap[v.materialUniq] = true;
							matmap[v] = true;
						});
						$('tr.material-row').each(function() {
							var id = $(this).attr('id');
							if (matmap[id]) {
								$(this).removeClass('hidden');									
							} else {
								$(this).addClass('hidden');									
							}
						});
					}
				}

				/*				
				$('#eng-caterory').on('change', function() {
					var cat = $(this).val();
					$('#eng-blueprint').find('.dynamic-option').remove();
					var data = {};
					if (!cat) {
						$('#eng-blueprint').prop('disabled', true);
						showHideMaterialRow();
					} else {
						data['eng-category'] = cat;
						$('#eng-caterory').prop('disabled', true);
						$('#eng-blueprint').prop('disabled', true);
						proxy.makeCall('post', '/ajax/utility/materials/', null, null, data, function(result) {
							showHideMaterialRow(result.materials);
							// Upd
							var bp = '';
							var optgroup = null; 
							result.grades.forEach(function(v) {
								if (bp != v.engBlueprintUniq) {
									bp = v.engBlueprintUniq;
									optgroup = $('&lt;optgroup class="dynamic-option" data-blueprint="' + v.engBlueprintUniq + '" label="' + v.localized + '"&gt;&lt;/optgroup &gt;').appendTo('#eng-blueprint');
								}
								$($('&lt;option class="dynamic-option" data-blueptint="' + v.grade + '"&gt;' + v.grade + ' [' + v.engeneers + ']' + '&lt;/option &gt;').appendTo(optgroup)); 
							});
							$('#eng-caterory').prop('disabled', false);
							$('#eng-blueprint').prop('disabled', false);
						});
					}
				});
				
				$('#eng-blueprint').on('change', function() {
					var grade = $(this).val();
					var bp = $(this).find('option:selected').parent().data('blueprint');
					var cat = $('#eng-caterory').val();
					var data = {};
					if (cat) {
						data['eng-category'] = cat;
					}
					if (bp) {
						data['eng-blueprint'] = bp;
					}
					if (grade) {
						data['eng-grade'] = grade;
					}
					$('#eng-caterory').prop('disabled', true);
					$('#eng-blueprint').prop('disabled', true);
					proxy.makeCall('post', '/ajax/utility/materials/', null, null, data, function(result) {
						showHideMaterialRow(result.materials);
						$('#eng-caterory').prop('disabled', false);
						$('#eng-blueprint').prop('disabled', false);
					});
				});
				*/
				
				// Tree
				var childsChecked = function(node) {
					var result = false;
					if (node.nodes) {
						result = true;
						node.nodes.forEach(function(n) {
							if (!n.state || !n.state.checked) {
								result = false;
								return false;
							}
						});
					}
					return result;
				} 
				
				var checkedMaterials = [];
				var getCheckedMaterials = function(node) {
					if (node) {
						if (node.nodes) {
							node.nodes.forEach(function(v) {
								getCheckedMaterials(v);
							});
						} else if (node.state.checked &amp;&amp; node.materials) {
							checkedMaterials = checkedMaterials.concat(node.materials);
						}
					} else {
						tree.forEach(function(v) {
							getCheckedMaterials(v);
						});
					}
				}
				
				var checkNode = function(node, checked) {
					checkedMaterials = [];
					if (checked) {
						if (node.nodeType != 'grade') {
							$('#engeneerTree').treeview('expandNode', node.nodeId, {silent: true });
							node.nodes.forEach(function(v) {
								$('#engeneerTree').treeview('checkNode', v.nodeId, {silent: v.nodeType == 'grade' });
							});
						}
					} else {
						if (node.nodeType != 'grade') {
							if (childsChecked(node)) {
								node.nodes.forEach(function(v) {
									$('#engeneerTree').treeview('uncheckNode', v.nodeId, {silent: v.nodeType == 'grade' });
								});
							}
						}
						if (node.nodeType != 'type') {
							var parent = $('#engeneerTree').treeview('getParent', node.nodeId);
							$('#engeneerTree').treeview('uncheckNode', parent.nodeId, {silent: true });
							if (parent.parentId) {
								$('#engeneerTree').treeview('uncheckNode', parent.parentId, {silent: true });
							}
						}
					}
					getCheckedMaterials();
					if (!checkedMaterials.length) {
						$('#main-btn-clear').addClass('hidden');
						$('#btn-engeneers').removeClass('btn-primary');
					} else {
						$('#btn-engeneers').addClass('btn-primary');
						$('#main-btn-clear').removeClass('hidden');
						showHideMaterialRow(checkedMaterials);
					}
				};
		
				$('#engeneerTree').treeview({
					data: tree,
					showCheckbox: true,
					levels: 3,
				});
				
				$('#engeneerTree').on('nodeChecked', function(event, node) {
					checkNode(node, true);
				});
				$('#engeneerTree').on('nodeUnchecked', function(event, node) {
					checkNode(node, false);
				});
				
				var clearEngeneers = function() {
					showHideMaterialRow();
					$('#main-btn-clear').addClass('hidden');
					$('#btn-engeneers').removeClass('btn-primary');
					$('#engeneerTree').treeview('uncheckAll', {silent: true });
				}
				
				$('#btn-clear').on('click', function() {
					clearEngeneers();
				});
				
				$('#main-btn-clear').on('click', function() {
					clearEngeneers();
				});
				
			});
		</script>

	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view-material">
		<tr id="{field[@name='materialUniq']/@value}" class="material-row">
			<td>
				<img src="{$root}/images/materials/grade-{field[@name='materialGrade']/@value}.png" width="20" height="20"/>&#160;
				<xsl:value-of select="field[@name='localized']/@value"/>
				<xsl:if test="field[@name='used']/@value != '0'">
					&#160;<sup><button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#materialModal"><xsl:value-of select="field[@name='used']/@value"/>&#160;<i class="fa fa-cogs" aria-hidden="true"></i></button></sup>
				</xsl:if>
			</td>
			<td style="width:70px;">
				 <nobr class="material-quantity bg-success"><span class="button-switch"><xsl:value-of select="field[@name='quantity']/@value"/></span> / <xsl:value-of select="field[@name='materialMax']/@value"/></nobr>
			</td>
		</tr>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view-material-grade">
		<xsl:param name="grade"/>
		<xsl:choose>
			<xsl:when test="$grade = 5">100</xsl:when>
			<xsl:when test="$grade = 4">150</xsl:when>
			<xsl:when test="$grade = 3">200</xsl:when>
			<xsl:when test="$grade = 2">250</xsl:when>
			<xsl:when test="$grade = 1">300</xsl:when>
			<xsl:otherwise>?</xsl:otherwise>			
		</xsl:choose>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_gallery">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<div><h3></h3></div>
		<div id="links" style="text-align: center;">
			<xsl:for-each select="item/tumbnails/item[field[@name='configName' and @value='small']]">
				<xsl:variable name="pilot_dir">pilot<xsl:value-of select="format-number(../../field[@name='pilotId']/@value, '0000000000')" /></xsl:variable>
				<xsl:variable name="filename"><xsl:value-of select="format-number(field[@name='imageId']/@value, '0000000000')" /></xsl:variable>
				<xsl:variable name="slink"><xsl:value-of select="$root"/>/screenshot/<xsl:value-of select="$pilot_dir"/>/small/<xsl:value-of select="$filename"/>.<xsl:value-of select="field[@name='type']/@value"/></xsl:variable>
				<xsl:variable name="mlink"><xsl:value-of select="$root"/>/screenshot/<xsl:value-of select="$pilot_dir"/>/medium/<xsl:value-of select="$filename"/>.<xsl:value-of select="../item[field[@name='configName' and @value='medium']]/field[@name='type']/@value"/></xsl:variable>
				<xsl:variable name="original"><xsl:value-of select="$root"/>/screenshot/<xsl:value-of select="$pilot_dir"/>/<xsl:value-of select="$filename"/>.png</xsl:variable>
				<xsl:variable name="title"><xsl:value-of select="../../field[@name='imageDate']/@value"/>&#160;<xsl:value-of select="../../field[@name='systemName']/@value"/><xsl:if test="string-length(../../field[@name='bodyName']/@value)"> / <xsl:value-of select="../../field[@name='bodyName']/@value"/></xsl:if><xsl:if test="string-length(../../field[@name='stationName']/@value)"> / <xsl:value-of select="../../field[@name='stationName']/@value"/></xsl:if></xsl:variable>
				<div class="gallery-item">
					<div class="thumbnail" style="height: 240px;">
						<div class="image view view-first" style="height: 200px;">
							<a id="image-{$filename}" href="{$mlink}" title="{$title}" data-gallery="data-gallery" data-original="{$original}">
								<img src="{$slink}" alt="" style="display: block;"/>
							</a>
							<xsl:if test="string-length(/*/@owner) != 0">
								<div class="mask" style="height: 30px;">
									<div class="tools tools-bottom pull-right" style="margin-top: 2px;">
										<a href="#" class="remove-gallery-image" data-index="{position() - 1}" data-image-id="{field[@name='imageId']/@value}"><i class="fa fa-times"></i></a>
									</div>
								</div>
							</xsl:if>
							<!-- 
							 -->
						</div>
						<div class="caption">
							<p class="pull-left">
								<a href="{$original}" target="_tab"><i class="fa fa-download"></i></a>
							</p>
							<p class="pull-right">
								<small>
									<strong>
										<xsl:value-of select="../../field[@name='imageDate']/@value" />
									</strong>
								</small>
							</p>
						</div>
					</div>
				</div>
			</xsl:for-each>
		</div>
		<div class="clearfix"></div>
		<script type="text/javascript">
			var pilot = '<xsl:value-of select="$pilot"/>';
			$(function() {
				$('#blueimp-gallery').on('slide', function(event, index, slide) {
					var link = $('a[data-gallery=data-gallery]:eq(' + index + ')');
				    var href = $(link).data('original');
				    console.log(href);
				    var a = $('<a />', { href:href, text:'Download', target:'tab'});
				    $('.download').html(a);
				});				
				
				$('#blueimp-gallery').on('opened', function(e) {
					console.log(e);
				});
				
				$('.remove-gallery-image').on('click', function() {
					var element = this;
					eModal.confirm('Do you really delete image?', 'Remove image from gallery')
      				.then(function() {
      					
						var id = $(element).data('image-id');
						
      					proxy.makeCall('post', '/ajax/pilots/' + pilot + '/remove-gallery-image/', null, null, {image_id: id}, function(result) {
      						if(!result.error) {
								var index = $(element).data('index');
								$('.slide[data-index=' + index + ']').remove();
								$(element).parents('div.gallery-item').remove();
      						}
      					});
      				});
					return false;
				});
				
				if (window.location.hash.length &gt; 1) {
					var img = window.location.hash.substring(1);
					$('#image-' + img).trigger('click');
				}
			});
		</script>
	</xsl:template>	
<!--
//
//
//
-->
</xsl:stylesheet>
