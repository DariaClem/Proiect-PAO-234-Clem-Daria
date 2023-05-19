package Service.Impl;

import Exceptions.InvalidExhibitionNumberException;
import Exceptions.ExhibitionNotFoundException;
import Exceptions.ExhibitionsNotFoundException;
import Model.Exhibition;
import Service.ExhibitionService;
import Utils.AuditSingleton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static Validations.ExhibitionValidation.exhibitsValidation;

public class ExhibitionServiceImpl implements ExhibitionService {
    Set<Exhibition> exhibitions;

    @Override
    public void addExhibition(Exhibition exhibition) throws Exception {
        boolean validExhibition = true;
        try {
            if (!exhibitsValidation(exhibition.getExhibits()))
                throw new InvalidExhibitionNumberException("Exhibitions number cannot be empty");
        } catch (InvalidExhibitionNumberException exception) {
            validExhibition = false;
            System.out.println(exception.getMessage());
        }

        if (validExhibition) {
            if (exhibitions == null)
                exhibitions = new HashSet<>();
            exhibitions.add(exhibition);
            AuditSingleton.INSTANCE.writeAction("Add exhibition");
        }
    }

    @Override
    public void addExhibition(String[] exhibition) throws Exception {
        boolean validExhibition = true;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int id = Integer.parseInt(exhibition[0]);
        String name = exhibition[1];
        Date startDate = dateFormat.parse(exhibition[2]);
        Date endDate = dateFormat.parse(exhibition[3]);
        int museumId = Integer.parseInt(exhibition[4]);

        if (exhibitions == null)
            exhibitions = new HashSet<>();
        exhibitions.add(new Exhibition(id, name, startDate, endDate, museumId));
        AuditSingleton.INSTANCE.writeAction("Add exhibition");

    }

    @Override
    public Set<Exhibition> getExhibitions() throws Exception {
        try {
            if (exhibitions == null)
                throw new ExhibitionsNotFoundException("Exhibitions list cannot be empty.");
        } catch (ExhibitionsNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get exhibition");
        return exhibitions;
    }

    @Override
    public Exhibition getExhibition(int id) throws Exception {
        Exhibition foundExhibition = new Exhibition();
        boolean found = false;
        try {
            if (exhibitions == null) {
                throw new ExhibitionsNotFoundException("Exhibitions list cannot be empty.");
            }
            for (Exhibition exhibition : exhibitions) {
                if (id == exhibition.getId()) {
                    foundExhibition = exhibition;
                    found = true;
                }
            }
            if (!found) {
                throw new ExhibitionNotFoundException("the wanted exhibition was not found.");
            }
        } catch (ExhibitionsNotFoundException | ExhibitionNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get exhibition by id");
        return foundExhibition;
    }
}
