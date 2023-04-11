package Model;

import Utile.TipTransport;

import java.util.List;

public class MijlocDeTransport {
    private TipTransport tipTransport;
    private String numarInmatriculare;
    private int numarRuta;
    private List<String> ruta;
    private int oraInceput;
    private int oraSfarsit;
    private boolean accesibilitate;

    public MijlocDeTransport() {
    }

    public MijlocDeTransport(TipTransport tipTransport, String numarInmatriculare, int numarRuta, List<String> ruta, int oraInceput, int oraSfarsit, boolean accesibilitate) {
        this.tipTransport = tipTransport;
        this.numarInmatriculare = numarInmatriculare;
        this.numarRuta = numarRuta;
        this.ruta = ruta;
        this.oraInceput = oraInceput;
        this.oraSfarsit = oraSfarsit;
        this.accesibilitate = accesibilitate;
    }

    public TipTransport getTipTransport() {
        return tipTransport;
    }

    public void setTipTransport(TipTransport tipTransport) {
        this.tipTransport = tipTransport;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public void setNumarInmatriculare(String numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public int getNumarRuta() {
        return numarRuta;
    }

    public void setNumarRuta(int numarRuta) {
        this.numarRuta = numarRuta;
    }

    public List<String> getRuta() {
        return ruta;
    }

    public void setRuta(List<String> ruta) {
        this.ruta = ruta;
    }

    public int getOraInceput() {
        return oraInceput;
    }

    public void setOraInceput(int oraInceput) {
        this.oraInceput = oraInceput;
    }

    public int getOraSfarsit() {
        return oraSfarsit;
    }

    public void setOraSfarsit(int oraSfarsit) {
        this.oraSfarsit = oraSfarsit;
    }

    public boolean isAccesibilitate() {
        return accesibilitate;
    }

    public void setAccesibilitate(boolean accesibilitate) {
        this.accesibilitate = accesibilitate;
    }

    @Override
    public String toString() {
        return "Autobuz{" +
                "numarInmatriculare='" + numarInmatriculare + '\'' +
                ", numarRuta=" + numarRuta +
                ", ruta=" + ruta +
                ", oraInceput=" + oraInceput +
                ", oraSfarsit=" + oraSfarsit +
                ", accesibilitate=" + accesibilitate +
                '}';
    }
}
