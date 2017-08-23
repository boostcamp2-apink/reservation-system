import Ticket from "../components/Ticket"
import $ from 'jquery'

var numberOfTicket;
var tickets = [];

export function init(callback) {
    numberOfTicket = $(".qty").length;
    createTickets(callback);
}

function createTickets(callback) {

    for (var i = 0; i < numberOfTicket; i++) {
        var ticket = new Ticket("#ticket" + i);
        tickets.push(ticket);

        ticket.on("change", function (sign, price) {
            callback(sign, price);
        })
    }

}
