import $ from 'jquery'

let clockTarget;
let checkTarget;
let usedTarget;
let cancelTarget;
let targetCount;
let data;

function getDataFromDocument() {
    if (targetCount === '0') {
        return false;
    }
    else {
        clockTarget = $('li._clock');
        checkTarget = $('li._check');
        usedTarget = $('li._used');
        cancelTarget = $('li._cancel');
        return true;
    }
}


export function saveData() {
    targetCount = $('li.item > .on > span').html();
    return getDataFromDocument();
}


export function getAllData() {
    data = [];
    data.push(clockTarget);
    data.push(checkTarget);
    data.push(usedTarget);
    data.push(cancelTarget);
    return data;
}

export function getClockAndCheckData() {
    data = [];
    data.push(clockTarget);
    data.push(checkTarget);
    return data;
}


export function getUsedData() {
    data = [];
    data.push(usedTarget);
    return data;
}

export function getCancelData() {
    data = [];
    data.push(cancelTarget);
    return data;
}



