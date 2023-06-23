$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function (country, status){
            $('#idEdit').val(country.id);
            $('#descriptionEdit').val(country.description);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#continentEdit').val(country.continent);
            $('#nationalityEdit').val(country.nationality);
        });
        $('#editModal').modal();
    });
});