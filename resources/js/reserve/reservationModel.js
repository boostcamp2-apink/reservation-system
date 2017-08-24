import * as AjaxWrapper from "../utils/AjaxWrapper";
import $ from 'jquery'

export function addReservation(data) {

    AjaxWrapper.postData({url:"/reservations", data:data}).then(function (result) {
        $(location).attr('href', "/reservations");
    });
}