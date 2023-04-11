package Service.Impl;

import Exceptii.InvalidNumarAutobuzException;
import Exceptii.InvalidRutaException;
import Exceptii.NuSuntMijloaceDeTransportException;
import Model.MijlocDeTransport;
import Service.MijlocDeTransportService;

import java.util.ArrayList;
import java.util.List;

import static Validari.MijlocDeTransportValidare.validareNumar;
import static Validari.MijlocDeTransportValidare.validareRuta;

public class MijlocDeTransportServiceImpl implements MijlocDeTransportService {
    List<MijlocDeTransport> mijloaceDeTransport;

    @Override
    public void addMijlocDeTransport(MijlocDeTransport mijlocDeTransport) throws Exception {
        boolean mijlocDeTransportValid = true;
        try {
            if (!validareRuta(mijlocDeTransport.getRuta()))
                throw new InvalidRutaException("Ruta trebuie sa contina cel putin 2 statii");
            if (!validareNumar(mijlocDeTransport.getNumarRuta()))
                throw new InvalidNumarAutobuzException("Numarul autobuzului trebuie sa fie mai mare decat 0");
        } catch (InvalidRutaException | InvalidNumarAutobuzException exceptie) {
            mijlocDeTransportValid = false;
            System.out.println(exceptie.getMessage());
        }
        if (mijlocDeTransportValid) {
            if (mijloaceDeTransport == null)
                mijloaceDeTransport = new ArrayList<>();
            mijloaceDeTransport.add(mijlocDeTransport);
        }
    }

    @Override
    public List<MijlocDeTransport> getMijlocDeTransport() throws Exception {
        try {
            if (mijloaceDeTransport == null)
                throw new NuSuntMijloaceDeTransportException("Lista de mijloace de transport este goala");
        } catch (NuSuntMijloaceDeTransportException exceptie) {
            System.out.println(exceptie.getMessage());
        }
        return mijloaceDeTransport;
    }
}
