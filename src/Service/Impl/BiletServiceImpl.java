package Service.Impl;

import Exceptii.InvalidPretBiletException;
import Exceptii.NuSuntBileteException;
import Exceptii.NuSuntExponateException;
import Model.Bilet;
import Service.BiletService;
import Utile.AuditSingleton;

import java.util.ArrayList;
import java.util.List;

import static Validari.BiletValidare.validarePretBilet;

public class BiletServiceImpl implements BiletService {
    List<Bilet> bilete;

    @Override
    public void addBilet(Bilet bilet) throws Exception {
        boolean biletValid = true;

        try {
            if (!validarePretBilet(bilet.getPret())) {
                throw new InvalidPretBiletException("Biletul nu poate fi gratis.");
            }
        } catch (InvalidPretBiletException exceptie) {
            biletValid = false;
            System.out.println(exceptie.getMessage());
        }

        if (bilete == null)
            bilete = new ArrayList<>();
        bilete.add(bilet);
        AuditSingleton.INSTANCE.writeAction("Adaugare bilet");
    }

    @Override
    public List<Bilet> getBilet() throws Exception {
        try {
            if (bilete == null)
                throw new NuSuntBileteException("Lista de bilete este goala.");
        } catch (NuSuntBileteException exceptie) {
            System.out.println(exceptie.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get Bilet");
        return bilete;
    }

    @Override
    public float pretTotalBilete() throws Exception {
        float total = 0;
        try {
            if (bilete == null)
                throw new NuSuntBileteException("Nu se poate calcula pretul total al biletelor pentru o lista goala.");

            for (Bilet bilet : bilete) {
                total += bilet.getPret();
            }
        } catch (NuSuntBileteException exceptie) {
            System.out.println(exceptie.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Pret total bilete");
        return total;
    }
}
