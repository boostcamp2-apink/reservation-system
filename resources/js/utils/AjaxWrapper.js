define(['jquery'],function($){

    var getData = function(url){

        return $.ajax({
            url:url,
            dataType:'json',
            type:'GET'
        })
    };

    var postData = function(url,data){

        return $.ajax({
            url:url,
            contentType:"application/json; charset=UTF-8",
            dataType:'json',
            data: JSON.stringify(data),
            type:'POST'
        })

    };

    var postFormFileData = function(url,data){


        return $.ajax({
            url:url,
            processData: false,
            contentType: false,
            data: data,
            type:'POST'
        })

    };

    return {

        getData:getData,
        postData : postData,
        postFormFileData : postFormFileData


    }

});