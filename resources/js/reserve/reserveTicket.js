define(['Ticket', 'Validate'], function (Ticket, Validate) {

    var numberOfTicket;

    init = function() {

      numberOfTicket = $(".qty").length;
      var tickets = [];
        for(var i=0; i<numberOfTicket; i++) {
            var ticket = new Ticket("#ticket" + i);
            tickets.push(ticket);
            ticket.on("change",function(e){
                var totalTicket = 0;
                tickets.forEach(function(ticket){
                    totalTicket += ticket.getCount();
                });
                $("#total_ticket").text(totalTicket);
                Validate.isValid();
            })
        }
    }

    return{
        init : init
    }

});