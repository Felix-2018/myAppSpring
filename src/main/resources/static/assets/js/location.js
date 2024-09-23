
$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
				$.get(href, function(location, status){
					$('#idEdit').val(location.id);
					$('#addressEdit').val(location.address);
					$('#cityEdit').val(location.city);
					$('#ddlCountryAdd').val(location.countryid);
					$('#ddlStateAdd').val(location.stateid);
					$('#detailsEdit').val(location.details);
					$('#descriptionEdit').val(location.description);
					
				});
					
		$('#editModal').modal("show");		
	});
	});