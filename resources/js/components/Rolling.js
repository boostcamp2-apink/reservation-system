define(['Extend', 'Component'], function (extend, Component) {

    var Rolling = extend(Component, {
        "init": function (rootTarget, timeoutFlag, prev, next) {
            this.rollingCount = 0;
            this.intervalId;
            this.timeoutId;
            this.rollingSize = $(rootTarget).find(".visual_img > li").length - 1;
            this.rollingFlag = 0;
            this.width = $(rootTarget).find(".visual_img > li").width();
            this.rootTarget = rootTarget;
            this.cycleFlag = 0;
            this.timeoutFlag = timeoutFlag;
            this.prev = prev;
            this.next = next;
            this.setEvent();
        }
    });

    Rolling.prototype.setEvent = function () {
        $(this.prev).on("click", this.clickPrev.bind(this));
        $(this.next).on("click", this.clickNext.bind(this));

    };
    Rolling.prototype.clickPrev = function (){
        if (!this.rollingFlag) {
            this.preRolling();
            if (this.timeoutFlag) {
                this.timeoutRolling();
            } else {
                ProductDetail.updateRollingCount(0); // 임시로 해놓은 것
            }
        }
    };
    Rolling.prototype.clickNext = function (){
            if (!this.rollingFlag) {
                this.nxtRolling();
                if (this.timeoutFlag) {
                    this.timeoutRolling();
                } else {
                    ProductDetail.updateRollingCount(1); // 임시로 해놓은 것
                }
            }
    };
    Rolling.prototype.nxtRolling = function () {
        var $img = this.rootTarget.find(".visual_img");

        if (this.rollingCount < this.rollingSize) {
            $img.animate({"left": "-=" + this.width}, {
                duration: 500,
                start: function () {
                    this.rollingFlag = 1;
                }.bind(this),
                complete: function () {
                    this.rollingFlag = 0;
                    this.rollingCount++;
                }.bind(this)
            });
        } else if (this.cycleFlag) {
            $img.css("left", "0px");
            $img.animate({"left": "-=" + this.width}, {
                duration: 500,
                start: function () {
                    this.rollingFlag = 1;
                }.bind(this),
                complete: function () {
                    this.rollingFlag = 0;
                    this.rollingCount = 0;
                }.bind(this)
            });
        }
    };

    Rolling.prototype.preRolling = function () {
        var $img = this.rootTarget.find(".visual_img");

        if (this.rollingCount > 0) {
            $img.animate({"left": "+=" + this.width}, {
                duration: 500,
                start: function () {
                    this.rollingFlag = 1;
                }.bind(this),
                complete: function () {
                    this.rollingFlag = 0;
                    this.rollingCount--;
                }.bind(this)
            });
        } else if (this.cycleFlag) {
            $img.animate({"left": "+=" + this.width}, {
                duration: 500,
                start: function () {
                    this.rollingFlag = 1;
                }.bind(this),
                complete: function () {
                    $img.css('left', -(this.width * (this.rollingSize + 1)));
                    this.rollingFlag = 0;
                    this.rollingCount = this.rollingSize;
                }.bind(this)
            });
        }
    };

    Rolling.prototype.offRolling = function (){
        this.rootTarget.off("");
    };

    Rolling.prototype.timeoutRolling = function () {
        clearInterval(this.intervalId);
        clearTimeout(this.timeoutId);

        this.timeoutId = setTimeout(function () {
            this.intervalId = setInterval(this.nxtRolling.bind(this), 2000);
        }.bind(this), 4000);
    };
    Rolling.prototype.intervalRolling = function () {
        this.intervalId = setInterval(this.nxtRolling.bind(this), 2000);
    };
    // rolling에 flag를 줘서 이벤트 발생 도중이면 이벤트를 스킵
    // animate에 callback함수 등록

    return Rolling;
});