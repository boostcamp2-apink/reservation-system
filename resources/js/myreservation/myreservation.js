require.config({

    baseUrl:"/resources/js/myreservation",

    paths: {
        jquery: '../node_modules/jquery/dist/jquery',
        Handlebars: '../node_modules/handlebars/dist/handlebars',
        Component: '../node_modules/@egjs/component/dist/component',
        HandlebarsWrapper : '../utils/HandlebarsWrapper',
        Extend : '../utils/Extend',
        AjaxWrapper : '../utils/AjaxWrapper',
        MyreservationModel : 'myreservationModel',
        ReservationList : 'reservationList',
        ReservationPopup : 'reservationPopup'
    }

});

require(['jquery','ReservationList'],function($,ReservationList){
    ReservationList.init();
});