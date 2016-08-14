$(document).ready(function() {
		$('#contactTable2').each(function() {
			$(this).find('td').each(function() {
				if ($(this).text().trim() == "") {
					$(this).closest("tr").remove();
				}
				;
			});
		});
		$('#contactTable').each(function() {
			$(this).find('td#forexselling').each(function() {
				if ($(this).text().trim() == "") {
					$(this).closest("tr").remove();
				}
				;
			});
		});
	});