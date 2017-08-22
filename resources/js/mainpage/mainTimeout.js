define([], function () {

    var timeout;
    var interval;
    var targetFunction;
    var intervalDuration;
    var timeoutDuration;

    function init(target) {
        targetFunction = target;
        intervalDuration = 2000;
        timeoutDuration = 4000;
        timeout = 0;
        interval = 0;
        onInterval();
        setEvent();
    }

    function setSafetySector(target) {
        $(target).on("mouseenter",offAll);
        $(target).on("mouseleave",onTimer);
    }
    function setEvent() {
        $(window).focus(onTimer);
        $(window).blur(offAll);

    }

    function offInterval() {
        console.log('offInterval');
        clearInterval(interval);
        interval = 0;
    }

    function onInterval() {
        timeout = 0;
        if (interval != 0) {
           return ;
        }
        console.log('onInterval');
        interval = setInterval(targetFunction, intervalDuration);
    }

    function offTimeout() {
        console.log('offTimeout');
        clearTimeout(timeout);
        timeout = 0;
    }

    function onTimeout() {
        if (timeout != 0) {
            return ;
        }
        console.log('onTimeout');
        timeout = setTimeout(onInterval, timeoutDuration);
    }

    function offAll() {
        console.log("off");
        offInterval();
        offTimeout();
    }

    function onTimer () {
        onTimeout();
    }

    return {
        init: init,
        setSafetySector : setSafetySector

    }


    // Rolling.prototype.offRolling = function () {
    //     this.rootTarget.off("");
    // };
    //
    // Rolling.prototype.timeoutRolling = function () {
    //     clearInterval(this.intervalId);
    //     clearTimeout(this.timeoutId);
    //
    //     this.timeoutId = setTimeout(function () {
    //         this.intervalId = setInterval(this.nxtRolling.bind(this), 2000);
    //     }.bind(this), 4000);
    // };
    // Rolling.prototype.intervalRolling = function () {
    //     this.intervalId = setInterval(this.nxtRolling.bind(this), 2000);
    // };
});