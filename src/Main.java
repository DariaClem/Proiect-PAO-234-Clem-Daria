import Model.*;
import Service.Impl.*;
import Utile.InstitutiiEmitere;
import Utile.TipTransport;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Service-uri
        ExponateServiceImpl exponateService1 = new ExponateServiceImpl();
        ExponateServiceImpl exponateService2 = new ExponateServiceImpl();
        ExpozitieServiceImpl expozitieService = new ExpozitieServiceImpl();
        MuzeuServiceImpl muzeuService = new MuzeuServiceImpl();
        UtilizatorServiceImpl utilizatorService = new UtilizatorServiceImpl();
        MijlocDeTransportServiceImpl mijlocDeTransportService = new MijlocDeTransportServiceImpl();
        BiletServiceImpl biletService = new BiletServiceImpl();

        // Exponate corespunzatoare primei expozitii
        Exponat exponatVG1 = new Exponat("Mancatorii de cartofi", "Prima opera de succes a artistului Vincent Van Gogh", "Olanda", "1885");
        Exponat exponatVG2 = new Exponat("Noapte instelata", "Una dintre cele mai celebre picturi ale artistului Vincent Van Gogh", "Olanda", "1889");
        Exponat exponatMG = new Exponat("Sfanta Familie cu Sfantul Ioan Botezatorul", "O lucrare reprezentativa a pictorului Michelangelo Merisi da Caravaggio", "Italia", "1605");
        Exponat exponatPB = new Exponat("David", "Una dintre cele mai faimoase sculpturi realizate de artistul renascentist Michelangelo", "Italia", "1501");
        Exponat exponatPC = new Exponat("Cap de femeie", "O lucrare semnificativa a artistului Pablo Picasso", "Spania", "1909");

        exponateService1.addExponat(exponatVG1);
        exponateService1.addExponat(exponatVG2);
        exponateService1.addExponat(exponatMG);
        exponateService1.addExponat(exponatPB);
        exponateService1.addExponat(exponatPC);
        List<Exponat> exponate1 = exponateService1.getExponat();

        // Exponate corespunzatoare celei de-a doua expozitii
        Exponat exponatSD1 = new Exponat("Persistenta memoriei", "Cea mai faimoasa capodopera a artistului Salvador Dali", "Franta", "1931");
        Exponat exponatSD2 = new Exponat("Elefantii", "Pictura a artistului Salvador Dali", "1948", "Statele Unite ale Americii");
        Exponat exponatRM = new Exponat("Rugaciunea dupa masa", "Un tablou celebru realizat de artistul Rembrandt Harmenszoon van Rijn", "Olanda", "1646");
        Exponat exponatLK = new Exponat("Mona Lisa", "Cea mai renumita pictura din lume realizata de Leonardo da Vinci", "Italia", "1503");

        exponateService2.addExponat(exponatSD1);
        exponateService2.addExponat(exponatSD2);
        exponateService2.addExponat(exponatRM);
        exponateService2.addExponat(exponatLK);
        List<Exponat> exponate2 = exponateService2.getExponat();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.MARCH, 25);
        Date dataInceput = calendar.getTime();

        calendar.set(2022, Calendar.APRIL, 4);
        Date dataFinal = calendar.getTime();

        // Prima expozitie corespunzatoare primului muzeu
        Expozitie expozitie1 = new Expozitie("Expozitie Inspiria", dataInceput, dataFinal, exponate1);

        calendar.set(2022, Calendar.FEBRUARY, 16);
        dataInceput = calendar.getTime();

        calendar.set(2022, Calendar.MAY, 20);
        dataFinal = calendar.getTime();

        // A doua expozitie corespunzatoare primului muzeu
        Expozitie expozitie2 = new Expozitie("Expozitie Clasics", dataInceput, dataFinal, exponate2);

        expozitieService.addExpozitie(expozitie1);
        expozitieService.addExpozitie(expozitie2);
        Set<Expozitie> expozitiiMuzeu1 = expozitieService.getExpozitie();

        // Primul muzeu
        Muzeu muzeu = new Muzeu("Muzeul National de Arta", "Calea Victoriei, Bucuresti", expozitiiMuzeu1);
        muzeuService.addMuzeu(muzeu);
        List<Muzeu> muzee = muzeuService.getMuzeu();

        Utilizator utilizator1 = new Utilizator("Clem", "Daria", "1002003004005", "Splaiul Independentei");
        Utilizator utilizator2 = new Utilizator("Clem", "Matei", "8002003004005", "Calea Victoriei");

        utilizatorService.addUtilizator(utilizator2);
        utilizatorService.addUtilizator(utilizator1);

        System.out.println(utilizatorService.getUtilizatori());

        // Se creeaza o ruta specifica unui autobuz
        List<String> ruta1 = new ArrayList<>();
        ruta1.add("Grozavesti");
        ruta1.add("Eroilor");
        ruta1.add("Cismigiu");
        ruta1.add("Universitate");

        MijlocDeTransport mijlocDeTransport = new MijlocDeTransport(TipTransport.AUTOBUZ, "B-101-STB", 201, ruta1, 6, 22, true);
        mijlocDeTransportService.addMijlocDeTransport(mijlocDeTransport);
        System.out.println(mijlocDeTransportService.getMijlocDeTransport());

        calendar.setTime(new Date());

        // Bilete de muzeu si de transport specifice unui utilizator
        BiletTransport biletT1 = new BiletTransport("Bucuresti", 3.50f, calendar.getTime(), InstitutiiEmitere.STB, TipTransport.AUTOBUZ, 90);
        BiletMuzeu biletM1 = new BiletMuzeu("Bucuresti", 12, calendar.getTime(), InstitutiiEmitere.DPCN, muzeu);
        biletService.addBilet(biletT1);
        biletService.addBilet(biletM1);
        List<Bilet> bilete1 = biletService.getBilet();

        // Se afiseaza detaliile biletelor si daca acestea mai sunt valabile, criteriu stabilit in functie de tipul biletului
        for (Bilet bilet : bilete1) {
            bilet.detaliiBilet();
            System.out.println(bilet.esteValabil() ? "Biletul este valid" : "Biletul a expirat");
        }

        // Se afiseaza pretul total al biletelor
        System.out.println(biletService.pretTotalBilete() + " lei");

        // Se configureaza lista de bilete a primului utilizator
        utilizator1.setBilete(bilete1);

        // Se afiseaza lista completa a utilizatorilor
        System.out.println(utilizatorService.getUtilizatori());

        // Se afiseaza utilizatorul cu numele si prenumele dat
        System.out.println(utilizatorService.getUtilizator("Clem", "Daria"));

        // Se incearca stergerea unui utilizator dupa numele si prenumele dat
        utilizatorService.deleteUtilizator("Clem", "Ferguson");
        System.out.println(utilizatorService.getUtilizatori());

        utilizatorService.addUtilizator(utilizator1);

        // Se incearca stergerea unui utilizator dupa obiectul dat
        utilizatorService.deleteUtilizator(utilizator2);
        System.out.println(utilizatorService.getUtilizatori());

    }
}