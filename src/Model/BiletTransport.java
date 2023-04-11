package Model;

import Utile.InstitutiiEmitere;
import Utile.TipTransport;

import java.util.Date;

public class BiletTransport extends Bilet {
    private TipTransport mijlocDeTransport;
    private int valabilitate;

    public BiletTransport() {
    }

    public BiletTransport(String oras, float pret, Date data, InstitutiiEmitere institutieEmitere, TipTransport mijlocDeTransport, int valabilitate) {
        super(oras, pret, data, institutieEmitere);
        this.mijlocDeTransport = mijlocDeTransport;
        this.valabilitate = valabilitate;
    }

    public TipTransport getMijlocDeTransport() {
        return mijlocDeTransport;
    }

    public void setMijlocDeTransport(TipTransport mijlocDeTransport) {
        this.mijlocDeTransport = mijlocDeTransport;
    }

    public int getValabilitate() {
        return valabilitate;
    }

    public void setValabilitate(int valabilitate) {
        this.valabilitate = valabilitate;
    }

    public boolean esteValabil() {
        Date dataCurenta = new Date();
        return (dataCurenta.getTime() - super.getData().getTime()) / (60 * 1000) <= 90;
    }

    @Override
    public void detaliiBilet() {
        System.out.println("Bilet pentru: " + mijlocDeTransport + ", " + super.toString() + ", Valabilitate: " + valabilitate);
    }

    @Override
    public String toString() {
        return "BiletTransport{" +
                "mijlocDeTransport='" + mijlocDeTransport + '\'' +
                ", valabilitate=" + valabilitate +
                '}';
    }
}
