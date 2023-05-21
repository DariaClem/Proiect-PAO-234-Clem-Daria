package Service.Impl;

import Exceptions.ExhibitNotFoundException;
import Exceptions.ExhibitsNotFoundException;
import Model.Exhibit;
import Repositories.ExhibitRepository;
import Service.ExhibitServiceDB;

import java.sql.SQLException;
import java.util.List;

public class ExhibitServiceDBImpl implements ExhibitServiceDB {
    private ExhibitRepository exhibitRepository;

    public ExhibitServiceDBImpl(ExhibitRepository exhibitRepository) {
        this.exhibitRepository = exhibitRepository;
    }

    public ExhibitServiceDBImpl() {
    }

    public void setExhibitRepository(ExhibitRepository exhibitRepository) {
        this.exhibitRepository = exhibitRepository;
    }

    @Override
    public void addExhibit(Exhibit exhibit) {
        try {
            exhibitRepository.addExhibit(exhibit);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void addExhibit(String name, String description, String originCountry, String originDate, int exhibitionId) {
        try {
            exhibitRepository.addExhibit(name, description, originCountry, originDate, exhibitionId);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public List<Exhibit> getAllExhibits() {
        try {
            List<Exhibit> exhibits = exhibitRepository.getAllExhibits();
            if (exhibits == null)
                throw new ExhibitsNotFoundException("Exhibits list is empty.");
            return exhibits;
        } catch (SQLException | ExhibitsNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public Exhibit getExhibit(int id) {
        try {
            Exhibit exhibit = exhibitRepository.getExhibit(id);
            if (exhibit == null)
                throw new ExhibitNotFoundException("The requested exhibit was not found.");
            return exhibit;
        } catch (SQLException | ExhibitNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Exhibit> getExhibit(String name) {
        try {
            List<Exhibit> exhibits = exhibitRepository.getExhibit(name);
            if (exhibits == null)
                throw new ExhibitNotFoundException("The requested exhibit was not found.");
            return exhibits;
        } catch (SQLException | ExhibitNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Exhibit> getExhibitByExhibitionId(int id) {
        try {
            List<Exhibit> exhibits = exhibitRepository.getExhibitByExhibitionId(id);
            if (exhibits == null)
                throw new ExhibitsNotFoundException("There are no exhibits with the given exhibitionId.");
            return exhibits;
        } catch (SQLException | ExhibitsNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public void editExhibit(String property, String newValue, String criterion, String value) {
        try {
            exhibitRepository.editExhibit(property, newValue, criterion, value);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteAllExhibits() {
        try {
            exhibitRepository.deleteAllExhibits();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteExhibit(int id) {
        try {
            exhibitRepository.deleteExhibit(id);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteExhibit(String name) {
        try {
            exhibitRepository.deleteExhibit(name);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
