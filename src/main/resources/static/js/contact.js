$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (contact, status){
            $('#txtEmailEdit').val(contact.email);
            $('#txtFirstnameEdit').val(contact.firstname);
            $('#txtIdEdit').val(contact.id);
            $('#txtLastnameEdit').val(contact.lastname);
            $('#txtMobileEdit').val(contact.mobile);
            $('#txtPhoneEdit').val(contact.phone);
            $('#txtRemarksEdit').val(contact.remarks);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(contact, status){
            $('#txtEmailDetails').val(contact.email);
            $('#txtFirstnameDetails').val(contact.firstname);
            $('#txtIdDetails').val(contact.id);
            $('#txtLastnameDetails').val(contact.lastname);
            $('#txtMobileDetails').val(contact.mobile);
            $('#txtPhoneDetails').val(contact.phone);
            $('#txtRemarksDetails').val(contact.remarks);
            $('#lastModifiedByDetails').val(contact.lastModifiedBy);
            $('#lastModifiedDateDetails').val(contact.lastModifiedDate.substr(0,19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });

    $('table #deleteButton').on('click', function(event){
        event.preventDefault();
        let href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal();
    });
});