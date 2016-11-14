ProxyApi = function(schema, host, root) {

	console.log('Load ProxyApi');

	var uri = '';
	
	if (schema) {
		uri = schema + '://' + host + root;
	} else if (root) {
		uri = root;
	}
	
	while (uri && uri.charAt(uri.length - 1) == '/') {
		uri = uri.substr(0, uri.length - 1);
	}

	
	this.makeCall = function(method, url, path, query, data, callback) {
		
		
		if (url.charAt(0) != '/') {
			url = '/' + url;
		}
		if (path) {
			url = url.replace(/{([^}]+)}/ig, function($0, $1 ,$2) {
				return path[$1];
			});
		}

		var queryString = '';
		if (!$.isEmptyObject(query)) {
			queryString = Object.keys(query).map(function(key) {
				  return encodeURIComponent(key) + '=' + encodeURIComponent(query[key]);
			}).join('&');
		}

		if (queryString) {
			if (url.indexOf('?') > -1) {
				queryString = '&' + queryString;
			} else {
				queryString = '?' + queryString;
			}
		}

		//console.log(uri + url + queryString);

		var options = {
			method: method,
			dataType: 'json',
			url : uri + url + queryString,
			success: function(result) {
				callback(result);
			},
			error: function(result) {
				callback(result);
			}
		};

		if (!(data instanceof FormData)) {
			if (!$.isEmptyObject(data)) {
				if (method.toLowerCase() == 'get') {
					options.data = data;
				} else if (method.toLowerCase() == 'post') {
					options.data = Object.keys(data).map(function(key) {
						  return encodeURIComponent(key) + '=' + encodeURIComponent(data[key]);
					}).join('&');
				} else {
					options.data = $.toJSON(data);
				}
			}
		} else {
			options.data = data;
			options.processData = false;
			options.contentType = false;
		}

		$.ajax(options);
	};
	
	
	this.load = function(element, url, path, query, callback) {
		
		if (url.charAt(0) != '/') {
			url = '/' + url;
		}
		if (path) {
			url = url.replace(/{([^}]+)}/ig, function($0, $1 ,$2) {
				return path[$1];
			});
		}

		var queryString = '';
		if (!$.isEmptyObject(query)) {
			queryString = Object.keys(query).map(function(key) {
				  return encodeURIComponent(key) + '=' + encodeURIComponent(query[key]);
			}).join('&');
		}

		if (queryString) {
			if (url.indexOf('?') > -1) {
				queryString = '&' + queryString;
			} else {
				queryString = '?' + queryString;
			}
		}
		
		$(element).load(url, function(responseText, textStatus, XMLHttpRequest) {
			callback(responseText, textStatus, XMLHttpRequest);
		});
		
	}
};