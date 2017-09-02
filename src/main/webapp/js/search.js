$(function() {
	

	console.log('Load Search');
	
	var proxy = new ProxyApi(false, false, site_root);

	
	 
	
	$('.pilot-search').each(function() {
		
		var form = this;
		var container = $('.pilot-search-result');
		
		var setPilotSearchContent = function() {
			var data = {
				search: $(form).find('input').val()
			};
			
			proxy.makeCall('post', '/ajax/search/pilots/', null, null, data, function(result) {
				//console.log(result);
				//$(container).find('.profile_details').remove();
				var sklt;
				$(container).find('.profile_details').each(function() {
					if (!$(this).hasClass('skeleton')) {
						$(this).remove();
					} else {
						sklt = this;
					}
				});
				
				if (result.pilots && result.pilots.length > 0) {
					result.pilots.forEach(function(v) {
						//console.log(v);
						var elm = $(sklt).clone();
						$(elm).removeClass('skeleton hidden');
						$(elm).find('.search-pilot-name').html(v.pilotName);
						$(elm).find('.search-pilot-aka').html(v.linkedPilots? '<strong>aka: </strong>' + v.linkedPilots:'&nbsp;');
						elm.appendTo(container);
					});
				}
				
			});
		}
		
		setPilotSearchContent();
		
		$(form).find('input').on('keyup', function() {
			setPilotSearchContent();
		});
		
		return false;
	});
	
});

