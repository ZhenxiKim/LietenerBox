
$(".answer-write input[type=submit]").click(addAnswer);

function addAnswer(e) {
  console.log("나여깄다");

  var queryString = $(".answer-write").serialize();
  console.log("query : " + queryString);

  var url = $(".answer-write").attr("action");
  console.log("url" + url);

  //서버에 데이터 전
  $.ajax({
    type: 'post',
    url: url,
    data: queryString,
    dataType: 'JSON',
    error: onError,
    success: onSuccess
  });
}
  function onError(){

  }

  function onSuccess(data,status){
    //입력값 비동기로 html 생성
    var answerTemplate = $("#answerTemplate").html();
    var template = answerTemplate.format(data.writer.userId,data.formattedCreateDate,data.contents,data.id,data.id);
    $(".qna-comment-slipp-articles").prepend(template);
    $("textarea[name=contents]").val("");

  }










String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};