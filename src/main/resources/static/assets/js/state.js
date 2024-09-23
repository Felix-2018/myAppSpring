
$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
				$.get(href, function(state, status){
					$('#idEdit').val(state.id);
					$('#countryidEdit').val(state.countryid);
					$('#codeEdit').val(state.code);
					$('#capitalEdit').val(state.capital);
					$('#detailsEdit').val(state.details);
					$('#nameEdit').val(state.name);
					
				});
					
		$('#editModal').modal("show");		
	});
	});