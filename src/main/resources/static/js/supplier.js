$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (supplier, status){
            $('#txtIdEdit').val(supplier.id);
            $('#txtAddressEdit').val(supplier.address);
            $('#ddlCountryEdit').val(supplier.countryid);
            $('#txtDetailsEdit').val(supplier.details);
            $('#txtEmailEdit').val(supplier.email);
            $('#txtMobileEdit').val(supplier.mobile);
            $('#txtCityEdit').val(supplier.city);
            $('#txtNameEdit').val(supplier.name);
            $('#txtPhoneEdit').val(supplier.phone);
            $('#ddlStateEdit').val(supplier.stateid);
            $('#txtWebsiteEdit').val(supplier.website);
        });
        $('#editModal').modal();
    });

    $('table #detailsButton').on('click',function(event) {
        event.preventDefault();
        let href= $(this).attr('href');
        $.get(href, function(supplier, status){
            $('#txtIdDetails').val(supplier.id);
            $('#txtAddressDetails').val(supplier.address);
            $('#ddlCountryDetails').val(supplier.countryid);
            $('#txtDetailsDetails').val(supplier.details);
            $('#txtEmailDetails').val(supplier.email);
            $('#txtCityDetails').val(supplier.city);
            $('#txtMobileDetails').val(supplier.mobile);
            $('#txtNameDetails').val(supplier.name);
            $('#txtPhoneDetails').val(supplier.phone);
            $('#ddlStateDetails').val(supplier.stateid);
            $('#txtWebsiteDetails').val(supplier.website);
            $('#lastModifiedByDetails').val(supplier.lastModifiedBy);
            $('#lastModifiedDateDetails').val(supplier.lastModifiedDate.substr(0,19).replace("T", " "));
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