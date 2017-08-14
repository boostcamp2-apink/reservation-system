
require.config({

    baseUrl:"/resources/js/reserve",

    paths: {
        jquery: '../node_modules/jquery/dist/jquery',
        Component: '../node_modules/@egjs/component/dist/component',
        AjaxWrapper : '../utils/AjaxWrapper',
        Extend : '../utils/Extend',
        Booker : 'Booker',
        Ticket : '../components/Ticket',
        TicketContainer : 'ticketContainer'
    }
});

require(['jquery', 'Booker', 'TicketContainer'],function($, Booker, TicketContainer){

    Booker.init();
    TicketContainer.init(Booker.updateTicket);

});