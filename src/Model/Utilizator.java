package Model;

import java.util.List;
import java.util.Objects;

public class Utilizator implements Comparable<Utilizator> {
    private String nume;
    private String prenume;
    private String CNP;
    private String adresa;

    private List<Bilet> bilete;

    public Utilizator() {
    }

    public Utilizator(String nume, String prenume, String CNP, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.adresa = adresa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Bilet> getBilete() {
        return bilete;
    }

    public void setBilete(List<Bilet> bilete) {
        this.bilete = bilete;
    }

    public void addBilet(Bilet bilet) {
        this.bilete.add(bilet);
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", adresa='" + adresa + '\'' +
                ", bilete=" + bilete +
                '}';
    }

    @Override
    public int compareTo(Utilizator user) {
        if (nume.compareTo(user.nume) == 0)
            return prenume.compareTo(user.prenume);
        return nume.compareTo(user.nume);
    }
}
