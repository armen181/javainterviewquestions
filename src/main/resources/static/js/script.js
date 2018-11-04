var x = 0;
var y = 0;
var side = 0;
var sideTemp = 0;
var sessionId = "";
var gameId = "";




$(document).ready(function () {


    $("#random").click(function () {
        var settings = {
            "async": true,
            "crossDomain": true,
            "url": "getByRandom",
            "method": "GET",
            "headers": {
            }
        }
            $.ajax(settings).done(function (response) {
            if(response!=null) {
                console.log(response);
                $('#title').replaceWith('<h1><div id="title">' + response.title+ '</div></h1>');
                $('#answer').replaceWith('<h1><div id="answer">' + response.body+ '</div></h1>');
                $("#answer").hide();
            }

        });


    });
    $("#nx").click(function () {
        var i =Number($('#id').val());
        if(i+1>1020){
            i=1020
        }else {
            i++;
        }

        var settings = {
            "async": true,
            "crossDomain": true,
            "url": "getById",
            "method": "GET",
            "headers": {
                "id": i
            }
        }
        $.ajax(settings).done(function (response) {
            if(response!=null) {
                console.log(response);
                $('#title').replaceWith('<h1><div id="title">' + response.title+ '</div></h1>');
                $('#answer').replaceWith('<h1><div id="answer">' + response.body+ '</div></h1>');
                $("#answer").hide();
                $('#id').val(i);

            }

        });


    });

    $("#pr").click(function () {
        var i =Number($('#id').val());
        if(i-1<0){
            i=0
        }else {
            i--;
        }


        var settings = {
            "async": true,
            "crossDomain": true,
            "url": "getById",
            "method": "GET",
            "headers": {
                "id": i
            }
        }
        $.ajax(settings).done(function (response) {
            if(response!=null) {
                console.log(response);
                $('#title').replaceWith('<h1><div id="title">' + response.title+ '</div></h1>');
                $('#answer').replaceWith('<h1><div id="answer">' + response.body+ '</div></h1>');
                $("#answer").hide();
                $('#id').val(i);
            }

        });


    });

    $("#show").click(function () {
        $("#answer").show();


    });



});