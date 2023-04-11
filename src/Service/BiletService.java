package Service;

import Model.Bilet;

import java.util.List;

public interface BiletService {
    void addBilet(Bilet bilet) throws Exception;

    List<Bilet> getBilet() throws Exception;

    float pretTotalBilete() throws Exception;
}
