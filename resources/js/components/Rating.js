import Component from "@egjs/component";
import * as $ from "jquery";

export default class Rating extends Component {

    constructor({rootTarget}) {
        super();
        this.rootTarget = $(rootTarget);
        this.ratingTarget = this.rootTarget.find(".rating_rdo");
        this.ratingScore = 0;
        this.setEvent();
    }

    setEvent() {
        this.ratingTarget.on("click", e => this.clickRating);
    }

    clickRating(e) {
        e.preventDefault();
        var clickValue = parseInt(e.target.value, 10);
        this.drawRating(clickValue);
        this.trigger("change", {
            ratingScore: this.ratingScore
        })
    }

    drawRating(clickValue) {
        if (clickValue > this.ratingScore) {
            for (var i = this.ratingScore + 1; i <= clickValue; i++) {
                this.ratingTarget.eq(i).toggleClass("checked");
            }
        } else if (clickValue < this.ratingScore) {
            for (var i = clickValue + 1; i <= this.ratingScore; i++) {
                this.ratingTarget.eq(i).toggleClass("checked");
            }
        } else if (clickValue === this.ratingScore) {
            this.ratingTarget.eq(clickValue).toggleClass("checked");
            clickValue--;
        }
        this.ratingScore = clickValue;
    }
}