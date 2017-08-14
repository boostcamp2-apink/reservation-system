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

        }
    });

    ImagePopup.prototype.setSlider = function() {
        var slider = new Slider(this.dataTarget);
        slider.on("change",this.updateImageCount.bind(this));
        return slider;
    };

    ImagePopup.prototype.setSliderButton = function(prev,next){
        this.slider.setButton(prev,next);
    };

    ImagePopup.prototype.setSliderFlicking = function(){
        this.slider.setFlicking();
    };

    ImagePopup.prototype.popupData = function(data){
        HandlebarsWrapper.create(this.handleBarsId,data,"append",this.dataTarget);
        this.slider.init(this.dataTarget);
        this.currentImageNum.text(1);
        this.totalImageNum.text(data.length);
        this.rootTarget.fadeIn();
    };

    ImagePopup.prototype.setEvent = function(){
        this.close.on("click",this.clickClose.bind(this));

    };

    ImagePopup.prototype.updateImageCount = function(data){
        this.currentImageNum.text(data.currentIndex);
    };

    ImagePopup.prototype.clickClose = function(){
        this.rootTarget.fadeOut();
        this.dataTarget.empty();
    };


    return ImagePopup;
});