This is a fun closures in JavaScript thing.

This doesn't do what you'd like:

	var entries = ['a', 'b', 'c'];
	for (i in entries) {
		var entry = entries[i];
		$('#a'+entry).click(function() {
			alert('entry: '+entry);
		});
	}

No matter what you click on, it'll display 'c' - that was the last entry in the
function scope, so that's what has been stored as the scope.

You can get around this by adding another function, and calling it immediately -
this way, your scope is preserved:

	var entries = ['a', 'b', 'c'];
	for (i in entries) {
		var entry = entries[i];
		$('#a'+entry).click(function() {
			return function(entry) {
				alert('entry: '+entry);
			}(entry);
		});
	}
