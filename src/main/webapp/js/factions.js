$(function() {
	console.log('Load Factions');
	
	var proxy = new ProxyApi(false, false, site_root);

	$("#faction").ajaxChosen({
		jsonTermKey: 'faction',
		minTermLength: 1,
		afterTypeDelay: 500,
	    type: 'GET',
	    url: site_root + '/ajax/utility/faction-search/',
	    dataType: 'json'
	}, function (data) {
		var results = [];
		$.each(data.factions, function (i, val) {
			results.push({ value: val.factionId, text: val.name });
		});
		return results;
	});
	
	
	$('#show-faction-info').on('click', function() {
		//console.log($("#faction").val());
		if ($("#faction").val()) {
			proxy.load('#factions', '/raw/utility/faction-info/', null, {faction: $("#faction").val()}, function(response) {
				
			});
		}
	});
});