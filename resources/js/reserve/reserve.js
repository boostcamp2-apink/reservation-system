
require.config({

    baseUrl:"/resources/js/reserve",

    paths: {
        jquery: '../node_modules/jquery/dist/jquery',
        Component: '../node_modules/@egjs/component/dist/component',
        AjaxWrapper : '../utils/AjaxWrapper',
        Extend : '../utils/Extend',
        Validate : 'validate',
        ReserveTicket : 'reserveTicket'
    }
});

require(['jquery','Ticket','Validate', 'ReserveTicket'],function($,Ticket, Validate, ReserveTicket){

    Validate.init();
    ReserveTicket.init();

});