package Service.Impl;

import Exceptii.NuEsteExponatulException;
import Exceptii.NuEsteUtilizatorulException;
import Exceptii.NuSuntExponateException;
import Exceptii.NuSuntUtilizatoriException;
import Model.Exponat;
import Model.Utilizator;
import Service.ExponateService;
import Utile.AuditSingleton;

import java.util.ArrayList;
import java.util.List;

public class ExponateServiceImpl implements ExponateService {
    List<Exponat> exponate;

    @Override
    public void addExponat(Exponat exponat) throws Exception {
        if (exponate == null)
            exponate = new ArrayList<>();
        exponate.add(exponat);
        AuditSingleton.INSTANCE.writeAction("Adaugare exponat");
    }

    @Override
    public List<Exponat> getExponate() throws Exception {
        try {
            if (exponate == null)
                throw new NuSuntExponateException("Lista de exponate este goala.");
        } catch (NuSuntExponateException exceptie) {
            System.out.println(exceptie.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get exponat");
        return exponate;
    }

    @Override
    public Exponat getExponat(int id) throws Exception {
        Exponat exponatGasit = new Exponat();
        boolean gasit = false;
        try {
            if (exponate == null) {
                throw new NuSuntExponateException("Lista de exponate este goala");
            }
            for (Exponat exponat : exponate) {
                if (id == exponat.getId()) {
                    exponatGasit = exponat;
                    gasit = true;
                }
            }
            if (!gasit) {
                throw new NuEsteExponatulException("Exponatul cautat nu a fost gasit");
            }
        } catch (NuSuntExponateException | NuEsteExponatulException exceptie) {
            System.out.println(exceptie.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get exponat după id");
        return exponatGasit;
    }
}
