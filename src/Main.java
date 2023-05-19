import Model.*;
import Service.Impl.*;
import Utile.GestionareFisiereSingleton;
import Utile.InstitutiiEmitere;
import Utile.TipTransport;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        GestionareFisiereSingleton singleton = GestionareFisiereSingleton.INSTANCE;

        String utilizatorFile = "fisiereCSV/utilizatori.csv";
        String muzeuFile = "fisiereCSV/muzee.csv";
        String expozitiiFile = "fisiereCSV/expozitii.csv";
        String exponateFile = "fisiereCSV/exponate.csv";
        String outputFile = "fisiereCSV/test.csv";

        List<String[]> content = singleton.readFromCsv(utilizatorFile);

        UtilizatorServiceImpl utilizatorServiceImpl = new UtilizatorServiceImpl();
        for (String[] utilizator : content)
            utilizatorServiceImpl.addUtilizator(utilizator);

        content = singleton.readFromCsv(muzeuFile);

        MuzeuServiceImpl muzeuServiceImpl = new MuzeuServiceImpl();
        for (String[] muzeu : content)
            muzeuServiceImpl.addMuzeu(muzeu);

        content = singleton.readFromCsv(expozitiiFile);

        ExpozitieServiceImpl expozitieServiceImpl = new ExpozitieServiceImpl();
        for (String[] expozitie : content)
            expozitieServiceImpl.addExpozitie(expozitie);

        content = singleton.readFromCsv(exponateFile);

        ExponateServiceImpl exponateServiceImpl = new ExponateServiceImpl();
        for (String[] exponat : content) {
            exponateServiceImpl.addExponat(exponat);
        }

        for (Exponat exponat : exponateServiceImpl.getExponate()) {
            Expozitie expozitie = expozitieServiceImpl.getExpozitie(exponat.getIdExpozitie());
            expozitie.addExponat(exponat);
        }

        for (Expozitie expozitie : expozitieServiceImpl.getExpozitii()) {
            Muzeu muzeu = muzeuServiceImpl.getMuzeu(expozitie.getIdMuzeu());
            muzeu.addExpozitie(expozitie);
        }

        singleton.writeInCsv(outputFile, utilizatorServiceImpl.getUtilizatori().toString());
        singleton.writeInCsv(outputFile, exponateServiceImpl.getExponate().toString());
        singleton.writeInCsv(outputFile, expozitieServiceImpl.getExpozitii().toString());
        singleton.writeInCsv(outputFile, muzeuServiceImpl.getMuzee().toString());
    }
}