package Model;

import java.util.HashSet;
import java.util.Set;

public class Museum {
    private int id;
    private String name;
    private String address;
    private Set<Exhibition> exhibitions;

    public Museum() {
    }

    public Museum(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.exhibitions = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Exhibition> getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(Set<Exhibition> exhibitions) {
        this.exhibitions = exhibitions;
    }

    public void addExhibition(Exhibition exhibition) {
        this.exhibitions.add(exhibition);
    }

    @Override
    public String toString() {
        return "Museum{" +
                "id=" + id + '\'' +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", exhibitions=" + exhibitions +
                '}';
    }
}
