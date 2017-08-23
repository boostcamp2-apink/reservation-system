import * as AjaxWrapper from '../utils/AjaxWrapper'

let cache = {};

export function getCommentsByProductId(productId, page, pagePerNum, callback) {

    let data = cache[page];
    let url = "/api/products/" + productId + "/comments?page=" + page + "&pagePerNum=" + pagePerNum;

    if (data) {
        callback(data);
    } else {
        AjaxWrapper.getData(url).then(function (result) {
            cache[page] = result;
            callback(result, true);
        }).catch(function (result) {
            console.log(result, false);
            callback(0);
        });
    }
}

