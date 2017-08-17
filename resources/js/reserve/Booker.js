define([], function () {

    var name;
    var tel;
    var email;
    var agreement;
    var reservBtn;
    var ticketTarget;
    var totalTicket = 0;
    var priceTarget;
    var totalPrice = 0;

    init = function(){

       $("div.agreement > a.btn_agreement").on("click", showAgreement);

        reservBtn = $(".box_bk_btn .bk_btn_wrap");
        name = $(".form_wrap #name");
        tel = $(".form_wrap #tel");
        email = $(".form_wrap #email");
        agreement = $('.chk_agree');
        agreement.on("click", function(){
            isValid();
        })
        ticketTarget = $("span#total_ticket");
        priceTarget = $("span#total_price");

        isValid();
    },

    showAgreement = function(e){
        e.preventDefault();
        var target = $(e.target).closest("div.agreement");
        isOpen = target.hasClass("open");
        if(isOpen == false){
            target.addClass("open");
        } else {
            target.removeClass("open");
        }
    };

    isValid = function(){

        var nf_tel = /^0(2|\d\d)-\d{3,4}-\d{4}$/;
        var nf_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

        if((name.val() != undefined) && nf_tel.test(tel.val()) &&
            nf_email.test(email.val()) && (totalTicket > 0) && agreement.is(":checked")){
            reservBtn.removeClass("disable");
        } else{
            reservBtn.addClass("disable");
        }

    },

    updateTicket = function(sign, price){
        totalTicket += sign;
        totalPrice += sign * price;
        ticketTarget.text(totalTicket);
        priceTarget.text(totalPrice);
        isValid();
    }

    return {
        init : init,
        isValid : isValid,
        updateTicket : updateTicket
    }

});