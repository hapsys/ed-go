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
	<xsl:param name="pilotEncoded"/>
	<xsl:param name="pilotReal"/>
	<xsl:param name="type"/>
	<xsl:template match="/data">
		<xsl:variable name="lang"><xsl:value-of select="$root"/><xsl:if test="$politic = 'suffix' and $default != 'true'">/<xsl:value-of select="$suffix"/></xsl:if></xsl:variable>
		<div class="clearfix"></div>
		<!-- Ships -->
		<div class="x_panel">
			<div class="x_title">
				<div class="pull-left" >
					<select name="ship" class="selectpicker" data-live-search="true" title="Select ship...">
						<xsl:for-each select="item">
							<option value="{field[@name='shipUniq']/@value}"><xsl:value-of select="field[@name='shipName']/@value"/></option>
						</xsl:for-each>
					</select>
				</div>
				<div class="clearfix"></div>
			</div>
			
			<div class="x_content">
				<div style="width: 1200px;">
			    	<table id="slots-table" class="table table-bordered" data-toggle="table" data-group-by="true" data-group-by-field="slotTypeName" data-sort-name="[slotUniq]">
			    		<thead>
			    			<th data-field="slotTypeName" style="width: 200px;">Type</th>
			    			<th data-field="slotUniq" style="width: 200px;">Slot</th>
			    			<th data-field="size" style="width: 50px;">Size</th>
			    			<th data-field="linkSize" style="width: 50px;" data-editable="true" 
			    				data-editable-type="select" data-editable-source="{{'0':'0', '1':'1','2': '2','3': '3','4': '4','5': '5','6':'6','7':'7','8':'8',}}">Size+</th>
			    			<th data-field="usedCount">Count</th>
			    			<th data-width="75" data-formatter="drawActions">actions</th>
			    		</thead>
			    	</table>
			    </div>
			</div>
		</div>
		<div class="clearfix"></div>
		<script>

			var drawActions = function(value, row, index) {
				//console.log(row);
				var html = '<a class="delete-slot" href="#" data-slotid = "' + row['slotId'] + '" data-slotname = "' + row['slotUniq'] + '"><i class="fa fa-remove" aria-hidden="true"></i></a>';
				return html; 
			}

			$(function() {
			
				//$("#slots-table").bootstrapTable({});
				
				$("#slots-table").on('editable-save.bs.table', function(e, a, row) {
					var slotdata = {ship_uniq: $('select[name=ship]').val(), slot_id: row['slotId'], size: row['linkSize']};
					proxy.makeCall('post', '/ajax/administration/slot-update/', null, null, slotdata, function(result) {
						showSlots();
					});
				});
				
				var showSlots = function() {
					var data = {ship_uniq: $('select[name=ship]').val() };
					proxy.makeCall('post', '/ajax/administration/slots-list/', null, null, data, function(result) {
						//console.log(result.slots);
						$("#slots-table").bootstrapTable('load', { data: result.slots });
						
						$('.delete-slot').on('click', function() {
						
							var ship = $('select[name=ship] option:selected').html();
							var slot = $(this).data('slotname');
							var link = this;
							//console.log(ship);
							//console.log(slot);
							eModal.confirm('Do you want to delete "'+slot+'" from ship "'+ship+'"?', 'Delete slot').then(function() {
								var slotdata = {ship_uniq: $('select[name=ship]').val(), slot_id: $(link).data('slotid')};
								proxy.makeCall('post', '/ajax/administration/slot-delete/', null, null, slotdata, function(result) {
									showSlots();
								});
							});
							
							return false;
						});
					});
					
				}
				
				$('select[name=ship]').on('change', function() {
					window.location.hash = $('select[name=ship]').val();
					showSlots();
				});
				
				if (window.location.hash) {
					var shiUniq = window.location.hash.substring(1);
					$('select[name=ship]').val(shiUniq);
					//console.log(shiUniq);
				}
				showSlots();
				
			});
		</script>
	</xsl:template>
<!--
//
//
//
-->
</xsl:stylesheet>