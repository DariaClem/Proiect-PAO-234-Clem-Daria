package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exhibition {
    private int id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int museumId;
    private List<Exhibit> exhibits;

    public Exhibition() {
    }

    public Exhibition(int id, String name, Date startDate, Date endDate, int museumId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.museumId = museumId;
        this.exhibits = new ArrayList<>();
    }

    public int getMuseumId() {
        return museumId;
    }

    public void setMuseumId(int museumId) {
        this.museumId = museumId;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Exhibit> getExhibits() {
        return exhibits;
    }

    public void setExhibits(List<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }

    public void addExhibit(Exhibit exponat) {
        this.exhibits.add(exponat);
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", museumId=" + museumId +
                ", exhibits=" + exhibits +
                '}';
    }
}
