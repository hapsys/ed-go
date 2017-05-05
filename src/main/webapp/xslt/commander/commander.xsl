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
		<div class="x_panel">
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
									<td colspan="2">
										<xsl:variable name="y" select="item[@name='lastActivityTime']/field[@name='year']/@value"/>
										<xsl:variable name="j" select="item[@name='lastActivityTime']/field[@name='monthes']/@value"/>
										<xsl:variable name="d" select="item[@name='lastActivityTime']/field[@name='days']/@value"/>
										<xsl:variable name="h" select="item[@name='lastActivityTime']/field[@name='hours']/@value"/>
										<xsl:variable name="m" select="item[@name='lastActivityTime']/field[@name='minutes']/@value"/>
										<xsl:variable name="s" select="item[@name='lastActivityTime']/field[@name='seconds']/@value"/>
										<xsl:call-template name="lastseen">
											<xsl:with-param name="lang" select="$language_id"/>
											<xsl:with-param name="sec" select="number($s)"/>
											<xsl:with-param name="min" select="number($m)"/>
											<xsl:with-param name="hou" select="number($h)"/>
											<xsl:with-param name="day" select="number($d)"/>
											<xsl:with-param name="mon" select="number($j)"/>
											<xsl:with-param name="yea" select="number($y)"/>
										</xsl:call-template> 
										<xsl:value-of select="i10n:tr('ago')"/>
									</td>
								</tr>
								<tr>
									<td class="col-md-1">Mode:</td>
									<td>
										<xsl:value-of
											select="item[@name='lastInfo']/field[@name='gameMode']/@value"
											disable-output-escaping="yes" />
									</td>
								</tr>
								<tr>
									<xsl:if test="string-length(item[@name='lastInfo']/field[@name='gameGroup']/@value) = 0">
										<xsl:attribute name="class">hidden</xsl:attribute>
									</xsl:if>
									<td class="col-md-1">Group:</td>
									<td>
										<xsl:value-of
											select="item[@name='lastInfo']/field[@name='gameGroup']/@value"
											disable-output-escaping="yes" />
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-xs-12 widget widget_tally_box">
					<div class="x_panel">
						<div class="x_title">
							<h2>Location</h2>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<table class="table">
								<tr>
									<td class="col-md-1">System:</td>
									<td>
										<xsl:value-of
											select="item[@name='location']/field[@name='systemName']/@value"
											disable-output-escaping="yes" />
									</td>
								</tr>
								<tr>
									<td class="col-md-1">Station:</td>
									<td>
										<xsl:value-of
											select="item[@name='location']/field[@name='stationName']/@value"
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
						select="item[@name='progress']/field[@name='combat']/@value" />
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
										select="number(item[@name='rank']/field[@name='combat']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
				<!-- Trade -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='progress']/field[@name='trade']/@value" />
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
										select="number(item[@name='rank']/field[@name='trade']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
				<!-- Explore -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='progress']/field[@name='explore']/@value" />
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
										select="number(item[@name='rank']/field[@name='explore']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
				<!-- CQC -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='progress']/field[@name='cqc']/@value" />
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
										select="number(item[@name='rank']/field[@name='cqc']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
				<!-- empire -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='progress']/field[@name='empire']/@value" />
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
										select="number(item[@name='rank']/field[@name='empire']/@value)" />
									<xsl:with-param name="lang" select="$language_id" />
								</xsl:call-template>
							</h3>
						</div>
					</div>
				</div>
				<!-- federation -->
				<div class="col-md-3 col-xs-12 widget widget_tally_box">
					<xsl:variable name="percent"
						select="item[@name='progress']/field[@name='federation']/@value" />
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
										select="number(item[@name='rank']/field[@name='federation']/@value)" />
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
		<div><h3><xsl:value-of select="field[@name='pilotName']/@value"/></h3></div>
		<div>
			<xsl:for-each select="childs/item">
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
		<div class="clearfix"></div>

	</xsl:template>
	<xsl:template name="view_ships1">
	
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<div><h3><xsl:value-of select="field[@name='pilotName']/@value"/></h3></div>

		<div>
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Ship</th>
						<th>System/Station</th>
						<th>#</th>
						<th>Ship</th>
						<th>System/Station</th>
					</tr>
				</thead>
				<tbody>
					<xsl:for-each select="childs/item">
						<!--
						<xsl:sort case-order="upper-first" data-type="text" order="ascending" select="field[@name='ship']/field[@name='name']/@value"/>
						-->
						<xsl:variable name="class">
							<xsl:if test="field[@name='isMain']/@value = 1">1</xsl:if>
						</xsl:variable>
						<xsl:if test="position() mod 2 = 1"><xsl:text disable-output-escaping="yes">&lt;tr&gt;</xsl:text></xsl:if>
							<td>
								<xsl:if test="$class = 1"><xsl:attribute name="class">success</xsl:attribute></xsl:if>
								<xsl:value-of select="field[@name='linkShipId']/@value"/>
							</td>
							<td>
								<xsl:if test="$class = 1"><xsl:attribute name="class">success</xsl:attribute></xsl:if>
								<a href="{$lang}/{../../field[@name='pilotName']/@value}/ships/{field[@name='linkShipId']/@value}/">
									<xsl:value-of select="field[@name='shipName']/@value"/>
								</a>
							</td>
							<td>
								<xsl:if test="$class = 1"><xsl:attribute name="class">success</xsl:attribute></xsl:if>
								<xsl:choose>
									<xsl:when test="string-length(field[@name='systemName']/@value) != 0">
										<xsl:value-of select="field[@name='systemName']/@value"/><br/>
										<xsl:value-of select="field[@name='stationName']/@value"/>
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="/item/item[@name='location']/field[@name='systemName']/@value"/><br/>
										<xsl:value-of select="/item/item[@name='location']/field[@name='stationName']/@value"/>
									</xsl:otherwise>
								</xsl:choose>
							</td>
						<xsl:if test="position() mod 2 = 0"><xsl:text disable-output-escaping="yes">&lt;/tr&gt;</xsl:text></xsl:if>
					</xsl:for-each>
					<xsl:if test="count(childs/item) mod 2 = 1"><td colspan="3"></td><xsl:text disable-output-escaping="yes">&lt;/tr&gt;</xsl:text></xsl:if>
				</tbody>
				
			</table>

		
		</div>
	
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="view_ship">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<table class="table">
			<thead>
				<tr>
					<th class="col-md-3">Weapon</th>
					<th class="col-md-3">Utility</th>
					<th class="col-md-3">Essential</th>
					<th class="col-md-3">Internal</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<xsl:for-each select="item[@name='currentShip']/modules/item[field[@name='slotTypeId']/@value='50']">
							<xsl:sort case-order="upper-first" data-type="text" order="ascending" select="field[@name='slotUniq']/@value"/>
							<div><xsl:call-template name="module_name"/></div>
						</xsl:for-each>
					</td>
					<td>
						<xsl:for-each select="item[@name='currentShip']/modules/item[field[@name='slotTypeId']/@value='10']">
							<xsl:sort case-order="upper-first" data-type="text" order="ascending" select="field[@name='slotUniq']/@value"/>
							<div><xsl:call-template name="module_name"/></div>
						</xsl:for-each>
					</td>
					<td>
						<xsl:for-each select="item[@name='currentShip']/modules/item[field[@name='slotTypeId' and (@value='30' or @value='40')]]">
							<xsl:sort case-order="upper-first" data-type="text" order="ascending" select="field[@name='slotUniq']/@value"/>
							<div><xsl:call-template name="module_name"/></div>
						</xsl:for-each>
					</td>
					<td>
						<xsl:for-each select="item[@name='currentShip']/modules/item[field[@name='slotTypeId']/@value='20']">
							<xsl:sort case-order="upper-first" data-type="text" order="ascending" select="field[@name='slotUniq']/@value"/>
							<div><xsl:call-template name="module_name"/></div>
						</xsl:for-each>
					</td>
				</tr>
			</tbody>
		</table>
	</xsl:template>
