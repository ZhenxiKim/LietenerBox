$(document).ready(function(){
    ajaxfunction();
});

function ajaxfunction(){

    $.ajax({
        method:"GET",
        contentType:"application/json",
        url:"localhost:8080/members/1",
        dataType:'JSON',
        success: function(data){
            alert(data)
        },
        error: function(data){
            alert("error")
        }
    });
}
