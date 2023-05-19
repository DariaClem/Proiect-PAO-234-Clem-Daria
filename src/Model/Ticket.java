package Model;

import Utils.IssuingInstitution;

import java.util.Date;
import java.util.UUID;

public abstract class Ticket {
    private final UUID id;
    private String city;
    private float price;
    private Date date;
    private IssuingInstitution issuingInstitution;

    public Ticket() {
        this.id = UUID.randomUUID();
    }

    public Ticket(String city, float price, Date date, IssuingInstitution issuingInstitution) {
        this.id = UUID.randomUUID();
        this.city = city;
        this.price = price;
        this.date = date;
        this.issuingInstitution = issuingInstitution;
    }

    public UUID getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public IssuingInstitution getIssuingInstitution() {
        return issuingInstitution;
    }

    public void setIssuingInstitution(IssuingInstitution issuingInstitution) {
        this.issuingInstitution = issuingInstitution;
    }

    public abstract void ticketDetails();

    public abstract boolean isAvailable();

    @Override
    public String toString() {
        return "Serie: " + id +
                ", city: " + city +
                ", price: " + price +
                ", date: " + date +
                ", Emisa de: " + issuingInstitution;
    }
}
