
$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
				$.get(href, function(contact, status){
					$('#idEdit').val(contact.id);
					$('#addressEdit').val(contact.address);
					$('#cityEdit').val(contact.city);
					$('#ddlCountryAdd').val(contact.countryid);
					$('#ddlStateAdd').val(contact.stateid);
					$('#detailsEdit').val(contact.details);
					$('#nameEdit').val(contact.name);
					$('#phoneEdit').val(contact.phone);
					$('#mobileEdit').val(contact.mobile);
					$('#emailEdit').val(contact.email);
					$('#websiteEdit').val(contact.website);
					
				});
					
		$('#editModal').modal("show");		
	});
	});