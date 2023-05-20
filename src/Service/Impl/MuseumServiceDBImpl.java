package Service.Impl;

import Exceptions.MuseumNotFoundException;
import Exceptions.MuseumsNotFoundException;
import Model.Museum;
import Repositories.MuseumRepository;
import Service.MuseumServiceDB;

import java.sql.SQLException;
import java.util.List;

public class MuseumServiceDBImpl implements MuseumServiceDB {
    private MuseumRepository museumRepository;

    public MuseumServiceDBImpl(MuseumRepository museumRepository) {
        this.museumRepository = museumRepository;
    }

    public MuseumServiceDBImpl() {
    }

    public void setMuseumRepository(MuseumRepository museumRepository) {
        this.museumRepository = museumRepository;
    }

    @Override
    public void addMuseum(Museum museum) {
        try {
            museumRepository.addMuseum(museum);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void addMuseum(String name, String address) {
        try {
            museumRepository.addMuseum(name, address);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public List<Museum> getAllMuseums() {
        try {
            List<Museum> museums = museumRepository.getAllMuseums();
            if (museums == null)
                throw new MuseumsNotFoundException("Museums list is empty.");
            return museums;
        } catch (SQLException | MuseumsNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public Museum getMuseum(int id) {
        try {
            Museum museum = museumRepository.getMuseum(id);
            if (museum == null)
                throw new MuseumNotFoundException("The requested museum was not found.");
            return museum;
        } catch (SQLException | MuseumNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Museum> getMuseum(String name) {
        try {
            List<Museum> museums =  museumRepository.getMuseum(name);
            if (museums == null)
                throw new MuseumNotFoundException("The requested museum was not found.");
            return museums;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @Override
    public void editMuseum(String property, String newValue, String criterion, String value) {
        try {
            museumRepository.editMuseum(property, newValue, criterion, value);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteAllMuseums() {
        try {
            museumRepository.deleteAllMuseums();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteMuseum(int id) {
        try {
            museumRepository.deleteMuseum(id);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteMuseum(String name) {
        try {
            museumRepository.deleteMuseum(name);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
