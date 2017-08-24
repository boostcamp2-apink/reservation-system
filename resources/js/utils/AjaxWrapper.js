import * as $ from 'jquery'

export function getData(url) {
    return $.ajax({
        url: url,
        dataType: 'json',
        type: 'GET'
    })
}

export function postData({url, data}) {
    return $.ajax({
        url: url,
        contentType: "application/json; charset=UTF-8",
        dataType: 'json',
        data: JSON.stringify(data),
        type: 'POST'
    })

}

export function postFormFileData({url, data}) {
    return $.ajax({
        url: url,
        processData: false,
        contentType: false,
        data: data,
        type: 'POST'
    })
}