package Service.Impl;

import Exceptions.InvalidTicketPriceException;
import Exceptions.TicketsNotFoundException;
import Model.Ticket;
import Service.TicketService;
import Utils.AuditSingleton;

import java.util.ArrayList;
import java.util.List;

import static Validations.TicketValidation.ticketPriceValidation;
public class TicketServiceImpl implements TicketService {
    List<Ticket> tickets;

    @Override
    public void addTicket(Ticket ticket) throws Exception {
        boolean validTicket = true;

        try {
            if (!ticketPriceValidation(ticket.getPrice())) {
                throw new InvalidTicketPriceException("Ticket cannot be free");
            }
        } catch (InvalidTicketPriceException exception) {
            validTicket = false;
            System.out.println(exception.getMessage());
        }

        if (tickets == null)
            tickets = new ArrayList<>();
        tickets.add(ticket);
        AuditSingleton.INSTANCE.writeAction("Add ticket");
    }

    @Override
    public List<Ticket> getTicket() throws Exception {
        try {
            if (tickets == null)
                throw new TicketsNotFoundException("Ticket list cannot be empty");
        } catch (TicketsNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get Ticket");
        return tickets;
    }

    @Override
    public float totalTicketPrice() throws Exception {
        float total = 0;
        try {
            if (tickets == null)
                throw new TicketsNotFoundException("It's not possible to calculate the total price of tickets for an empty list.");

            for (Ticket ticket : tickets) {
                total += ticket.getPrice();
            }
        } catch (TicketsNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Total ticket price");
        return total;
    }
}
