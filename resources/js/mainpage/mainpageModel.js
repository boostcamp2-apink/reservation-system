import * as AjaxWrapper from '../utils/AjaxWrapper'

let cache = {};

export function getProductsByCategoryId(categoryId, page) {

    const url = "/api/categories/" + categoryId + "/products?page=" + page;
    const data = cache[url];

    return new Promise(function (resolve, reject) {
        if (data) {
            resolve(data);
        } else {
            AjaxWrapper.getData(url)
                .then(function (result) {
                    cache[url] = result;
                    resolve(result);
                })
                .catch(function (error) {
                    reject(error);
                })
        }
    })
}

