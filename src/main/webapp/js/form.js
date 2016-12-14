var proxy = new ProxyApi(false, false, site_root);

$(function() {
	
	console.log('Load Forms');
	
	$(".login-form").submit(function() {
		var form = this;
		var data = {
			email: $('#email').val(),
			password: $('#password').val(),
		};
		//console.log(data);
		$(form).find('input,button,select').prop('disabled', true);
		Validator.clearErrors(form);
		proxy.makeCall('post', '/ajax/profile/login/', null, null, data, function(result) {
			if (result.error && result.status != 403) {
				Validator.showErrors(form, result.error);
				$(form).find('input,button,select').prop('disabled', false);
			} else {
				window.location.href = site_root;
			}
		});
		return false;
	});
	
	$(".register-form").each(function() {
		var form = this;
		
		$(form).find('input[type=checkbox]').on('click', function() {
			$(form).find("#create-account").prop('disabled', !$(this).prop('checked'));
		});
		
		$(form).submit(function() {
			var data = {
					regemail: $('#regemail').val(),
					regpassword: $('#regpassword').val(),
					regconfirm: $('#regconfirm').val(),
			};
			//console.log(data);
			$(form).find('input,button,select').prop('disabled', true);
			Validator.clearErrors(form);
			proxy.makeCall('post', '/ajax/profile/registration/', null, null, data, function(result) {
				if (result.error && result.status != 403) {
					Validator.showErrors(form, result.error);
					$(form).find('input,button,select').prop('disabled', false);
				} else {
					$(form).find('input,button,select').prop('disabled', false);
					window.location.href = site_root + '/account/confirmation/' ;
				}
			});
			return false;
		});
	});
	
	$(".form-email-resend").submit(function() {
		var form = this;
		
		var data = {
				email: $('#email').val(),
		};
		//console.log(data);
		$(form).find('input,button,select').prop('disabled', true);
		Validator.clearErrors(form);
		proxy.makeCall('post', '/ajax/profile/resend-email/', null, null, data, function(result) {
			if (result.error && result.status != 403) {
				Validator.showErrors(form, result.error);
				$(form).find('input,button,select').prop('disabled', false);
			} else {
				$(form).find('input,button,select').prop('disabled', false);
				window.location.href = site_root + '/account/confirmation/' ;
			}
		});
		return false;
	});

	
	$(".logout").on('click', function() {
		proxy.makeCall('post', '/ajax/profile/logout/', null, null, null, function(result) {
			window.location.href = window.location.href;
		});
		return false;
	});
	
	$(".account-form").each(function() {
		var form = this;

		$(form).find(".key-generate").on("click", function() {
			Validator.clearErrors(form);
			$(form).find('input,button,select').prop('disabled', true);
			proxy.makeCall('post', '/ajax/profile/key-update/', null, null, null, function(result) {
				if (result.error && result.status != 403) {
					Validator.showErrors(form, result.error);
				} else {
					$("#accessKey").val(result.accessKey);
				}
				$(form).find('input,button,select').prop('disabled', false);
			});
			return false;
		});
		
		return false;
	});
});
