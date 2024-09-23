
$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
				$.get(href, function(supplier, status){
					$('#idEdit').val(supplier.id);
					$('#addressEdit').val(supplier.address);
					$('#cityEdit').val(supplier.city);
					$('#ddlCountryAdd').val(supplier.countryid);
					$('#ddlStateAdd').val(supplier.stateid);
					$('#detailsEdit').val(supplier.details);
					$('#nameEdit').val(supplier.name);
					$('#phoneEdit').val(supplier.phone);
					$('#mobileEdit').val(supplier.mobile);
					$('#emailEdit').val(supplier.email);
					$('#websiteEdit').val(supplier.website);
					
				});
					
		$('#editModal').modal("show");		
	});
	});