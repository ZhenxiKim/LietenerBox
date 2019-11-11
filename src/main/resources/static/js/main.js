// $(document).ready(function(){
//     ajaxfunction();
// });
//
// function ajaxfunction(){
//
//     $.ajax({
//         method:"GET",
//         contentType:"application/json",
//         url:"localhost:8080/members/1",
//         dataType:'JSON',
//         success: function(data){
//             alert(data)
//         },
//         error: function(data){
//             alert("error")
//         }
//     });
// }
//
(async () => {
    const url ='http://localhost:8080/members/1';

    const response = await fetch(url);
    console.log(response);
    const result = await response.json();


    const element = document.getElementById('app');
    element.innerHTML = `
            ${result.members_id}

    `;
})();