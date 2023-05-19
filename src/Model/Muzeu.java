package Model;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Muzeu {
    private int id;
    private String denumire;
    private String adresa;
    private Set<Expozitie> expozitii;

    public Muzeu() {
    }

    public Muzeu(int id, String denumire, String adresa) {
        this.id = id;
        this.denumire = denumire;
        this.adresa = adresa;
        this.expozitii = new HashSet<>();
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Set<Expozitie> getExpozitii() {
        return expozitii;
    }

    public void setExpozitii(Set<Expozitie> expozitii) {
        this.expozitii = expozitii;
    }

    public void addExpozitie(Expozitie expozitie) {
        this.expozitii.add(expozitie);
    }

    @Override
    public String toString() {
        return "Muzeu{" +
                "id=" + id + '\'' +
                "denumire='" + denumire + '\'' +
                ", adresa='" + adresa + '\'' +
                ", expozitii=" + expozitii +
                '}';
    }
}
