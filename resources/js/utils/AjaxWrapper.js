define(['jquery'],function($){

    var getData = function(url){

        return $.ajax({
            url:url,
            dataType:'json',
            type:'GET'
        })

    };

    return {
        getData:getData
    }


});