/**
 * serializeObject 구현 form to JSON
 */
$.fn.serializeObject = function() {
	var result = {}
	var extend = function(i, element) {
		var node = result[element.name];
		if ("undefined" !== typeof node && node !== null) {
			if ($.isArray(node)) {
				node.push(element.value)
			} else {
				result[element.name] = [node, element.value]
			}
		} else {
			result[element.name] = element.value
		}
	}
	$.each(this.serializeArray(), extend)
	return result;
}