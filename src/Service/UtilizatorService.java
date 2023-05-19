package Service;

import Model.Utilizator;

import java.util.List;

public interface UtilizatorService {
    void addUtilizator(Utilizator utilizator) throws Exception;
    void addUtilizator(String[] utilizator) throws Exception;

    void deleteUtilizator(Utilizator utilizator) throws Exception;

    void deleteUtilizator(String nume, String prenume) throws Exception;

    List<Utilizator> getUtilizatori() throws Exception;

    Utilizator getUtilizator(String nume, String prenume) throws Exception;
    Utilizator getUtilizator(int id) throws Exception;
}
