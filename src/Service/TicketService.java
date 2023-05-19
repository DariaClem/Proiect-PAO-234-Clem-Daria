package Service;

import Model.Ticket;

import java.util.List;

public interface TicketService {
    void addTicket(Ticket ticket) throws Exception;

    List<Ticket> getTicket() throws Exception;

    float totalTicketPrice() throws Exception;
}
