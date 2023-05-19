package Service.Impl;

import Exceptions.InvalidExhibitionNumberException;
import Exceptions.MuseumNotFoundException;
import Exceptions.MuseumsNotFoundException;
import Model.Museum;
import Service.MuseumService;
import Utils.AuditSingleton;

import java.util.ArrayList;
import java.util.List;

import static Validations.MuseumValidation.exhibitionsValidation;

public class MuseumServiceImpl implements MuseumService {
    List<Museum> museums;

    @Override
    public void addMuseum(Museum museum) throws Exception {
        boolean validMuseum = true;
        try {
            if (!exhibitionsValidation(museum.getExhibitions()))
                throw new InvalidExhibitionNumberException("The number of exhibitions cannot be 0.");
        } catch (InvalidExhibitionNumberException exception) {
            validMuseum = false;
            System.out.println(exception.getMessage());
        }

        if (validMuseum) {
            if (museums == null)
                museums = new ArrayList<>();
            museums.add(museum);
            AuditSingleton.INSTANCE.writeAction("Add museum");
        }
    }

    @Override
    public void addMuseum(String[] museum) throws Exception {
        boolean validMuseum = true;

        int id = Integer.parseInt(museum[0]);
        String name = museum[1];
        String address = museum[2];

        if (museums == null)
            museums = new ArrayList<>();
        museums.add(new Museum(id, name, address));
        AuditSingleton.INSTANCE.writeAction("Add museum");

    }

    @Override
    public List<Museum> getMuseums() throws Exception {
        try {
            if (museums == null)
                throw new MuseumsNotFoundException("The number of museums cannot be 0");
        } catch (MuseumsNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get museums");
        return museums;
    }

    @Override
    public Museum getMuseum(int id) throws Exception {
        Museum foundMuseum = new Museum();
        boolean found = false;
        try {
            if (museums == null) {
                throw new MuseumsNotFoundException("The number of museums cannot be 0.");
            }
            for (Museum museum : museums) {
                if (id == museum.getId()) {
                    foundMuseum = museum;
                    found = true;
                }
            }
            if (!found) {
                throw new MuseumNotFoundException("The museum does not exist.");
            }
        } catch (MuseumsNotFoundException | MuseumNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get museum by id");
        return foundMuseum;
    }
}
