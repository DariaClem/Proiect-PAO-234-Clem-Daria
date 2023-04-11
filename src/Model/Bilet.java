package Model;

import Utile.InstitutiiEmitere;

import java.rmi.server.UID;
import java.util.Date;
import java.util.UUID;

public abstract class Bilet {
    private final UUID id;
    private String oras;
    private float pret;
    private Date data;
    private InstitutiiEmitere institutieEmitere;

    public Bilet() {
        this.id = UUID.randomUUID();
    }

    public Bilet(String oras, float pret, Date data, InstitutiiEmitere institutieEmitere) {
        this.id = UUID.randomUUID();
        this.oras = oras;
        this.pret = pret;
        this.data = data;
        this.institutieEmitere = institutieEmitere;
    }

    public UUID getId() {
        return id;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public InstitutiiEmitere getInstitutieEmitere() {
        return institutieEmitere;
    }

    public void setInstitutieEmitere(InstitutiiEmitere institutieEmitere) {
        this.institutieEmitere = institutieEmitere;
    }

    public abstract void detaliiBilet();

    public abstract boolean esteValabil();

    @Override
    public String toString() {
        return "Serie: " + id +
                ", Oras: " + oras +
                ", Pret: " + pret +
                ", Data: " + data +
                ", Emisa de: " + institutieEmitere;
    }
}
