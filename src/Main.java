import Configuration.DatabaseConfiguration;
import Model.*;
import Service.Impl.*;
import Utils.FileManagementSingleton;

import java.util.*;

public class Main {
    /*
    public static void main(String[] args) throws Exception {
        // Inițializarea serviciului singleton care se ocupă de citirea și afișarea din și în fișiere
        FileManagementSingleton singleton = FileManagementSingleton.INSTANCE;

        // Denumirile fișierelor csv
        String userFile = "CSVFiles/users.csv";
        String museumFile = "CSVFiles/museums.csv";
        String exhibitionsFile = "CSVFiles/exhibitions.csv";
        String exhibitsFile = "CSVFiles/exhibits.csv";
        String outputFile = "CSVFiles/test.csv";

        // Citirea informațiilor despre utilizator
        List<String[]> content = singleton.readFromCsv(userFile);

        // Inițializarea serviciului pentru prelucrarea utilizatorilor
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        for (String[] user : content)
            userServiceImpl.addUser(user);

        // Citirea informațiilor despre muzee
        content = singleton.readFromCsv(museumFile);

        // Inițializarea serviciului pentru prelucrarea muzeelor
        MuseumServiceImpl museumServiceImpl = new MuseumServiceImpl();
        for (String[] museum : content)
            museumServiceImpl.addMuseum(museum);

        // Citirea informațiilor despre expoziții
        content = singleton.readFromCsv(exhibitionsFile);

        // Inițializarea serviciului pentru prelucrarea expozițiilor
        ExhibitionServiceImpl exhibitionServiceImpl = new ExhibitionServiceImpl();
        for (String[] exhibition : content)
            exhibitionServiceImpl.addExhibition(exhibition);

        // Citirea informațiilor despre exponate
        content = singleton.readFromCsv(exhibitsFile);

        // Inițializarea serviciului pentru prelucrarea exponatelor
        ExhibitsServiceImpl exhibitsServiceImpl = new ExhibitsServiceImpl();
        for (String[] exhibit : content) {
            exhibitsServiceImpl.addExhibit(exhibit);
        }

        // Adăugarea exponatelor în lista de exponate corespunzătoare fiecărei expoziții
        for (Exhibit exhibit : exhibitsServiceImpl.getExhibits()) {
            Exhibition exhibition = exhibitionServiceImpl.getExhibition(exhibit.getExhibitionId());
            exhibition.addExhibit(exhibit);
        }

        // Adăugarea expozițiilor în lista de expoziții corespunzătoare fiecărui muzeu
        for (Exhibition exhibition : exhibitionServiceImpl.getExhibitions()) {
            Museum museum = museumServiceImpl.getMuseum(exhibition.getMuseumId());
            museum.addExhibition(exhibition);
        }

        // Scrierea in fișiere a informațiilor prelucrate anterior
        singleton.writeInCsv(outputFile, userServiceImpl.getUsers().toString());
        singleton.writeInCsv(outputFile, exhibitsServiceImpl.getExhibits().toString());
        singleton.writeInCsv(outputFile, exhibitionServiceImpl.getExhibitions().toString());
        singleton.writeInCsv(outputFile, museumServiceImpl.getMuseums().toString());
    }
     */
    public static void main(String[] args) throws Exception {
        DatabaseConfiguration databaseConfiguration = DatabaseConfiguration.INSTANCE;

    }
}