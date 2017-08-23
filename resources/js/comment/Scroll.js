define(['Extend', 'Component'], function (extend, Component) {

    return extend(Component, {
        "init": function (rootTarget) {

        },

        setDownScroll : function (callback) {
            $(window).scroll(function () {
                callback();
            })
        },

        setUpScroll : function (callback) {
            $(window).scroll(function() {
                callback();
            })
        },
    });

});