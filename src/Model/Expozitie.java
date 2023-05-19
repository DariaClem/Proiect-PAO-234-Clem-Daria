package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Expozitie {
    private int id;
    private String denumire;
    private Date dataInceput;
    private Date dataFinal;
    private List<Exponat> exponate;

    public Expozitie() {
    }

    public Expozitie(int id, String denumire, Date dataInceput, Date dataFinal) {
        this.id = id;
        this.denumire = denumire;
        this.dataInceput = dataInceput;
        this.dataFinal = dataFinal;
        this.exponate = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Date getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(Date dataInceput) {
        this.dataInceput = dataInceput;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public List<Exponat> getExponate() {
        return exponate;
    }

    public void setExponate(List<Exponat> exponate) {
        this.exponate = exponate;
    }

    public void addExponate(Exponat exponat) {
        this.exponate.add(exponat);
    }

    @Override
    public String toString() {
        return "Expozitie{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", dataInceput=" + dataInceput +
                ", dataFinal=" + dataFinal +
                ", exponate=" + exponate +
                '}';
    }
}
