import * as $ from 'jquery'

let clockTarget;
let checkTarget;
let usedTarget;
let cancelTarget;
let targetCount;


export function getDataFromDocument() {
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
    console.log(targetCount);
    return getDataFromDocument();
}


export function getAllData() {
    const data = [];
    data.push(clockTarget);
    data.push(checkTarget);
    data.push(usedTarget);
    data.push(cancelTarget);
    return data;
}

export function getClockAndCheckData() {
    const data = [];
    data.push(clockTarget);
    data.push(checkTarget);
    return data;
}


export function getUsedData() {
    const data = [];
    data.push(usedTarget);
    return data;
}

export function getCancelData() {
    const data = [];
    data.push(cancelTarget);
    return data;
}



