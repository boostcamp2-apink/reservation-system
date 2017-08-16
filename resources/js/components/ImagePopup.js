define(['Extend', 'Component','HandlebarsWrapper','Slider'], function (extend, Component, HandlebarsWrapper, Slider) {

    var ImagePopup = extend(Component, {
        "init": function (rootTarget,dataTarget,handleBarsId) {
            this.rootTarget = $(rootTarget);
            this.dataTarget = $(dataTarget);
            this.handleBarsId = handleBarsId;
            this.close = this.rootTarget.find(".popup_close");
            this.totalImageNum = this.rootTarget.find(".popup_total_image_num");
            this.currentImageNum = this.rootTarget.find(".popup_image_num");
            this.slider = this.setSlider();
            this.setEvent();

        },
        setSlider : function() {
            var slider = new Slider(this.dataTarget);
            slider.on("change",this.updateImageCount.bind(this));
            return slider;
        },

        setSliderButton : function(prev,next){
            this.slider.setButton(prev,next);
        },

        setSliderFlicking : function(){
            this.slider.setFlicking();
        },

        popupData : function(data){
            HandlebarsWrapper.create(this.handleBarsId,data,"append",this.dataTarget);
            this.slider.init(this.dataTarget);
            this.currentImageNum.text(1);
            this.totalImageNum.text(data.length);
            this.rootTarget.fadeIn();
        },

        setEvent : function(){
            this.close.on("click",this.clickClose.bind(this));

        },

        updateImageCount : function(data){
            this.currentImageNum.text(data.currentIndex);
        },

        clickClose : function(){
            this.rootTarget.fadeOut();
            this.dataTarget.empty();
        }
    });

    return ImagePopup;
});