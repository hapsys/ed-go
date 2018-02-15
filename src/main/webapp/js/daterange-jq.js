daterange_locale_en = {
		applyLabel: 'Submit',
		cancelLabel: 'Clear',
		fromLabel: 'From',
		toLabel: 'To',
		customRangeLabel: 'Custom',
		daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
		monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
		firstDay: 1
};

daterange_locale_ru = {
		applyLabel: 'Выбрать',
		cancelLabel: 'Отмена',
		fromLabel: 'От',
		toLabel: 'До',
		customRangeLabel: 'Диапазон',
		daysOfWeek: ['Вс', 'Пн', 'Вт', 'Ср', 'Чт', 'Пт', 'Сб'],
		monthNames: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
		firstDay: 1
};

(function ($) {

	$.fn.dateRange = function(type) {
		
		if ($.isPlainObject(type)) {
		
			var settings = $.extend({
			  startDate: moment().subtract(29, 'days'),
			  endDate: moment(),
			  minDate: moment().subtract(10, 'years'),
			  maxDate: moment(),
			  /*
			  dateLimit: {
				  years: 12
			  },
			  */
			  showDropdowns: true,
			  showWeekNumbers: true,
			  timePicker: false,
			  timePickerIncrement: 1,
			  timePicker12Hour: true,
			  ranges: {
				'Today': [moment(), moment()],
				'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
				'Last 7 Days': [moment().subtract(6, 'days'), moment()],
				'Last 30 Days': [moment().subtract(29, 'days'), moment()],
				'This Month': [moment().startOf('month'), moment().endOf('month')],
				'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
			  },
			  opens: 'right',
			  buttonClasses: ['btn btn-default'],
			  applyClass: 'btn-small btn-primary',
			  cancelClass: 'btn-small',
			  format: 'YYYY-MM-DD',
			  separator: ' to ',
			  locale: daterange_locale_en 
			}, type);
			
			return this.each(function() {
				
				var $this = $(this);
				
				var cb = function(start, end, label) {
					$($this).find('span').html(start.format(settings.format) + ' - ' + end.format(settings.format));
				};

				
				$($this).daterangepicker(settings, cb);
				
			});
		}
		
	}

})( jQuery );