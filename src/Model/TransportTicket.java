package Model;

import Utils.IssuingInstitution;
import Utils.TransportType;

import java.util.Date;

public class TransportTicket extends Ticket {
    private TransportType meansOfTransport;
    private int availability;

    public TransportTicket() {
    }

    public TransportTicket(String city, float price, Date date, IssuingInstitution issuingInstitution, TransportType meansOfTransport, int availability) {
        super(city, price, date, issuingInstitution);
        this.meansOfTransport = meansOfTransport;
        this.availability = availability;
    }

    public TransportType getMeansOfTransport() {
        return meansOfTransport;
    }

    public void setMeansOfTransport(TransportType meansOfTransport) {
        this.meansOfTransport = meansOfTransport;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public boolean isAvailable() {
        Date currentDate = new Date();
        return (currentDate.getTime() - super.getDate().getTime()) / (60 * 1000) <= 90;
    }

    @Override
    public void ticketDetails() {
        System.out.println("Ticket for: " + meansOfTransport + ", " + super.toString() + ", availability: " + availability);
    }

    @Override
    public String toString() {
        return "TransportTicket{" +
                "meansOfTransport='" + meansOfTransport + '\'' +
                ", availability=" + availability +
                '}';
    }
}
