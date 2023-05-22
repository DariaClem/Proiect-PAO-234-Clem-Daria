import Configuration.DatabaseConfiguration;

import Repositories.ExhibitRepository;
import Repositories.ExhibitionRepository;
import Repositories.MuseumRepository;
import Repositories.UserRepository;
import Service.Impl.*;

import java.text.SimpleDateFormat;

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

        System.out.println(userServiceDB.getUser(1));
        System.out.println(museumServiceDB.getMuseum(2));
        System.out.println(exhibitionServiceDB.getExhibition(3));
        System.out.println(exhibitServiceDB.getExhibit(4));
        System.out.println();

        System.out.println(userServiceDB.getUser(209));
        System.out.println(museumServiceDB.getMuseum(309));
        System.out.println(exhibitionServiceDB.getExhibition(40));
        System.out.println(exhibitServiceDB.getExhibit(70));
        System.out.println();

        System.out.println(userServiceDB.getUser("Cleeem", "Daria"));
        System.out.println(museumServiceDB.getMuseum("Muzeul Național de Artă al României"));
        System.out.println(exhibitionServiceDB.getExhibition("Expoziția 'Epoca medievală și arta cavalerilor'"));
        System.out.println(exhibitServiceDB.getExhibit("Statuia lui Venus"));
        System.out.println();

        System.out.println(exhibitServiceDB.getExhibitByExhibitionId(6));
        System.out.println(exhibitionServiceDB.getExhibitionByMuseumId(2));

        userServiceDB.addUser("Anghel", "Luminița", "9876543210000", "București");
        museumServiceDB.addMuseum("Muzeul apei", "Fălticeni");

        String dateString1 = "2022-02-10";
        String dateString2 = "2025-06-16";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate1 = formatter.parse(dateString1);
        java.util.Date utilDate2 = formatter.parse(dateString2);

        java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
        java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());

        exhibitionServiceDB.addExhibition("Adâncurile Mării Negre", sqlDate1, sqlDate2, 4);
        exhibitServiceDB.addExhibit("Fosilă", "Fosilă descoperită pe fundul Mării Negre", "România", "12000 de ani î.Hr.", 10);

        userServiceDB.editUser("id", "11", "id", "10");

        dateString1 = "2022-02-12";

        exhibitionServiceDB.editExhibition("startDate", dateString1, "id", "10");
        exhibitionServiceDB.editExhibition("name", "Marea Neagră", "startDate", dateString1);
        exhibitServiceDB.editExhibit("description", "Fosilă neidentificată", "name", "Fosilă");

        System.out.println(userServiceDB.getAllUsers());
        System.out.println(museumServiceDB.getAllMuseums());
        System.out.println(exhibitionServiceDB.getAllExhibitions());
        System.out.println(exhibitServiceDB.getAllExhibits());
        System.out.println();

        userServiceDB.deleteUser(11);
        museumServiceDB.deleteMuseum(4);
        exhibitionServiceDB.deleteExhibition(10);
        exhibitServiceDB.deleteExhibit(28);

        System.out.println(userServiceDB.getAllUsers());
        System.out.println(museumServiceDB.getAllMuseums());
        System.out.println(exhibitionServiceDB.getAllExhibitions());
        System.out.println(exhibitServiceDB.getAllExhibits());
        System.out.println();

        museumRepository.deleteAllMuseums();
        System.out.println(museumServiceDB.getAllMuseums());
        System.out.println(exhibitionServiceDB.getAllExhibitions());
        System.out.println(exhibitServiceDB.getAllExhibits());
        System.out.println();
    }
}