define(['MyreservationModel','ReservationPopup'], function (MyreservationModel,ReservationPopup) {

    var emptyTarget;
    var rootTarget;
    var summaryTargets;
    var currentSummaryTarget;

    function init() {
        rootTarget = $('ul._cardList');
        emptyTarget = getEmptyElement();
        ReservationPopup.init($('div._popup'));
        if (!MyreservationModel.saveData()) {
            drawEmptyTarget();
        }
        summaryTargets = $('ul._summaryBoard');
        currentSummaryTarget = summaryTargets.find('.on');
        setEvent();
    }

    function setEvent() {
        summaryTargets.on('click', 'li.item > a', filterHandler);
        rootTarget.on('click', '._btnCancel', cancelReservation);
        rootTarget.on('click', '._btnReview', addReview);
    }

    function cancelReservation(event) {
        var canceldata = {};
        event.preventDefault();
        console.log("cancel");
        ReservationPopup.show($(event.currentTarget).closest('article.card_item'));
    }

    function addReview(event) {
        event.preventDefault();
        console.log("review");
    }

    function filterHandler(event) {
        var clickedTarget = $(event.currentTarget);
        if (!clickedTarget.hasClass('on')) {
            currentSummaryTarget.removeClass('on');
            clickedTarget.addClass('on');
            currentSummaryTarget = clickedTarget;

            drawTarget(findClass(currentSummaryTarget));
        }
    }

    function findClass(target) {
        if (target.hasClass('_all')) {
            return "all";
        } else if (target.hasClass('_clockAndCheck')) {
            return "clockAndCheck"
        } else if (target.hasClass('_used')) {
            return "used"
        } else if (target.hasClass('_cancel')) {
            return "cancel"
        }
    }

    function drawTarget(className) {
        if ($('a._' + className + '> span').html() === '0') {
            drawEmptyTarget();
        } else {
            var data;
            switch (className) {
                case "all":
                    data = MyreservationModel.getAllData();
                    break;
                case "clockAndCheck":
                    data=MyreservationModel.getClockAndCheckData();
                    break;
                case "used":
                    data=MyreservationModel.getUsedData();
                    break;
                case "cancel":
                    data=MyreservationModel.getCancelData();
                    break;
            }

            rootTarget.html(data);
        }
    }

    function drawEmptyTarget() {
        rootTarget.html(emptyTarget);
    }

    function getEmptyElement() {
        return "<br><div class=\'err\'> <i class=\'spr_book ico_info_nolist\'></i>" +
            "<h1 class=\'tit\'>예약 리스트가 없습니다</h1>\n" +
            "</div>";
    }

    return {
        init: init
    }

});