$(document).ready(function(){
    $.getJSON("/api/v1/bestgame", function(result){
        var html = "";
        $.each(result, function(i, field){
            //$("div").append(field + " ");
            // console.log(field.menu);
            // console.log(field.price); // console.log(field["price"]); 사용가능
            // console.log(field.img);
            html += "<h3>게임 이름 : " + field.name + "</h3>";
            html += "<h5>게임 장르 : " + field.jang + "</h5>";
            html += "<h5>홈페이지 : " + "<a href='" + field.page + "'>홈페이지로 가기</a></h5>";
            html += "<img src = '" + field.img + "'>";


        });
        $("#bestgame").html(html);
    });
});

