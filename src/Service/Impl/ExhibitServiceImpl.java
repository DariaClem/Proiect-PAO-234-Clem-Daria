package Service.Impl;

import Exceptions.ExhibitNotFoundException;
import Exceptions.ExhibitsNotFoundException;
import Model.Exhibit;
import Service.ExhibitService;
import Utils.AuditSingleton;

import java.util.ArrayList;
import java.util.List;

public class ExhibitServiceImpl implements ExhibitService {
    List<Exhibit> exhibits;

    @Override
    public void addExhibit(Exhibit exhibit) throws Exception {
        if (exhibits == null)
            exhibits = new ArrayList<>();
        exhibits.add(exhibit);
        AuditSingleton.INSTANCE.writeAction("Add exhibit");
    }

    @Override
    public void addExhibit(String[] exhibit) throws Exception {

        int id = Integer.parseInt(exhibit[0]);
        String name = exhibit[1];
        String description = exhibit[2];
        String originCountry = exhibit[3];
        String originDate = exhibit[4];
        int exhibitionId = Integer.parseInt(exhibit[5]);

        if (exhibits == null)
            exhibits = new ArrayList<>();

        exhibits.add(new Exhibit(id, name, description, originCountry, originDate, exhibitionId));
        AuditSingleton.INSTANCE.writeAction("Add exhibit");
    }

    @Override
    public List<Exhibit> getExhibits() throws Exception {
        try {
            if (exhibits == null)
                throw new ExhibitsNotFoundException("Exhibits list cannot be empty.");
        } catch (ExhibitsNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get exhibit");
        return exhibits;
    }

    @Override
    public Exhibit getExhibit(int id) throws Exception {
        Exhibit foundExhibit = new Exhibit();
        boolean found = false;
        try {
            if (exhibits == null) {
                throw new ExhibitsNotFoundException("Exhibits cannot be empty.");
            }
            for (Exhibit exhibit : exhibits) {
                if (id == exhibit.getId()) {
                    foundExhibit = exhibit;
                    found = true;
                }
            }
            if (!found) {
                throw new ExhibitNotFoundException("The requested exhibit was not found");
            }
        } catch (ExhibitsNotFoundException | ExhibitNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get exhibit by id");
        return foundExhibit;
    }
}
