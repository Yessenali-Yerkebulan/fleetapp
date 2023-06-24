$('document').ready(function() {
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (country, status){
            $('#idEdit').val(country.id);
            $('#descriptionEdit').val(country.description);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#ddlCountryEdit').val(country.countryid);
            $('#detailsEdit').val(country.details);
        });
        $('#editModal').modal();
    });
    $('table #detailsButton').on('click',function(event) {
        event.preventDefault();
        let href= $(this).attr('href');
        $.get(href, function(state, status){
            $('#idDetails').val(state.id);
            $('#ddlCountryDetails').val(state.countryid);
            $('#codeDetails').val(state.code);
            $('#descriptionDetails').val(state.description);
            $('#capitalDetails').val(state.capital);
            $('#detailsDetails').val(state.details);
            $('#lastModifiedByDetails').val(state.lastModifiedBy);
            $('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });

    $('table #deleteButton').on('click',function(event) {
        event.preventDefault();
        let href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal();
    });
});