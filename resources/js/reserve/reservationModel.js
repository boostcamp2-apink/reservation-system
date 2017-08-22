import * as AjaxWrapper from "../utils/AjaxWrapper"

export function addReservation(data) {

    AjaxWrapper.postData("/reservations", data).then(function (result) {
        $(location).attr('href', "/reservations");
    });
}