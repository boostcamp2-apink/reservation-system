define(['AjaxWrapper'],function(AjaxWrapper){
    var cache = {};

    function getProductsByCategoryId(categoryId,page,callback){

        var url = "/api/categories/"+categoryId+"/products?page="+page;
        var data = cache[url];

        if(data){
            callback(data);
        }else{
            AjaxWrapper.getData(url).then(function(result){
                cache[url] = result;
                callback(result);
            });
        }
    }

    return {
        getProductsByCategoryId : getProductsByCategoryId
    }


});