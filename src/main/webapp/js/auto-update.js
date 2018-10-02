$(function() {
	console.log('Load Auto Update');
	
	//var ws = new WebSocket('ws://' + window.location.hostname + ':15674/ws');
	var server = 'ws://websoket.ed-go.xyz/ws';
	if (window.location.protocol.toLowerCase() == 'https:') {
		server = 'wss://websoket.ed-go.xyz/ws';
	}
	var ws = new WebSocket(server);
	
	var client = Stomp.over(ws);
	client.heartbeat.outgoing = 10000;
	client.heartbeat.incoming = 10000;

	client.debug = false;
	
	
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
	
	$('.updated-by-stomp').each(function() {
		
		var callback = $(this).data('update-function');
		var tag = $(this).data('update-tag');
		var pilot = $(this).data('update-pilot');
		
		if (callback && tag && pilot) {
			
			client.connect('remoteuser', 'remoteuser', 
					function(arg1, arg2, arg3) {
						client.subscribe("/exchange/edgo.topic/" + tag + '-' + encodeURIComponent(pilot), function(d) {
							eval(callback + '();');
				        });
					},	
					function(arg1, arg2, arg3) {
						console.log('error');
						console.log(arg1);
						console.log(arg2);
						console.log(arg3);
					},
					'/'
				);			
			
		}
		
		return false;
	});
});