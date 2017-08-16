define(['AjaxWrapper'],function(AjaxWrapper){
    var cache = {};

    function getCommentsByProductId(url, productId, page, callback){

        var data = cache[page + " of " + productId];

        if(data){
            callback(data);
        }else{
            AjaxWrapper.getData(url).then(function(result){
                cache[page + " of " + productId] = result;
                callback(result);
            });
        }
    }

    return {
        getCommentsByProductId : getCommentsByProductId
    }


});