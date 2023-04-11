package Model;

import Utile.InstitutiiEmitere;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BiletMuzeu extends Bilet {
    private Muzeu muzeu;

    public BiletMuzeu() {
    }

    public BiletMuzeu(String oras, float pret, Date data, InstitutiiEmitere institutieEmitere, Muzeu muzeu) {
        super(oras, pret, data, institutieEmitere);
        this.muzeu = muzeu;
    }

    public Muzeu getMuzeu() {
        return muzeu;
    }

    public void setMuzeu(Muzeu muzeu) {
        this.muzeu = muzeu;
    }

    public boolean esteValabil() {
        Date dataCurenta = new Date();
        long diff = TimeUnit.DAYS.convert((dataCurenta.getTime() - super.getData().getTime()), TimeUnit.DAYS);
        return diff <= 1;
    }

    @Override
    public void detaliiBilet() {
        System.out.println("Bilet pentru muzeul: " + muzeu + ", " + super.toString());
    }
}
