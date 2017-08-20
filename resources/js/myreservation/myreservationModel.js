define([], function () {
    var clockTarget;
    var checkTarget;
    var usedTarget;
    var cancelTarget;
    var targetCount;
    var data;

    function saveData() {
        targetCount = $('li.item > .on > span').html();
        return getDataFromDocument();
    };

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

    function getAllData() {
        data = [];
        data.push(clockTarget);
        data.push(checkTarget);
        data.push(usedTarget);
        data.push(cancelTarget);
        return data;
    }

    function getClockAndCheckData() {
        data = [];
        data.push(clockTarget);
        data.push(checkTarget);
        return data;
    }


    function getUsedData() {
        data = [];
        data.push(usedTarget);
        return data;
    }

    function getCancelData() {
        data = [];
        data.push(cancelTarget);
        return data;
    }


    return {
        saveData: saveData,
        getAllData: getAllData,
        getClockAndCheckData: getClockAndCheckData,
        getUsedData: getUsedData,
        getCancelData: getCancelData
    }
});

