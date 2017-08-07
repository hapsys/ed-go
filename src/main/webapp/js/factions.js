$(function() {
	console.log('Load Factions');
	
	var proxy = new ProxyApi(false, false, site_root);

	var visCount = 0;
	var page = 1;
	var hideNotVisisble = function() {
		var border = $('div.right_col').width() + $('div.right_col').position().left;
		$('div.right_col tr').each(function() {
			var cont = true;
			if (!visCount) {
				$(this).find('.can-hided').each(function() {
					$(this).removeClass('hidden');
					var l = $(this).width() + $(this).position().left;
					visCount++;
					if (l > border) {
						$(this).addClass('hidden');
						cont = false;
						visCount--;
					} else {
						$(this).addClass('visible');
					}
					return cont;
				});
			} else {
				var idx = 0;
				$(this).find('.can-hided').each(function() {
					$(this).removeClass('hidden');
					$(this).addClass('visible');
					return ++idx < visCount ;
				});
			}
		});
	}
	
	var showPaging = function() {
		var cont = $('div.right_col ul.pagination-split');
		var flag = false;
		var page = 0;
		$(cont).children().remove();
		$('div.right_col tr').each(function() {
			var idx = 0;
			var start = '';
			var end = '';
			$(this).find('.can-hided nobr').each(function() {
				var ctx = $(this).html();
				if (!start) {
					start = ctx;
				}
				end = ctx;
				if (++idx >= visCount) {
					idx = 0;
					var elm = $('<li><a href="#" class="page" data-page="' + page + '">' + start + ' &mdash; ' + end + '</a></li>');
					elm.appendTo($(cont));
					if (!flag) {
						//elm.trigger('mouseover');
					}
					flag = true;
					start = '';
					end = '';
					page++;
				}
			});
			if (start) {
				var elm = $('<li><a href="#" class="page" data-page="' + page + '">' + start + ' &mdash; ' + end + '</a></li>');
				elm.appendTo($(cont));
			}
			return false;
		});
		
		$(cont).find('.page').on('click', function() {
			
			var curpage = $(this).data('page');
			var std = curpage * visCount;
			var etd = std + visCount;
			
			$('div.right_col .visible').addClass('hidden').removeClass('visible');
			
			$('div.right_col tr').each(function() {
				var idx = 0;
					$(this).find('.can-hided').each(function() {
						if (idx >= std) {
							$(this).removeClass('hidden').addClass('visible');
						}
						return ++idx < etd ;
					});
			});
			
			return false;
		});
		
	} 
	
	var formSubmit = function() {
		var data = {faction: '', factionname: ''};
		data.faction = $("#faction").val();
		$("#faction").find("option:selected").each(function() {
			data.factionname = $(this).html();
		});
		
		var query = Object.keys(data).map(function(key) {
			  return encodeURIComponent(key) + '=' + encodeURIComponent(data[key]);
		}).join('&');

		$('.popup').show();
		
		proxy.load('#factions', '/raw/utility/faction-info/', null, data, function(response) {
			window.location.hash = query;
			visCount = 0;
			page = 1;
			hideNotVisisble();
			showPaging();
			$('.popup').hide();
		});

		
	};
	
	$('#show-faction-info').on('click', function() {
		//console.log($("#faction").val());
		if ($("#faction").val()) {
			formSubmit();
		}
		return false;
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