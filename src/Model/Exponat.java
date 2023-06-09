package Model;

import java.util.Date;

public class Exponat {
    private String denumire;
    private String descriere;
    private String taraOrigine;
    private String dataOrigine;

    public Exponat() {
    }

    public Exponat(String denumire, String descriere, String taraOrigine, String dataOrigine) {
        this.denumire = denumire;
        this.descriere = descriere;
        this.taraOrigine = taraOrigine;
        this.dataOrigine = dataOrigine;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getTaraOrigine() {
        return taraOrigine;
    }

    public void setTaraOrigine(String taraOrigine) {
        this.taraOrigine = taraOrigine;
    }

    public String getDataOrigine() {
        return dataOrigine;
    }

    public void setDataOrigine(String dataOrigine) {
        this.dataOrigine = dataOrigine;
    }

    @Override
    public String toString() {
        return "Exponat{" +
                "denumire='" + denumire + '\'' +
                ", descriere='" + descriere + '\'' +
                ", taraOrigine='" + taraOrigine + '\'' +
                ", dataOrigine=" + dataOrigine +
                '}';
    }
}
