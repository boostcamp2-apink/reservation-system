import ImagePopup from "../components/ImagePopup"
import $ from "jquery"

let popup;
let imagePopup;
let $commentImage;

export function init() {
    popup = "#photoview";
    $commentImage = $('div.thumb_area');
    setEvent();
}

function setEvent() {
    imagePopup =
        new ImagePopup({rootTarget:popup,dataTarget:popup + " ul.visual_img",handleBarsId:'comment-image-template'});
    imagePopup.setSliderButton({prev:popup + ' div.prev_inn > a.btn_prev',next: popup + ' div.nxt_inn > a.btn_nxt'});

    $commentImage.on("click", clickCommentImage);
}

function clickCommentImage(e) {
    e.preventDefault();
    let data = $(e.currentTarget).data("images");
    imagePopup.popupData(data);
}



