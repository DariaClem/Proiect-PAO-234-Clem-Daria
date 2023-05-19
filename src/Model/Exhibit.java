package Model;

public class Exhibit {
    private int id;
    private String name;
    private String description;
    private String originCountry;
    private String originDate;
    private int exhibitionId;

    public Exhibit() {
    }

    public Exhibit(int id, String name, String description, String originCountry, String originDate, int exhibitionId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.originCountry = originCountry;
        this.originDate = originDate;
        this.exhibitionId = exhibitionId;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginDate() {
        return originDate;
    }

    public void setOriginDate(String originDate) {
        this.originDate = originDate;
    }

    @Override
    public String toString() {
        return "Exhibit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", originDate='" + originDate + '\'' +
                ", exhibitionId=" + exhibitionId +
                '}';
    }
}
