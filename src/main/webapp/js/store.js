Store = function(_key, isSession) {
	/**
	 * Prepare
	 */
	var storeKey = _key?_key:'default';

	/**
	 *
	 */
	if(!isSession && !window.localStorage){
		throw new Error("window.localStorage not support as this Browser");
	}
	if(isSession && !window.sessionStorage){
		throw new Error("window.localStorage not support as this Browser");
	}

	var _storage = (isSession)?window.sessionStorage:window.localStorage;

	this.get = function() {
		var data = _storage.getItem(storeKey);
		return data?$.parseJSON(data):null;
	};

	this.set = function(data) {
		_storage.setItem(storeKey, $.toJSON(data));
	};

	this.clear = function() {
		_storage.removeItem(storeKey);
	};

};