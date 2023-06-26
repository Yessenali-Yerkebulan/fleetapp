$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (client, status){
            $('#txtIdEdit').val(client.id);
            $('#txtAddressEdit').val(client.address);
            $('#ddlCountryEdit').val(client.countryid);
            $('#txtDetailsEdit').val(client.details);
            $('#txtEmailEdit').val(client.email);
            $('#txtMobileEdit').val(client.mobile);
            $('#txtCityEdit').val(client.city);
            $('#txtNameEdit').val(client.name);
            $('#txtPhoneEdit').val(client.phone);
            $('#ddlStateEdit').val(client.stateid);
            $('#txtWebsiteEdit').val(client.website);
        });
        $('#editModal').modal();
    });

    $('table #detailsButton').on('click',function(event) {
        event.preventDefault();
        let href= $(this).attr('href');
        $.get(href, function(client, status){
            $('#txtIdDetails').val(client.id);
            $('#txtAddressDetails').val(client.address);
            $('#ddlCountryDetails').val(client.countryid);
            $('#txtDetailsDetails').val(client.details);
            $('#txtEmailDetails').val(client.email);
            $('#txtCityDetails').val(client.city);
            $('#txtMobileDetails').val(client.mobile);
            $('#txtNameDetails').val(client.name);
            $('#txtPhoneDetails').val(client.phone);
            $('#ddlStateDetails').val(client.stateid);
            $('#txtWebsiteDetails').val(client.website);
            $('#lastModifiedByDetails').val(client.lastModifiedBy);
            $('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", " "));
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