define(['Extend', 'Component'], function (extend, Component) {

    var Rolling = extend(Component, {
        "init": function (rootTarget, prev, next) {
            this.rootTarget = $(rootTarget);
            this.prev = $(prev);
            this.next = $(next);
            this.rollingTargets = this.rootTarget.children();
            this.targetCount = this.rollingTargets.length;
            this.width = this.rollingTargets.width();
            this.currentChildIndex;
            this.isAnimating = false;
            this.createFakeTarget();
            this.setEvent();
        }
    });
    Rolling.prototype.createFakeTarget = function() {
        var fakeFirstChild = this.rootTarget.children(':first-child').clone();
        var fakeLastChild = this.rootTarget.children(':last-child').clone();
        this.rootTarget.append(fakeFirstChild);
        this.rootTarget.prepend(fakeLastChild);
        this.currentChildIndex = 1;
        this.rootTarget.css({"transform": "translate(-" + this.width*this.currentChildIndex + "px,0)"});

    };

    Rolling.prototype.setEvent = function () {
        $(this.prev).on("click", this.clickPrev.bind(this));
        $(this.next).on("click", this.clickNext.bind(this));
    };
    Rolling.prototype.clickPrev = function (){
        if (this.isAnimating) {
            return ;
        } else {
            this.isAnimating = true;
            this.animator('prev');
        }

    };
    Rolling.prototype.clickNext = function (){
            if (this.isAnimating) {
                return ;
            } else {
                this.isAnimating = true;
                this.animator('next');
            }
    };

    //direction value is "next" or "prev"
    Rolling.prototype.animator = function(direction) {
        var moveSize;
        var moveIndex;
        if(direction === "next") {
            moveSize = -this.width;
            moveIndex = 1;
        } else if(direction === "prev") {
            moveSize = this.width;
            moveIndex = -1;
        }
        this.rootTarget.animate(
            {move : moveSize},
            {
                duration : 1000,
                step : function(now) {
                    this.rootTarget.css({"transform": "translate(" + (-(this.width*this.currentChildIndex)+now) + "px,0)"});
                }.bind(this),
                complete: function () {
                    this.currentChildIndex += moveIndex;
                    if(this.currentChildIndex === 0 || this.currentChildIndex === this.targetCount+1) {
                        if (this.currentChildIndex === 0) {
                            this.currentChildIndex = this.targetCount;
                        } else if (this.currentChildIndex === this.targetCount + 1) {
                            this.currentChildIndex = 1;
                        }
                        this.rootTarget.css({"transform": "translate(-" + this.width * this.currentChildIndex + "px,0)"})
                    }
                    delete this.rootTarget.get(0).move;
                    this.isAnimating = false;
                }.bind(this)
            });
    };

    return Rolling;
});