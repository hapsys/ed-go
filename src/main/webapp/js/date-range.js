DateRange = function(locale) {

	console.log('Load Date Range');
	
	locale = locale?locale:'en';
	
	var start_date = moment();
	var end_date = moment();
	var update_date = end_date;
	
	this.setStartDate = function(_start_date) {
		start_date = _start_date;
	};
	

	this.getStartDate = function() {
		return start_date;
	};
	
	this.setEndDate = function(_end_date) {
		end_date = _end_date;
	};
	
	this.getEndDate = function() {
		return end_date;
	};
	
	var setStartDateLabel = function() {
		$("#select-date-start").find("span").html(start_date.format('DD MMMM YYYY'));
	}
	 
	var setEndDateLabel = function() {
		$("#select-date-end").find("span").html(end_date.format('DD MMMM YYYY'));
	} 
	
	this.setLabels = function() {
		setStartDateLabel();
		setEndDateLabel();
	}

	this.setRange = function(from, to) {
		this.setStartDate(from);
		this.setEndDate(to);
		this.setLabels();
	}

	this.setMinMax = function(from, to) {
		$("#select-date-end").data("DateTimePicker").maxDate('2099-12-31');
		$("#select-date-end").data("DateTimePicker").minDate('1970-01-01');
		$("#select-date-start").data("DateTimePicker").maxDate('2099-12-31');
		$("#select-date-start").data("DateTimePicker").minDate('1970-01-01');
		//$("#select-date-end").data("DateTimePicker").maxDate(to.format('YYYY-MM-DD') + ' 23:59:59');
		//$("#select-date-start").data("DateTimePicker").minDate(from.format('YYYY-MM-DD') + ' 00:00:00');
		if (from && to) {
			$("#select-date-end").data("DateTimePicker").maxDate(to);
			$("#select-date-end").data("DateTimePicker").minDate(from);
			$("#select-date-start").data("DateTimePicker").maxDate(to);
			$("#select-date-start").data("DateTimePicker").minDate(from);
		}
		
	}
	
	$("#select-date-start").datetimepicker({
		format: "YYYY-MM-DD",
    	viewMode: 'days',
    	
    	viewDate: start_date,
		maxDate: end_date,
		//minDate: "<xsl:value-of select="/*/@mindate"/>",
	}).on('dp.change', function(e) {
		start_date = moment(e.date);
		$("#select-date-end").data("DateTimePicker").minDate(start_date);
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
		//maxDate: "<xsl:value-of select="/*/@maxdate"/>",
		minDate: start_date,
	}).on('dp.change', function(e) {
		end_date = moment(e.date);
		$("#select-date-start").data("DateTimePicker").maxDate(end_date);
		setEndDateLabel();
		//updateLocations();
	});
	
	$("#select-date-end").on('click', function() {
		//$("#select-date-end").data("DateTimePicker").viewMode('days');
		$("#select-date-end").data("DateTimePicker").toggle();
	});
	
	
	
}