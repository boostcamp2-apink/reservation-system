import * as Ticket from "../components/Ticket"
import * as Booker from "./Booker"

var numberOfTicket;
var tickets = [];

init = function (callback) {
    numberOfTicket = $(".qty").length;
    createTickets(callback);
},

    createTickets = function (callback) {

        for (var i = 0; i < numberOfTicket; i++) {
            var ticket = new Ticket("#ticket" + i);
            tickets.push(ticket);

            ticket.on("change", function (data) {
                callback(data.sign, data.price);
            })
        }

    }

return {
    init: init
}
