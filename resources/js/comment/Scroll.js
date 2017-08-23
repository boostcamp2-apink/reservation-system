import Component from "@egjs/component";
import $ from "jquery";


export class Scroll extends Component() {

    setDownScroll(callback) {
        $(window).scroll(function () {
            callback();
        })
    }

    setUpScroll(callback) {
        $(window).scroll(function () {
            callback();
        })
    }
};
