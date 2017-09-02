prepareData = function(form) {
	var data = new FormData();
	$(form).find('input,textarea,select').each(function() {
		if ($(this).attr('type') == 'file') {
			if ($(this)[0].files[0]) {
				data.append($(this).attr('name'), $(this)[0].files[0], $(this).val());
			}
		} else if ($(this).attr('type') == 'checkbox' || $(this).attr('type') == 'radio') {
			if ($(this).prop('checked')) {
				data.append($(this).attr('name'), $(this).val());
			}
		} else {
			data.append($(this).attr('name'), $(this).val());
		}
	});
	return data;
} 

var proxy = new ProxyApi(false, false, site_root);

$(function() {
	
	console.log('Load Forms');
	
	$(".login-form,.register-form").each(function() {
		var form = this;
		$(form).find('.clear-errors').on('click', function() {
			Validator.clearErrors(form);
		});
	});
	
	$(".login-form").submit(function() {
		var form = this;
		var data = {
			email: $('#email').val(),
			password: $('#password').val(),
		};
		if ($('#store').prop('checked')) {
			data.store = 'on';
		}
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


	$(".restore-form").submit(function() {
		var form = this;
		var data = {
			email: $('#email').val(),
		};
		//console.log(data);
		$(form).find('input,button,select').prop('disabled', true);
		Validator.clearErrors(form);
		proxy.makeCall('post', '/ajax/profile/restore/', null, null, data, function(result) {
			if (result.error && result.status != 403) {
				Validator.showErrors(form, result.error);
				$(form).find('input,button,select').prop('disabled', false);
			} else {
				//window.location.href = site_root;
				$(form).find('.form-section').addClass('hidden');
				$(form).find('span').html(result.email);
				$(form).find('.result-section').removeClass('hidden');
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
	
	$(".logout-login").on('click', function() {
		proxy.makeCall('post', '/ajax/profile/logout/', null, null, null, function(result) {
			window.location.href = site_root + '/account/login/';
		});
		return false;
	});
	
	$(".account-form").each(function() {
		var form = this;
		
		$(form).find('.password-change').on('click', function() {
			$(form).find('.password-switch').toggleClass('hidden');
			return false;
		});

		$(form).find('.password-cancel').on('click', function() {
			$(form).find('.password-switch').toggleClass('hidden');
			$(form).find('.password-switch input').val('');
			return false;
		});

		$(form).find('.password-save').on('click', function() {
			$(form).find('input,button,select').prop('disabled', true);
			var data = prepareData(form);
			Validator.clearErrors(form);
			proxy.makeCall('post', '/ajax/profile/change-password/', null, null, data, function(result) {
				if (result.error && result.status != 403) {
					Validator.showErrors(form, result.error);
				} else {
					$(form).find('input,button,select').prop('disabled', false);
					$(form).find('.password-switch').toggleClass('hidden');
					$(form).find('.password-switch input').val('');
				}
			});
			return false;
		});
		
		
		return false;
	});

	$(".user-info").each(function() {
		var form = this;
		
		$(form).find('.update-access').on('click', function() {
			$(form).find('input,button,select').prop('disabled', true);
			var data = prepareData(form);
			Validator.clearErrors(form);
			proxy.makeCall('post', '/ajax/profile/update-access/', null, null, data, function(result) {
				if (result.error && result.status != 403) {
					Validator.showErrors(form, result.error);
				} else {
					$(form).find('input,button,select').prop('disabled', false);
				}
			});
			return false;
		});
		
		return false;
	});

	$(".pilot-access-info").each(function() {
		var form = this;
		
		$(form).find('.update-access').on('click', function() {
			$(form).find('input,button,select').prop('disabled', true);
			var data = prepareData(form);
			Validator.clearErrors(form);
			proxy.makeCall('post', '/ajax/pilots/' + pilot + '/update-access/', null, null, data, function(result) {
				if (result.error && result.status != 403) {
					Validator.showErrors(form, result.error);
				} else {
					$(form).find('input,button,select').prop('disabled', false);
				}
			});
			return false;
		});
		
		return false;
	});
	
	
	$(".client-program-form").each(function() {
			var form = this;

		new Clipboard('.clipboard-copy');
		
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
	
	$(".pilots-link-form").each(function() {
		var form = this;
		var data = {
			//link: '',
			//unlink: '',
			//hide: '',
		}
		$(".pilots-link-form").find(".update").on("click", function() {
			
			//console.log('click');
			
			$(form).find('.lnk-link').each(function() {
				if ($(this).prop('checked')) {
					data['link[' + $(this).val() + ']'] = 1;
				}
			});
			$(form).find('.lnk-unlink').each(function() {
				if (!$(this).prop('checked')) {
					data['unlink[' + $(this).val() + ']'] = 1;
				}
			});
			$(form).find('.lnk-hide').each(function() {
				data['hide[' + $(this).val() + ']'] = $(this).prop('checked')?1:0;
			});
			
			$(form).find('input,button,select').prop('disabled', true);
			//console.log(data);
			
			proxy.makeCall('post', '/raw/profile/pilot-contol-update/', null, null, data, function(result) {
				$(form).find('input,button,select').prop('disabled', false);
				if (!$.isPlainObject(result)) {
					$('#loaded-table').html(result);
					$(form).find('input.flat').iCheck({
						checkboxClass: 'icheckbox_flat-green',
					});
					$(form).find(".js-switch").each(function() {
						new Switchery(this);
					});
				}
				data = {};
				//console.log(result);
			});
		});
	});
});
