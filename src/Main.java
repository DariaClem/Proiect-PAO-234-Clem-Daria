import Configuration.DatabaseConfiguration;
import Model.*;
import Repositories.ExhibitRepository;
import Repositories.ExhibitionRepository;
import Repositories.MuseumRepository;
import Repositories.UserRepository;
import Service.Impl.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        ExhibitServiceImpl exhibitsServiceImpl = new ExhibitServiceImpl();
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

        UserRepository userRepository = new UserRepository(databaseConfiguration);
        MuseumRepository museumRepository = new MuseumRepository(databaseConfiguration);
        ExhibitionRepository exhibitionRepository = new ExhibitionRepository(databaseConfiguration);
        ExhibitRepository exhibitRepository = new ExhibitRepository(databaseConfiguration);

        UserServiceDBImpl userServiceDB = new UserServiceDBImpl(userRepository);
        MuseumServiceDBImpl museumServiceDB = new MuseumServiceDBImpl(museumRepository);
        ExhibitionServiceDBImpl exhibitionServiceDB = new ExhibitionServiceDBImpl(exhibitionRepository);
        ExhibitServiceDBImpl exhibitServiceDB = new ExhibitServiceDBImpl(exhibitRepository);

        System.out.println(userServiceDB.getAllUsers());
        System.out.println(museumServiceDB.getAllMuseums());
        System.out.println(exhibitionServiceDB.getAllExhibitions());
        System.out.println(exhibitServiceDB.getAllExhibits());
        System.out.println();

        System.out.println(userServiceDB.getUser(10));
        System.out.println(museumServiceDB.getMuseum(4));
        System.out.println(exhibitionServiceDB.getExhibition(28));
        System.out.println(exhibitServiceDB.getExhibit(50));
        System.out.println();

        System.out.println(userServiceDB.getUser(209));
        System.out.println(museumServiceDB.getMuseum(309));
        System.out.println(exhibitionServiceDB.getExhibition(40));
        System.out.println(exhibitServiceDB.getExhibit(70));
        System.out.println();

        System.out.println(userServiceDB.getUser("Clem", "Daria"));
        System.out.println(museumServiceDB.getMuseum("Muzeul National de Arta al Romaniei"));
        System.out.println(exhibitionServiceDB.getExhibition("Expoziția 'Epoca medievală și arta cavalerilor'"));
        System.out.println(exhibitServiceDB.getExhibit("Statuia lui Venus"));
        System.out.println();

        System.out.println(exhibitServiceDB.getExhibitByExhibitionId(31));

        /*userServiceDB.addUser("Anghel", "Luminița", "9876543210000", "București");
        museumServiceDB.addMuseum("Muzeul apei", "Fălticeni");

        String dateString1 = "2022-02-10 15:30:00";
        String dateString2 = "2025-06-16 18:30:00";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(dateString1, formatter);
        LocalDateTime dateTime2 = LocalDateTime.parse(dateString2, formatter);

        exhibitionServiceDB.addExhibition("Adâncurile Mării Negre", date1, date2, 7);
        exhibitServiceDB.addExhibit("Fosilă", "Fosilă descoperită pe fundul Mării Negre", "România", "12000 de ani î.Hr.", 37);

        userServiceDB.editUser("id", "26", "id", "28");
        */

        String dateString1 = "2022-02-12 19:30:00";

        //exhibitionServiceDB.editExhibition("startDate", dateString1, "id", "43");
        /*exhibitionServiceDB.editExhibition("name", "Marea Neagră", "startDate", date1.toString());
        exhibitServiceDB.editExhibit("description", "Fosilă neidentificată", "name", "Fosilă");

        System.out.println(userServiceDB.getAllUsers());
        System.out.println(museumServiceDB.getAllMuseums());
        System.out.println(exhibitionServiceDB.getAllExhibitions());
        System.out.println(exhibitServiceDB.getAllExhibits());
        System.out.println();

        userServiceDB.deleteUser(20);
        museumServiceDB.deleteMuseum(8);
        exhibitionServiceDB.deleteExhibition(37);
        exhibitServiceDB.deleteExhibit(57);

        System.out.println(userServiceDB.getAllUsers());
        System.out.println(museumServiceDB.getAllMuseums());
        System.out.println(exhibitionServiceDB.getAllExhibitions());
        System.out.println(exhibitServiceDB.getAllExhibits());
        System.out.println();

        museumRepository.deleteAllMuseums();
        System.out.println(museumServiceDB.getAllMuseums());
        System.out.println(exhibitionServiceDB.getAllExhibitions());
        System.out.println(exhibitServiceDB.getAllExhibits());
        System.out.println();*/
    }
}