define(['jquery'],function($){

    var getData = function(url){

        return $.ajax({
            url:url,
            dataType:'json',
            type:'GET'
        })
    };

    var postData = function(url, bodyData){
        return $.ajax({
            url : url,
            contentType : "application/json",
            data : JSON.stringify(bodyData),
            type : 'POST'
        })
    };

    return {
        getData : getData,
        postData : postData
    }

});