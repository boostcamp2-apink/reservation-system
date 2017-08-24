import $ from 'jquery'

let timeout;
let interval;
let targetFunction;
let intervalDuration;
let timeoutDuration;

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
    if (interval !== 0) {
        return;
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
    if (timeout !== 0) {
        return;
    }
    console.log('onTimeout');
    timeout = setTimeout(onInterval, timeoutDuration);
}

function offAll() {
    console.log("off");
    offInterval();
    offTimeout();
}

function onTimer() {
    onTimeout();
}

export function init(target) {
    targetFunction = target;
    intervalDuration = 2000;
    timeoutDuration = 4000;
    timeout = 0;
    interval = 0;
    onInterval();
    setEvent();
}

export function setSafetySector(target) {
    $(target).on("mouseenter", offAll);
    $(target).on("mouseleave", onTimer);
}