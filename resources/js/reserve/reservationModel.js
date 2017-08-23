import * as AjaxWrapper from "../utils/AjaxWrapper";
import $ from 'jquery'

export function addReservation(data) {

    AjaxWrapper.postData("/reservations", data).then(function (result) {
        $(location).attr('href', "/reservations");
    });
}