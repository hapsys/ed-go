/**
 * 
 */
var validateEmail = function(element) {
	var emailTest = /^[\.A-z0-9_\-\+]+[@][A-z0-9_\-]+([.][A-z0-9_\-]+)+[A-z]{1,4}$/;
	return emailTest.test($(element).val());
};

var validatePhone = function(element) {
	var phoneTest = /^\+?[\d\s]+\(?[\d\s]{10,20}$/;
	return phoneTest.test($(element).val());
};


var validateUrl = function(element) {
	var urlTest = /^http(s?)\:\/\/[0-9a-zA-Z]([-.\w]*[0-9a-zA-Z])*(:(0-9)*)*(\/?)([a-zA-Z0-9\-\.\?\,\'\/\\\+&amp;%\$#_]*)?$/;
	var urlTest1 = /^[0-9a-zA-Z]([-.\w]*[0-9a-zA-Z])*(:(0-9)*)*(\/?)([a-zA-Z0-9\-\.\?\,\'\/\\\+&amp;%\$#_]*)?$/;
	return urlTest.test($(element).val()) || urlTest1.test($(element).val());
};

var getValues = function(form) {
	var result = {};
	$(form).find('input, select, textarea').each(function() {
		if ($(this).attr('name')) {
			result[$(this).attr('name')] = $(this).val();
		}
	});
	return result;
};

var validateForm = function(form) {
	var result = false;
	var error = function(element, errorId) {
		if (!result) {
			result = {};
		}
		var id = $(element).attr('id');
		if (!result[id]) {
			result[id] = [];
		}
		result[id].push(errorId);
	};
	//$('.required', $(form)).each(function() {
	$(form).find('input, select, textarea').each(function() {

		try {
			$(this).val($.trim($(this).val()));
		} catch (e) {}

		if ($(this).hasClass('required')) {
			if (!$(this).val()) {
				error(this, 'required');
			}
		}

		if ($(this).hasClass('email')) {
			if ($(this).val() && !validateEmail(this)) {
				error(this, 'email');
			}
		}

		if ($(this).hasClass('phone')) {
			if ($(this).val() && !validatePhone(this)) {
				error(this, 'phone');
			}
		}

		if ($(this).hasClass('url')) {
			if ($(this).val() && !validateUrl(this)) {
				error(this, 'url');
			}
		}

		if ($(this).hasClass('regexp')) {
			var data = $(this).data('regexp');
			if (data) {
				var reg = new RegExp(data, 'gi');
				console.log(reg.toString());
				if ($(this).val() && !reg.test($(this).val())) {
					error(this, 'regexp');
				}
			}
		}

	});
	return result;
};

var clearErrors = function(form) {
	$(form).find('.has-error').removeClass('has-error');
	//$(form).find('.control-label').remove();
	$(form).find('.form-error').remove();
};

var elementError = function(element, text) {
	/*
	var parents = $(element).parents('*:first');
	if (parents.length && parents[0].tagName == 'TD') {
		$(element).parents('td:first').addClass('has-error');
	} else {
		$(element).parents('div:first').addClass('has-error');
	}
	$(element).after('<label class="control-label show-error" for="inputError">' + text + '</label>');
	$(element).after('<span class="alert-error">' + text + '</span>');
	*/
	$('<span class="form-error">' + text + '</span>').insertAfter(element);
};

var showErrors = function(form, errors) {
	if (errors) {
		for(var id in errors) {
			//var notifyText = "Unknown Error";
			//var position = 'right';
			var element = $(form).find("#"+id);
			if (!element.length) {
				element = $(form).find("*[name=" + id + "]");
			}
			var notifyText = element.data('error-'+errors[id][0]);
			var position = element.data('error-position');
			position = position?position:'bottom';

			if (!notifyText) {
				switch (errors[id][0]) {
					case 'required':
						notifyText = "The field must have a value";
						break;
					case 'passwords':
						notifyText = "Passwords must match";
						break;
					case 'email':
						notifyText = "E-mail has wrong format";
						break;
					case 'url':
						notifyText = "URL has wrong format";
						break;
					case 'phone':
						notifyText = "Phone has wrong format";
						break;
					case 'captcha':
						notifyText = "Captcha not verifyed";
						position = 'bottom';
						break;
					default:
						notifyText = errors[id][0];
						break;
				}
			}
			//element.notify(notifyText, {position: position});
			elementError(element, notifyText);
		}
	}
};

Validator = new (function() {
	
	console.log('Load validator');
	
	this.validateForm = validateForm;
	this.showErrors = showErrors;
	this.elementError = elementError;
	this.clearErrors = clearErrors;
});