<!--
//
//
//
-->
	<xsl:template name="module_name">
		<xsl:choose>
			<xsl:when test="string-length(field[@name='moduleName']/@value) = 0">
				<xsl:value-of select="field[@name='moduleGroupName']/@value"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="field[@name='moduleName']/@value"/>
			</xsl:otherwise>
		</xsl:choose>		
		<xsl:text> - </xsl:text><xsl:value-of select="field[@name='moduleRating']/@value"/><xsl:value-of select="field[@name='moduleClass']/@value"/>
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
		<div><h3><xsl:value-of select="field[@name='pilotName']/@value"/></h3></div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th rowspan="2">Complete Time</th>
						<th rowspan="2">Mission type</th>
						<th colspan="2">Location</th>
						<th colspan="3">Reward</th>
					</tr>
					<tr>
						<th colspan="2">Fraction</th>
						<th>Credits</th>
						<th>Commodities</th>
						<th>Materials</th>
					</tr>
				</thead>
				<tbody>
					<xsl:for-each select="childs/item">
						<tr>
							<td rowspan="2"><xsl:value-of select="field[@name='missionDate']/@value"/></td>
							<td rowspan="2"><xsl:value-of select="field[@name='missionTypeName']/@value"/></td>
							<td><xsl:value-of select="field[@name='systemName']/@value"/></td>
							<td><xsl:value-of select="field[@name='stationName']/@value"/></td>
							<td rowspan="2"><xsl:value-of select="format-number(field[@name='reward']/@value, '### ### ###', 'revards')"/></td>
							<td rowspan="2">
								<xsl:for-each select="field[@name='commodityId']/value">
									<xsl:variable name="id" select="@value"/>
									<xsl:value-of select="/item/additionOne/item[field[@name='commodityId']/@value = $id]/field[@name='commodityName']/@value"></xsl:value-of><br/>
								</xsl:for-each>
							</td>
							<td rowspan="2">
								<xsl:for-each select="field[@name='materialId']/value">
									<xsl:variable name="id" select="@value"/>
									<xsl:value-of select="i10n:tr(/item/additionTwo/item[field[@name='materialId']/@value = $id]/field[@name='materialUniq']/@value)"></xsl:value-of><br/>
								</xsl:for-each>
							</td>
						</tr>
						<tr>
							<td colspan="2"><xsl:value-of select="field[@name='factionName']/@value"/></td>
						</tr>
					</xsl:for-each>
				</tbody>
			</table>			
		<div>
		</div>
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
					<label><xsl:value-of select="i10n:tr('sort_by')"/>:&#160;&#160;&#160;</label>
					<div class="radio">
						<label>
							<input type="radio" class="flat" value="alphabetical" name="material_sorting">
								<xsl:if test="/*/@sort = 'alphabetical'"><xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
							</input>&#160;<xsl:value-of select="i10n:tr('sort_by_alphabetial')"/>&#160;&#160;
						</label>
					</div>
					<div class="radio">
						<label>
							<input type="radio" class="flat" value="updated" name="material_sorting">
								<xsl:if test="/*/@sort = 'updated'"><xsl:attribute name="checked">checked</xsl:attribute></xsl:if>
							</input>&#160;<xsl:value-of select="i10n:tr('sort_by_updated')"/>&#160;&#160;
						</label>
					</div>
					<div class="radio">
						<label>
							<input type="radio" class="flat" value="quantity" name="material_sorting">
								<xsl:if test="/*/@sort = 'quantity'"><xsl:attribute name="checked">checked</xsl:attribute></xsl:if> 
							</input>&#160;<xsl:value-of select="i10n:tr('sort_by_quantity')"/>&#160;&#160;
						</label>
					</div>
				</div>				
			</form>
          </div>
			<div class="title_right">
				<form class="form-inline col-md-6 col-sm-6 col-xs-12 pull-right">
					<div class="input-group">
						<select name="eng_caterory" id="eng-caterory" class="form-control" data-placeholder="Select faction..." style="width:250px;">
							<option value="">&lt;Select Category&gt;</option>
							<xsl:for-each select="eng_types/item">
								<option value="{field[@name='engTypeUniq']/@value}"><xsl:value-of select="field[@name='engTypeName']/@value"/></option>
							</xsl:for-each>
						</select>
					</div>
					<div class="input-group">
						<select name="eng_blueprint" id="eng-blueprint" class="form-control" data-placeholder="Select faction..." disabled="disabled"  style="width:300px;">
							<option value=''>&lt;Select Blueprint&gt;</option>
						</select>
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
								<tr id="{field[@name='materialUniq']/@value}" class="material-row">
									<td><xsl:value-of select="field[@name='localized']/@value"/></td>
									<td style="width:70px;">
										<button class="btn btn-success button-switch"><xsl:value-of select="field[@name='quantity']/@value"/></button>
										<!-- 
										<input class="hidden" name="{field[@name='materialUniq']/@value}" type="number" min="0" max="1000" step="1" value="{field[@name='quantity']/@value}"/>
										 -->
									</td>
								</tr>
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
								<tr id="{field[@name='materialUniq']/@value}" class="material-row">
									<td><xsl:value-of select="field[@name='localized']/@value"/></td>
									<td style="width:70px;">
										<button class="btn btn-success button-switch"><xsl:value-of select="field[@name='quantity']/@value"/></button>
										<!-- 
										<input class="hidden" name="{field[@name='materialUniq']/@value}" type="number" min="0" max="1000" step="1" value="{field[@name='quantity']/@value}"/>
										 -->
									</td>
								</tr>
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
								<tr id="{field[@name='materialUniq']/@value}" class="material-row">
									<td><xsl:value-of select="field[@name='localized']/@value"/></td>
									<td style="width:70px;">
										<button class="btn btn-success button-switch"><xsl:value-of select="field[@name='quantity']/@value"/></button>
										<!-- 
										<input class="hidden" name="{field[@name='materialUniq']/@value}" type="number" min="0" max="1000" step="1" value="{field[@name='quantity']/@value}"/>
										 -->
									</td>
								</tr>
							</xsl:for-each>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<script>
			$(function() {
			
				var pilot = '<xsl:value-of select="$pilot"/>';
			
				var counter = 0;
				
				var send_data = null; 
				
				/*
				var focusLost = function(imput) {
					if ($(imput).parents('tr').find('.button-switch').html() != $(imput).val()) {
						$(imput).addClass('hidden');
						$(imput).parents('tr').find('.button-switch').html($(imput).val()).removeClass('hidden btn-success btn-danger btn-info ').addClass('btn-default');
					} else {
						$(imput).addClass('hidden');
						$(imput).parents('tr').find('.button-switch').removeClass('hidden');
					}
				}

				var switchClick = function() {				
					$('.form-materials').find('.button-switch').on('click', function() {
						
						$('.form-materials').find('.button-switch.hidden').each(function() {
							focusLost($(this).parents('tr').find('input'));
						});
						
						$(this).parents('tr').find('.hidden').removeClass('hidden');
						$(this).parents('tr').find('button').addClass('hidden');
					});
				}
				
				switchClick();
				
				function updateInputEvents() {
					$('.form-materials').find('.widget_tally_box').each(function() {
						var mtype = $(this).data('material');
						$(this).find('input[type=number]').on('keyup change', function() {
							var val = $(this).val();
							
							if (val.length > 0) {
								if (!send_data) {
									send_data = {};
								} 
								if (!send_data[mtype]) {
									send_data[mtype] = {};
								}
								send_data[mtype][$(this).attr('name')] = val;
							}	
							counter = 0; 
						});
					});
				}

				updateInputEvents();

				var timeUpdate = function() {
					if (send_data) {
						if (counter > 3) {
							var data = {};
							for (i in send_data) {
								//console.log(i);
								$('.form-materials').find('.' + i).find('.fa-spin').removeClass('hidden');
								for (k in send_data[i]) {
									data[k] = send_data[i][k]; 	
								}
							}
							data['material_sorting'] = $("input[name=material_sorting]").val();
							counter = 0;
							send_data = null;
							updateFromServer(data, function(result) {
								$('.form-materials').find('.button-switch.hidden, .button-switch.btn-default').each(function() {
									$(this).html($(this).parents('tr').find('input').val());
									$(this).parents('tr').find('input').addClass('hidden');
									$(this).removeClass('hidden btn-success btn-default btn-info btn-primary').addClass('btn-danger');
								});
								$('.form-materials').find('.fa-spin').addClass('hidden');
								setTimeout(timeUpdate, 1000);
							});
						} else {
							counter++;
							setTimeout(timeUpdate, 1000);
							
						}
					} else {
						setTimeout(timeUpdate, 1000);
					}
				}
				timeUpdate();
				*/
				
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
							$('.form-materials').find('.button-switch').each(function() {
								$(this).removeClass('btn-danger btn-info').addClass('btn-success');
							});
							if (result.materials) {
								var materials = {};
								result.materials.forEach(function(m, i) {
									if (m.quantity != $('#' + m.materialUniq).find('.button-switch').html()) {
										$('#' + m.materialUniq).find('input').val(m.quantity);
										$('#' + m.materialUniq).find('.button-switch').removeClass('btn-success btn-info btn-primary btn-danger').addClass(m.updateTime &lt; 31?'btn-info':'btn-primary').html(m.quantity);
									} else if (m.updateTime &lt; 61) {
										$('#' + m.materialUniq).find('.button-switch').removeClass('btn-success btn-info btn-primary btn-danger').addClass(m.updateTime &lt; 31?'btn-info':'btn-primary').html(m.quantity);
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
					if (!materials) {
						$('tr.material-row').removeClass('hidden');
					} else {
						var matmap = {};
						materials.forEach(function(v) {
							matmap[v.materialUniq] = true;
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
									optgroup = $('&lt;optgroup class="dynamic-option" data-blueprint="' + v.engBlueprintUniq + '" label="' + v.engBlueprintName + '"&gt;&lt;/optgroup &gt;').appendTo('#eng-blueprint');
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
			});
		</script>

	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>