$(function() {
	console.log('Load Factions');
	
	var dRange = new DateRange();
	
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
		//var data = {faction: '', factionname: ''};
		var data = {
			from: dRange.getStartDate().format('YYYY-MM-DD'),
			to: dRange.getEndDate().format('YYYY-MM-DD'),
			faction: '', factionname: ''
		};
		
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
	
	//
	// Set dates
	//
	var dates = {};
	
	
	/*
	var start_date = moment();
	var end_date = moment();
	var update_date = end_date;

	
	
	//
	// Set dates
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
	}).on('dp.change', function(e) {
		start_date = moment(e.date);
		setStartDateLabel();
		//updateLocations();
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
		minDate: start_date,
	}).on('dp.change', function(e) {
		end_date = moment(e.date);
		setEndDateLabel();
		//updateLocations();
	});
	
	$("#select-date-end").on('click', function() {
		//$("#select-date-end").data("DateTimePicker").viewMode('days');
		$("#select-date-end").data("DateTimePicker").toggle();
	});
	*/
	
	
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
		
		var flag = !!values.faction || !!values.factionname ;
		
		if (values.faction && values.factionname) {
			console.log(values);
			values.factionname = values.factionname.replace(/>/g, "&gt;").replace(/</g, "&lt;");
			$("#faction").find("option").remove();
			$('<option value="' + values.faction + '">' + values.factionname + '</option>').appendTo('#faction');
		}
		
		if (values.from && values.to) {
			var start_date = moment(values.from);
			var end_date = moment(values.to);
			dRange.setMinMax();
			dRange.setRange(start_date, end_date);
			$('.date-range-form').css('visibility', 'visible');
			//dRange.setStartDateLabel();
			//dRange.setEndDateLabel();
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
		minDates = {};
		$.each(data.factions, function (i, val) {
			results.push({ value: val.factionId, text: val.name });
			dates['' + val.factionId] = {minDate: val.minDate, maxDate: val.maxDate};
		});
		return results;
	}).on('change', function() {
		$('.date-range-form').css('visibility', 'visible');
		//console.log($(this).val());
		var factionId = $(this).val();
		//start_date = moment.unix(dates[factionId].minDate);
		end_date = moment.unix(dates[factionId].maxDate);
		mD = moment.unix(dates[factionId].minDate);
		start_date = moment.unix(dates[factionId].maxDate);
		start_date.subtract(1, 'months');
		if (start_date.isBefore(mD)) {
			start_date = mD;
		}

		console.log(dates[factionId].maxDate);
		console.log(dates[factionId].minDate);
		//console.log(start_date);
		//console.log(mD);
		//console.log(end_date);
		
		dRange.setMinMax(moment.unix(dates[factionId].minDate), moment.unix(dates[factionId].maxDate));
		dRange.setRange(start_date, end_date);
		/*
		$("#select-date-end").data("DateTimePicker").maxDate(end_date);
		$("#select-date-end").data("DateTimePicker").minDate(start_date);
		$("#select-date-start").data("DateTimePicker").maxDate(end_date);
		$("#select-date-start").data("DateTimePicker").minDate(mD);
		
		setStartDateLabel();
		setEndDateLabel();
		*/
		
	});
	
});