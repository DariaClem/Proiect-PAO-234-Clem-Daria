package Service.Impl;

import Exceptii.*;
import Model.MijlocDeTransport;
import Model.Utilizator;
import Service.MijlocDeTransportService;
import Utile.AuditSingleton;

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
            AuditSingleton.INSTANCE.writeAction("Adaugare mijloc de transport");
        }
    }

    @Override
    public List<MijlocDeTransport> getMijloaceDeTransport() throws Exception {
        try {
            if (mijloaceDeTransport == null)
                throw new NuSuntMijloaceDeTransportException("Lista de mijloace de transport este goala");
        } catch (NuSuntMijloaceDeTransportException exceptie) {
            System.out.println(exceptie.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get mijloace de transport");
        return mijloaceDeTransport;
    }

    @Override
    public MijlocDeTransport getMijlocDeTransport(int id) throws Exception {
        MijlocDeTransport mijlocDeTransportGasit = new MijlocDeTransport();
        boolean gasit = false;
        try {
            if (mijloaceDeTransport == null) {
                throw new NuSuntMijloaceDeTransportException("Lista de mijloace de transport este goala");
            }
            for (MijlocDeTransport mijlocDeTransport : mijloaceDeTransport) {
                if (id == mijlocDeTransport.getId()) {
                    mijlocDeTransportGasit = mijlocDeTransport;
                    gasit = true;
                }
            }
            if (!gasit) {
                throw new NuEsteMijloculDeTransportException("Mijlocul de transport cautat nu a fost gasit");
            }
        } catch (NuSuntMijloaceDeTransportException | NuEsteMijloculDeTransportException exceptie) {
            System.out.println(exceptie.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get mijloc de transport după id");
        return mijlocDeTransportGasit;
    }
}
