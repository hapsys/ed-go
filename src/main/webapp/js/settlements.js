$(function() {
	

	console.log('Load Settlerments');
	
	var proxy = new ProxyApi(false, false, site_root);
	
	$('.search-settlements').each(function() {
		var form = this;
		var storage = new Store("__visited_settlements");
		var visited = storage.get();
		if (!visited) {
			visited = {};
		} else {
			var now = (new Date()).getTime();
			// remove old
			$.each(visited, function(key, val) {
				if (val.expire && val.expire < now) {
					delete visited[key]; 
				}
			});
			storage.set(visited);
		}
		//console.log(">>>", visited);
		
		var formSubmit = function() {
			var data = {system: '', stype: ''};
			$(form).find('input[type=checkbox], select').each(function() {
				if ($(this).attr('type') == 'checkbox') {
					data[$(this).attr('name')] += $(this).prop('checked')?';'+ $(this).val():'';  
				} else {
					data[$(this).attr('name')] = $(this).val();
				}
			});
			
			$(form).find("#system").find("option:selected").each(function() {
				data.sysname = $(this).html();
			});
			
			var query = Object.keys(data).map(function(key) {
				  return encodeURIComponent(key) + '=' + encodeURIComponent(data[key]);
			}).join('&');
 
			/*
			 * Post visited
			 */
			var post = {};
			if (!$.isEmptyObject(visited)) {
				post.visited = '';
				$.each(visited, function(k) {
					post.visited += ';' + k;  
				});
			}
			
			//console.log(post);
			
			$(form).find('input, selects, button.fixed').prop('disabled', true);
			proxy.makeCall('post', 'ajax/utility/settlements-search/?' + query, null, null, post, function(result) {
				//console.log(result);
				var table = $('.table-systems');
				$(table).find('.dynamic').remove();
				var i=1;
				$.each(result.settlerments, function(id, s) {
					var tr = $('<tr class="dynamic" data-system="'+s.settlementId+'"><td>'+(id+1)+'</td><td>'+s.name+'</td><td>'+s.title+'</td><td><a href="https://eddb.io/system/'+s.systemId+'" target="_tab">'+s.systemName+'</a></td><td>'+s.planet+'</td><td>'+Math.ceil(s.dest * 100) / 100 +'</td><td>'+Math.ceil(s.solDest * 100) / 100+'</td><td class="text-center"><button type="button" class="btn btn-danger btn-xs">mark as visited</button></td></tr>');
					tr.appendTo(table);
					$(tr).find("button").on("click", function() {
						
						if ($(this).hasClass('btn-danger')) {
							$(this).removeClass('btn-danger');
							$(this).addClass('btn-success');
							$(this).html('remove from visited');
							
							/*
							 * set date 2 week
							 */
							var now = new Date();
							s.expire = now.getTime() + 1000 * 14 * 24 * 3600; // 2 weeks 
							visited[s.settlementId] = s; 
							storage.set(visited);
							$(form).find('.show-visited, .clear-visited').prop("disabled", false);
							tr.addClass('bg-danger');
						} else {
							$(this).removeClass('btn-success');
							$(this).addClass('btn-danger');
							$(this).html('mark as visited');
							delete visited[s.settlementId]; 
							storage.set(visited);
							tr.removeClass('bg-danger');
							if ($.isEmptyObject(visited)) {
								$(form).find('.show-visited, .clear-visited').prop("disabled", true);
							}
						}
						console.log(">>>", visited);
					});
				});
				$(form).find('input, select, button.fixed').prop('disabled', false);
				
				window.location.hash = query;
			});
			
		}
		
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
			
			var flag = !!values.stype || !!values.system && !!values.sysname;
			if (values.stype) {
				values.stype.split(';').map(function(id) {
					if (id) {
						$(form).find("#" + id).prop("checked", true);
					}
				});
			}
			
			if (values.system && values.sysname) {
				values.sysname = values.sysname.replace(/>/g, "&gt;").replace(/</g, "&lt;");
				$(form).find("#system").find("option").remove();
				$('<option value="' + values.system + '">' + values.sysname + '</option>').appendTo('#system');
			}
			
			if (flag) {
				formSubmit();
			}
		}

		
		$(this).submit(function() {
			//console.log(visited);
			//return;
			formSubmit();
			return false;
		});

		
		/*
		 * Visited 
		 */
		
		$(form).find('.show-visited').each(function() {
			if ($.isEmptyObject(visited)) {
				$(this).prop("disabled", true);
			}
		});
		
		$(form).find('.clear-visited').each(function() {
			//console.log($.isEmptyObject(visited));
			if ($.isEmptyObject(visited)) {
				$(this).prop("disabled", true);
			}
			$(this).on("click", function() {
				visited = {};
				storage.clear();
				$(form).find('.show-visited, .clear-visited').prop("disabled", true);
				if (window.location.hash) {
					formSubmit();
					return false;
				}
			});
		});
		/*
		 * 
		 */
		
		$(form).find("#system").ajaxChosen({
			jsonTermKey: 'system',
			minTermLength: 1,
			afterTypeDelay: 500,
		    type: 'GET',
		    url: site_root + '/ajax/utility/system-search/',
		    dataType: 'json'
		}, function (data) {
			var results = [];
			$.each(data.systems, function (i, val) {
				results.push({ value: val.systemId, text: val.name });
			});
			return results;
		});
		
		/**
		 * Modal
		 */
		$("#modalVisited").on("show.bs.modal", function() {
			
			var table = $("#modalVisited").find(".table-visited");
			$(table).find(".modal-dynamic").remove();
			
			var vsorted = [];
			var now = (new Date()).getTime();

			$.each(visited, function(key, val) {
				val.expire_str = '';
				
				if (val.expire) {
					var t = Math.ceil(val.expire - now);
					var h = Math.ceil(t / 3600);
					var m = Math.ceil((t%3600)/60); 
					var s = Math.ceil((t%3600)%60);
					val.expire_str = h + ':' + m + ':' + s;
				}
				vsorted.push(val);
			});

			vsorted = vsorted.sort(function (o1, o2) {
				var res = -1;
				if (o1.name > o1.name) {
					res = 1;
				}
				return res;
			});
			
			$.each(vsorted, function(id, s) {
				var tr = $('<tr class="modal-dynamic " data-system="'+s.settlementId+'"><td>'+(id+1)+'</td><td>'+s.name+'</td><td>'+s.title+'</td><td><a href="https://eddb.io/system/'+s.systemId+'" target="_tab">'+s.systemName+'</a></td><td>'+s.planet+'</td><td>'+s.solDest+'</td><td>'+s.expire_str+'</td><td class="text-center"><button type="button" class="btn btn-xs"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></td></tr>');
				tr.appendTo(table);
			});
			
		}); 
		
	});
	
});
