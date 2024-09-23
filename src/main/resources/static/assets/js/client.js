
$('document').ready(function() {
	
	$('.table .btn-warning').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
				$.get(href, function(client, status){
					$('#idEdit').val(client.id);
					$('#firstnameEdit').val(client.firstname);
					$('#lastnameEdit').val(client.lastname);
					$('#mobileEdit').val(client.mobile);
					$('#phoneEdit').val(client.phone);
					$('#emailEdit').val(client.email);
					$('#remarksEdit').val(client.remarks);
					
				});
					
		$('#editModal').modal("show");		
	});
	});