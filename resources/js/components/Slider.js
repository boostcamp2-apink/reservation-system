// noinspection JSAnnotator
define(['Extend', 'Component'], function (extend, Component) {

    var Slider = extend(Component, {
        "init": function (rootTarget) {
            this.rootTarget = $(rootTarget) || this.rootTarget;
            this.SliderTargets = this.rootTarget.children();
            this.targetCount = this.SliderTargets.length;
            this.width = this.SliderTargets.width();
            this.currentChildIndex;
            this.isAnimating = false;
            this.createFakeTarget();
            console.log(this.rootTarget);
        },

        setButton: function (prev, next) {
            this.prev = $(prev);
            this.next = $(next);
            this.clickEvent();
        },

        setFlicking: function () {

        },

        createFakeTarget: function () {
            var fakeFirstChild = this.rootTarget.children(':first-child').clone();
            var fakeLastChild = this.rootTarget.children(':last-child').clone();
            this.rootTarget.append(fakeFirstChild);
            this.rootTarget.prepend(fakeLastChild);
            this.currentChildIndex = 1;
            this.rootTarget.css({"transform": "translate(-" + this.width * this.currentChildIndex + "px,0)"});

        },

        clickEvent: function () {
            $(this.prev).on("click", this.clickPrev.bind(this));
            $(this.next).on("click", this.clickNext.bind(this));
        },

        clickPrev: function (e) {
            e.preventDefault();
            if (this.isAnimating) {
                return;
            } else {
                this.isAnimating = true;
                this.animator('prev');
            }

        },

        clickNext: function (e) {
            e.preventDefault();
            if (this.isAnimating) {
                return;
            } else {
                this.isAnimating = true;
                this.animator('next');
            }

        },

        //direction value is "next" or "prev"
        animator: function (direction) {
            var moveSize;
            var moveIndex;
            if (direction === "next") {
                moveSize = -this.width;
                moveIndex = 1;
            } else if (direction === "prev") {
                moveSize = this.width;
                moveIndex = -1;
            }
            this.transformAnimate(moveSize, moveIndex);

        },
        transformAnimate: function (moveSize, moveIndex) {
            this.rootTarget.animate(
                {move: moveSize},
                {
                    duration: 1000,
                    start: function () {
                        if (this.currentChildIndex === this.targetCount && moveIndex === 1) {
                            this.currentChildIndex = 0;
                        }
                    }.bind(this),

                    step: function (now) {
                        this.rootTarget.css({"transform": "translate(" + (-(this.width * this.currentChildIndex) + now) + "px,0)"});
                    }.bind(this),

                    complete: function () {
                        this.currentChildIndex += moveIndex;
                        if (this.currentChildIndex === 0 && moveIndex === -1) {
                            this.currentChildIndex = this.targetCount;
                        }
                        delete this.rootTarget.get(0).move;
                        this.isAnimating = false;
                        this.trigger("change",{
                            currentIndex : this.currentChildIndex
                        });

                    }.bind(this)

                }
            );
        }
    });
    return Slider;
});