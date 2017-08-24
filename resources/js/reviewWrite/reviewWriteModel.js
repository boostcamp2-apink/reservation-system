import * as AjaxWrapper from "../utils/AjaxWrapper"
import * as $ from 'jquery'
let cache = {};

export function postImage({data,callback}) {
    let postImageUrl = "/files";

    let formData = new FormData();
    formData.append("file", data);

    AjaxWrapper.postFormFileData({url:postImageUrl,data: formData}).then(function (result) {
        callback(result);
    });

}

export function postCommentData({data,callback}) {
    let postImageUrl = "/api/comments/";

    // var commentData = {
    //     "comment" : data
    // };

    AjaxWrapper.postData({url: postImageUrl,data: data})
        .then(function (result) {
            callback(result);
        }, function (error) {
            alert("실패하였습니다");
        });

}





