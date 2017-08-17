define(['Slider', 'ImagePopup'], function (Slider, ImagePopup) {

    var popupSlider;
    var popup;
    var imagePopup;
    var $commentImage;

    function init() {
        popup = "#photoview";
        $commentImage = $('div.thumb_area');
        setEvent();

    }

    function setEvent() {
        imagePopup =
            new ImagePopup(popup, popup + " ul.visual_img",'comment-image-template');
        imagePopup.setSliderButton(popup + ' div.prev_inn > a.btn_prev', popup + ' div.nxt_inn > a.btn_nxt');

        $commentImage.on("click", clickCommentImage);
    }

    function clickCommentImage(e) {
        e.preventDefault();
        var data = $(e.currentTarget).data("images");
        imagePopup.popupData(data);
    }

    return {
        init: init
    }


});