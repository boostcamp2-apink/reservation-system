
var InputForReserve = (function(){

    function showAgreement(e){
        e.preventDefault();
        var target = $(e.target).closest("div.agreement");
        isOpen = target.hasClass("open");
        if(isOpen == false){
            target.addClass("open");
        } else {
            target.removeClass("open");
        }
    };

    function init(){
       $("div.agreement > a.btn_agreement").on("click", showAgreement);
    }
    return {
        init : init
    }
})();