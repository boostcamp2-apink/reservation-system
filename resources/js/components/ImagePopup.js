import Component from "@egjs/component";
import * as HandlebarsWrapper from "../utils/HandlebarsWrapper";
import Slider from "./Slider"

export default class ImagePopup extends Component {
    constructor({rootTarget, dataTarget, handleBarsId}) {
        super();
        this.rootTarget = $(rootTarget);
        this.dataTarget = $(dataTarget);
        this.handleBarsId = handleBarsId;
        this.close = this.rootTarget.find(".popup_close");
        this.totalImageNum = this.rootTarget.find(".popup_total_image_num");
        this.currentImageNum = this.rootTarget.find(".popup_image_num");
        this.slider = this.setSlider();
        this.setEvent();

    }

    setSlider() {
        var slider = new Slider(this.dataTarget);
        slider.on("change",() => this.updateImageCount);
        return slider;
    }

    setSliderButton({prev, next}) {
        this.slider.setButton(prev,next);
    }

    setSliderFlicking() {
        this.slider.setFlicking();
    }

    popupData(data) {
        HandlebarsWrapper.create(this.handleBarsId, data, "append", this.dataTarget);
        this.slider.init(this.dataTarget);
        this.currentImageNum.text(1);
        this.totalImageNum.text(data.length);
        this.rootTarget.fadeIn();
    }

    setEvent() {
        this.close.on("click", e => this.clickClose);

    }

    updateImageCount({currentIndex}) {
        this.currentImageNum.text(currentIndex);
    }

    clickClose() {
        this.rootTarget.fadeOut();
        this.dataTarget.empty();
    }
}
