$(function() {
	

	console.log('Load Search');
	
	var proxy = new ProxyApi(false, false, site_root);

	
	 
	
	$('.pilot-search').each(function() {
		
		var form = this;
		var container = $('.pilot-search-result');
		
		var parseAccessString = function(source) {
			var result = {};
			source.split('///').forEach(function(v) {
				var arr = v.split('|||');
				result[arr[0].toLowerCase()] = {
						level: parseInt(arr[2]),
						link: arr[1]
				};
			});
			return result;
		}
		
		var setPilotSearchContent = function() {
			var data = {
				search: $(form).find('input').val()
			};
			
			proxy.makeCall('post', '/ajax/search/pilots/', null, null, data, function(result) {
				//console.log(result);
				//$(container).find('.profile_details').remove();
				var relations = {};
				result.relations.forEach(function(v) {
					relations[v.name] = v.value; 
				});
				
				var sklt;
				$(container).find('.pilot-search-details').each(function() {
					if (!$(this).hasClass('skeleton')) {
						$(this).remove();
					} else {
						sklt = this;
					}
				});
				
				//console.log(result.pilots);
				if (result.pilots && result.pilots.length > 0) {
					result.pilots.forEach(function(v) {
						var access = parseAccessString(v.levels);
						
						//console.log(access);
						var elm = $(sklt).clone();
						$(elm).removeClass('skeleton hidden');
						$(elm).find('.search-pilot-name').html(v.pilotName);
						$(elm).find('.search-pilot-aka').html(v.linkedPilots? '<strong>aka: </strong>' + v.linkedPilots:'&nbsp;');
				
						var accss = result.user.level | ((v.sourceRelation && v.targetRelation && v.sourceRelation == 2 && v.sourceRelation == v.targetRelation)?relations['FRIEND']:0);
						
						for (key in access) {
							var level = access[key].level; 
							var link = site_root + '/' + v.pilotName + '/' + (access[key].link?access[key].link + '/':'');
							
							//console.log(link);
							
							var a = $(elm).find('.' + key);
							$(a).attr('href', link);
							if (result.user.userId != v.userId && !(accss & level)) {
								$(a).css('visibility','hidden');
							}
						}
						
						
						
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

