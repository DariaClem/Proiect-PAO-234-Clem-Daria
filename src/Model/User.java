package Model;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User> {
    private int id;
    private String lastName;
    private String firstName;
    private String CNP;
    private String address;

    private List<Ticket> tickets;

    public User() {
    }

    public User(int id, String lastName, String firstName, String CNP, String address) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.CNP = CNP;
        this.address = address;
        this.tickets = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket bilet) {
        this.tickets.add(bilet);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", address='" + address + '\'' +
                ", tickets=" + tickets +
                '}';
    }

    @Override
    public int compareTo(User user) {
        if (lastName.compareTo(user.lastName) == 0)
            return firstName.compareTo(user.firstName);
        return lastName.compareTo(user.lastName);
    }
}
