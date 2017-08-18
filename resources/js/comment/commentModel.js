define(['AjaxWrapper'],function(AjaxWrapper){
    var cache = {};

    function getCommentsByProductId(productId, page, pagePerNum, callback){

        var data = cache[page];
        var url = "/api/products/" + productId + "/comments?page=" + page + "&pagePerNum=" + pagePerNum;

        if(data){
            callback(data);
        }else{
            AjaxWrapper.getData(url).then(function(result){
                cache[page] = result;
                callback(result, true);
            }).catch(function(result){
                console.log(result, false);
                callback(0);
            });
        }
    }

    return {
        getCommentsByProductId : getCommentsByProductId
    }
});