define(['Slider'],function(Slider){

    var slider;
    var $moreContent;
    var $imageNum;
    var root;

    function init(){
        $moreContent = $(".section_store_details");
        $imageNum = $("#image_num");
        root = '.section_visual';
        setEvent();
    }

    function setEvent(){
        slider = new Slider(root+' ul.visual_img');
        slider.setButton(root+' div.prev_inn > a.btn_prev', root+' div.nxt_inn > a.btn_nxt');
        setImageCountEvent();
        $moreContent.find('a.bk_more').on("click",clickMoreDetail);

    }

    function clickMoreDetail(e){
        e.preventDefault();
        $moreContent.find("div.store_details").toggleClass("close3");
        $(e.currentTarget).css("display","none");
        $(e.currentTarget).siblings("a").css("display","");
    }

    function setImageCountEvent(){
        slider.on("change",updateImageCount);
    }

    function updateImageCount(data){
        $imageNum.text(data.currentIndex);
    }

    return {
        init : init
    }



});