package Model;

import Utils.IssuingInstitution;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MuseumTicket extends Ticket {
    private int museumId;

    public MuseumTicket() {
    }

    public MuseumTicket(String city, float price, Date data, IssuingInstitution issuingInstitution, int museumId) {
        super(city, price, data, issuingInstitution);
        this.museumId = museumId;
    }

    public int getMuseumId() {
        return museumId;
    }

    public void setMuseumId(int museumId) {
        this.museumId = museumId;
    }

    public boolean isAvailable() {
        Date currentDate = new Date();
        long difference = TimeUnit.DAYS.convert((currentDate.getTime() - super.getDate().getTime()), TimeUnit.DAYS);
        return difference <= 1;
    }

    @Override
    public void ticketDetails() {
        System.out.println("Museum ticket with id: " + museumId + ", " + super.toString());
    }
}
