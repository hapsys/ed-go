$(function() {
	console.log('Load Auto Update');
	$('.updated-by-time').each(function() {
		var callback = $(this).data('update-function');
		if (callback) {
			var interval = $(this).data('update-interval');
			if (!interval) {
				interval = 30000;
			}
			eval('setInterval('+ callback + ', '+ interval +');');
		}
	});
});