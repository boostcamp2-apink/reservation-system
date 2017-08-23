import * as Booker from "./Booker"
import * as TicketContainer from "./TicketContainer"

Booker.init();
TicketContainer.init(Booker.updateTicket);
