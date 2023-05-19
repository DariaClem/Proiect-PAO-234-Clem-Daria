import Model.*;
import Service.Impl.*;
import Utile.GestionareFisiereSingleton;
import Utile.InstitutiiEmitere;
import Utile.TipTransport;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Initializarea serviciului singleton care se ocupa de citirea si afisarea din si in fisiere
        GestionareFisiereSingleton singleton = GestionareFisiereSingleton.INSTANCE;

        // Denumirile fisierelor csv
        String utilizatorFile = "fisiereCSV/utilizatori.csv";
        String muzeuFile = "fisiereCSV/muzee.csv";
        String expozitiiFile = "fisiereCSV/expozitii.csv";
        String exponateFile = "fisiereCSV/exponate.csv";
        String outputFile = "fisiereCSV/test.csv";

        // Citirea informatiilor despre utilizator
        List<String[]> content = singleton.readFromCsv(utilizatorFile);

        // Initializarea serviciului pentru prelucrarea utilizatorilor
        UtilizatorServiceImpl utilizatorServiceImpl = new UtilizatorServiceImpl();
        for (String[] utilizator : content)
            utilizatorServiceImpl.addUtilizator(utilizator);

        // Citirea informatiilor despre muzee
        content = singleton.readFromCsv(muzeuFile);

        // Initializarea serviciului pentru prelucrarea muzeelor
        MuzeuServiceImpl muzeuServiceImpl = new MuzeuServiceImpl();
        for (String[] muzeu : content)
            muzeuServiceImpl.addMuzeu(muzeu);

        // Citirea informatiilor despre expozitii
        content = singleton.readFromCsv(expozitiiFile);

        // Initializarea serviciului pentru prelucrarea expozitiilor
        ExpozitieServiceImpl expozitieServiceImpl = new ExpozitieServiceImpl();
        for (String[] expozitie : content)
            expozitieServiceImpl.addExpozitie(expozitie);

        // Citirea informatiilor despre exponate
        content = singleton.readFromCsv(exponateFile);

        // Initializarea serviciului pentru prelucrarea exponatelor
        ExponateServiceImpl exponateServiceImpl = new ExponateServiceImpl();
        for (String[] exponat : content) {
            exponateServiceImpl.addExponat(exponat);
        }

        // Adaugarea exponatelor in lista de exponate corespunzatoare fiecarei expozitii
        for (Exponat exponat : exponateServiceImpl.getExponate()) {
            Expozitie expozitie = expozitieServiceImpl.getExpozitie(exponat.getIdExpozitie());
            expozitie.addExponat(exponat);
        }

        // Adaugarea expozitiilor in lista de expozitii corespunzatoare fiecarui muzeu
        for (Expozitie expozitie : expozitieServiceImpl.getExpozitii()) {
            Muzeu muzeu = muzeuServiceImpl.getMuzeu(expozitie.getIdMuzeu());
            muzeu.addExpozitie(expozitie);
        }

        // Scrierea in fisier a informatiilor prelucrate anterior
        singleton.writeInCsv(outputFile, utilizatorServiceImpl.getUtilizatori().toString());
        singleton.writeInCsv(outputFile, exponateServiceImpl.getExponate().toString());
        singleton.writeInCsv(outputFile, expozitieServiceImpl.getExpozitii().toString());
        singleton.writeInCsv(outputFile, muzeuServiceImpl.getMuzee().toString());
    }
}