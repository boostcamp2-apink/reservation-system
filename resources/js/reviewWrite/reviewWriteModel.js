import * as AjaxWrapper from "../utils/AjaxWrapper"

let cache = {};

export function postImage(data, callback) {
    let postImageUrl = "/files";

    let formData = new FormData();
    formData.append("file", data);

    AjaxWrapper.postFormFileData(postImageUrl, formData).then(function (result) {
        callback(result);
    });

}

export function postCommentData(data, callback) {
    let postImageUrl = "/api/comments/";

    // var commentData = {
    //     "comment" : data
    // };

    AjaxWrapper.postData(postImageUrl, data)
        .then(function (result) {
            callback(result);
        }, function (error) {
            alert("실패하였습니다");
        });

}

export function getImageByFileId(fileId, callback) {

    let url = "/api/categories/" + categoryId + "/products?page=" + page;
    let data = cache[url];

    if (data) {
        callback(data);
    } else {
        AjaxWrapper.getData(url).then(function (result) {
            cache[url] = result;
            callback(result);
        });
    }
}




