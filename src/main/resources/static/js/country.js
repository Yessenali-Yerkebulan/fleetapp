$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        $('#editModal').modal();
    });
});