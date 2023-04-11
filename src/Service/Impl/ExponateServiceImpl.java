package Service.Impl;

import Exceptii.NuSuntExponateException;
import Model.Exponat;
import Service.ExponateService;

import java.util.ArrayList;
import java.util.List;

public class ExponateServiceImpl implements ExponateService {
    List<Exponat> exponate;

    @Override
    public void addExponat(Exponat exponat) throws Exception {
        if (exponate == null)
            exponate = new ArrayList<>();
        exponate.add(exponat);
    }

    @Override
    public List<Exponat> getExponat() throws Exception {
        try {
            if (exponate == null)
                throw new NuSuntExponateException("Lista de exponate este goala.");
        } catch (NuSuntExponateException exceptie) {
            System.out.println(exceptie.getMessage());
        }
        return exponate;
    }
}
