$(function() {
	console.log('Load Factions');
	
	var proxy = new ProxyApi(false, false, site_root);

	var formSubmit = function() {
		var data = {faction: '', factionname: ''};
		data.faction = $("#faction").val();
		$("#faction").find("option:selected").each(function() {
			data.factionname = $(this).html();
		});
		
		var query = Object.keys(data).map(function(key) {
			  return encodeURIComponent(key) + '=' + encodeURIComponent(data[key]);
		}).join('&');

		proxy.load('#factions', '/raw/utility/faction-info/', null, data, function(response) {
			window.location.hash = query;
		});

		
	};
	
	$('#show-faction-info').on('click', function() {
		//console.log($("#faction").val());
		if ($("#faction").val()) {
			formSubmit();
		}
	});
	
	if (window.location.hash) {
		var hash = window.location.hash.substr(1);
		//console.log(hash);
		var values = {};
		var sp = hash.split('&').map(function(val) {
			var inf = val.split("=");
			var key = decodeURIComponent(inf[0]); 
			var value = decodeURIComponent(inf[1]);
			values[key] = value;
		});  
		//console.log(values);
		
		var flag = !!values.faction || !!values.factionname;
		
		if (values.faction && values.factionname) {
			values.factionname = values.factionname.replace(/>/g, "&gt;").replace(/</g, "&lt;");
			$("#faction").find("option").remove();
			$('<option value="' + values.faction + '">' + values.factionname + '</option>').appendTo('#faction');
		}
		
		if (flag) {
			formSubmit();
		}
	}
	
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
	
});