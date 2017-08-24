// noinspection JSAnnotator
import Component from '@egjs/component'
import * as $ from 'jquery'

export default class Slider extends Component {

    constructor(rootTarget) {
        super();
        this.rootTarget = $(rootTarget);
        this.init();

    }

    init() {
        this.SliderTargets = this.rootTarget.children();
        this.targetCount = this.SliderTargets.length;
        this.width = this.SliderTargets.width();
        this.currentChildIndex = 0;
        this.isAnimating = false;
        this.createFakeTarget();
    }

    setButton({prev, next}) {
        this.prev = $(prev);
        this.next = $(next);
        this.clickEvent();
    }

    setFlicking() {

    }

    createFakeTarget() {
        const fakeFirstChild = this.rootTarget.children(':first-child').clone();
        const fakeLastChild = this.rootTarget.children(':last-child').clone();
        this.rootTarget.append(fakeFirstChild);
        this.rootTarget.prepend(fakeLastChild);
        this.currentChildIndex = 1;
        this.rootTarget.css({"transform": "translate(-" + this.width * this.currentChildIndex + "px,0)"});

    }

    clickEvent() {
        $(this.prev).on("click", e => this.clickPrev(e));
        $(this.next).on("click", e => this.clickNext(e));
    }

    clickPrev(e) {
        e.preventDefault();
        if (!this.isAnimating) {
            this.isAnimating = true;
            this.animator('prev');
        }
    }

    clickNext(e) {
        e.preventDefault();
        if (!this.isAnimating) {
            this.isAnimating = true;
            this.animator('next');
        }

    }

    //direction value is "next" or "prev"
    animator(direction = "left") {
        let moveSize;
        let moveIndex;
        if (direction === "next") {
            moveSize = -this.width;
            moveIndex = 1;
        } else if (direction === "prev") {
            moveSize = this.width;
            moveIndex = -1;
        }
        this.transformAnimate(moveSize, moveIndex);

    }

    transformAnimate(moveSize, moveIndex) {
        this.rootTarget.animate(
            {move: moveSize},
            {
                duration: 1000,
                start: () => {
                    if (this.currentChildIndex === this.targetCount && moveIndex === 1) {
                        this.currentChildIndex = 0;
                    }
                },

                step: now => {
                    this.rootTarget.css({"transform": "translate(" + (-(this.width * this.currentChildIndex) + now) + "px,0)"});
                },

                complete: () => {
                    this.currentChildIndex += moveIndex;
                    if (this.currentChildIndex === 0 && moveIndex === -1) {
                        this.currentChildIndex = this.targetCount;
                    }
                    delete this.rootTarget.get(0).move;
                    this.isAnimating = false;
                    this.trigger("change", {
                        currentIndex: this.currentChildIndex
                    });
                }
            }
        )
    }
}