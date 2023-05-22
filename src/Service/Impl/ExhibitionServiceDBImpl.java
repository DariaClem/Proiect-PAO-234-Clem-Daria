package Service.Impl;

import Exceptions.ExhibitionNotFoundException;
import Exceptions.ExhibitionsNotFoundException;
import Model.Exhibit;
import Model.Exhibition;
import Repositories.ExhibitionRepository;
import Service.ExhibitionServiceDB;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ExhibitionServiceDBImpl implements ExhibitionServiceDB {
    private ExhibitionRepository exhibitionRepository;

    public ExhibitionServiceDBImpl(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    public ExhibitionServiceDBImpl() {
    }

    public void setExhibitionRepository(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    @Override
    public void addExhibition(Exhibition exhibition) {
        try {
            exhibitionRepository.addExhibition(exhibition);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void addExhibition(String name, Date startDate, Date endDate, int museumId) {
        try {
            exhibitionRepository.addExhibition(name, startDate, endDate, museumId);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public List<Exhibition> getAllExhibitions() {
        try {
            List<Exhibition> exhibitions = exhibitionRepository.getAllExhibitions();
            if (exhibitions.size() < 1)
                throw new ExhibitionsNotFoundException("Exhibitions list is empty.");
            return exhibitions;
        } catch (SQLException | ExhibitionsNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public Exhibition getExhibition(int id) {
        try {
            Exhibition exhibition = exhibitionRepository.getExhibition(id);
            if (exhibition == null)
                throw new ExhibitionNotFoundException("The requested exhibition was not found.");
            return exhibition;
        } catch (SQLException | ExhibitionNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Exhibition> getExhibition(String name) {
        try {
            List<Exhibition> exhibitions = exhibitionRepository.getExhibition(name);
            if (exhibitions.size() < 1)
                throw new ExhibitionNotFoundException("The requested exhibition was not found.");
            return exhibitions;
        } catch (SQLException | ExhibitionNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Exhibition> getExhibitionByMuseumId(int id) {
        try {
            List<Exhibition> exhibitions = exhibitionRepository.getExhibitionByMuseumId(id);
            if (exhibitions.size() < 1)
                throw new ExhibitionsNotFoundException("There are no exhibitions with the given museumId.");
            return exhibitions;
        } catch (SQLException | ExhibitionsNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public void editExhibition(String property, String newValue, String criterion, String value) {
        try {
            exhibitionRepository.editExhibition(property, newValue, criterion, value);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteAllExhibitions() {
        try {
            exhibitionRepository.deleteAllExhibitions();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteExhibition(int id) {
        try {
            exhibitionRepository.deleteExhibition(id);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteExhibition(String name) {
        try {
            exhibitionRepository.deleteExhibition(name);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
