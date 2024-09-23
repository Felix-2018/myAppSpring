
$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
				$.get(href, function(country, status){
					$('#idEdit').val(country.id);
					$('#descriptionEdit').val(country.description);
					$('#codeEdit').val(country.code);
					$('#capitalEdit').val(country.capital);
					$('#continentEdit').val(country.continent);
					$('#nationalityEdit').val(country.nationality);
					
				});
					
		$('#editModal').modal("show");		
	});
	});