package Model;

import Utile.InstitutiiEmitere;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BiletMuzeu extends Bilet {
    private int idMuzeu;

    public BiletMuzeu() {
    }

    public BiletMuzeu(String oras, float pret, Date data, InstitutiiEmitere institutieEmitere, int idMuzeu) {
        super(oras, pret, data, institutieEmitere);
        this.idMuzeu = idMuzeu;
    }

    public int getIdMuzeu() {
        return idMuzeu;
    }

    public void setIdMuzeu(int idMuzeu) {
        this.idMuzeu = idMuzeu;
    }

    public boolean esteValabil() {
        Date dataCurenta = new Date();
        long diff = TimeUnit.DAYS.convert((dataCurenta.getTime() - super.getData().getTime()), TimeUnit.DAYS);
        return diff <= 1;
    }

    @Override
    public void detaliiBilet() {
        System.out.println("Bilet pentru muzeul cu id-ul: " + idMuzeu + ", " + super.toString());
    }
}
