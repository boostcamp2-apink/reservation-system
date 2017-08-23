import Component from "@egjs/component";
import $ from "jquery"

export default class Ticket extends Component {

    constructor(rootTarget) {
        super();
        this.rootTarget = $(rootTarget);
        this.countEle = $(rootTarget + " .count_control_input");
        this.price = $(rootTarget + " .price").text();
        this.totalPrice = $(rootTarget + " .total_price");
        this.minusBtn = $(rootTarget + " .ico_minus3");

        this.count = 0;
        this.setEvent();
    }


    setEvent() {
        this.rootTarget.on("click", ".ico_plus3", this.plus.bind(this));
        this.rootTarget.on("click", ".ico_minus3", this.minus.bind(this));
    }


    plus(e) {
        e.preventDefault();
        this.countEle.val(++this.count);
        this.totalPrice.text(this.getTotalPrice());
        this.trigger("change", {
            "sign": 1,
            "price": this.price
        })
        this.removeDisabled();
    }



    minus(e) {
        e.preventDefault();
        if (this.count > 0) {
            this.countEle.val(--this.count);
            this.totalPrice.text(this.getTotalPrice());
        }
        if (this.count == 0) {
            this.addDisabled();
        }
        this.trigger("change", {
            "sign": -1,
            "price": this.price
        })
    }


    addDisabled() {
        this.countEle.addClass("disabled");
        this.minusBtn.addClass("disabled");

    }


    removeDisabled() {
        this.countEle.removeClass("disabled");
        this.minusBtn.removeClass("disabled");
    }


    getCount() {
        return parseInt(this.countEle.val(), 10);
    }

    getTotalPrice() {
        return this.count * this.price;
    }
}



