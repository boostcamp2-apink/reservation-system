define(['AjaxWrapper'],function(AjaxWrapper){
    var cache = {};

    function postImage(data,callback){
        var postImageUrl = "/files";

        var formData = new FormData();
        formData.append("file",data);

        AjaxWrapper.postFormFileData(postImageUrl,formData).then(function(result){
            callback(result);
        });

    }

    function postCommentData(data,callback){
        var postImageUrl = "/api/comments/";

        // var commentData = {
        //     "comment" : data
        // };

        AjaxWrapper.postData(postImageUrl,data)
            .then(function(result){
                callback(result);
            },function(error){
                alert("실패하였습니다");
            });

    }

    function getImageByFileId(fileId,callback){

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
        getImageByFileId : getImageByFileId,
        postImage : postImage,
        postCommentData : postCommentData
    }


});