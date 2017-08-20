define([], function () {
    var popupTarget;
    var popupTitle;
    var popupDate;
    var reservationId;
    function init(target) {
        popupTarget = target;
        popupTitle = popupTarget.find('.pop_tit > span');
        popupDate = popupTarget.find('.pop_tit > small');
        setEvent();
    }

    function setEvent() {
        popupTarget.on('click','.popup_btn_close',closePopup);
        popupTarget.on('click','.btn_gray',closePopup);
        popupTarget.on('click','.btn_green',cancelReservation);
    }

    function cancelReservation() {
        event.preventDefault();
        location.href = "/reservations/cancel/"+reservationId;
    }
    function closePopup(event) {
        event.preventDefault();
        popupTarget.toggle();
    }

    function show(target) {
        reservationId = target.find('._reservationId').text();
        popupTitle.text(target.find('div.card_detail > .tit').text());
        popupDate.text(target.find('li:first-child > .item_dsc').text());
        popupTarget.toggle();
        console.log(reservationId);

    }
    return {
        init : init,
        show : show
    }
});