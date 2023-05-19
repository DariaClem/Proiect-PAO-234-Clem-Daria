package Service;

import Model.MijlocDeTransport;

import java.util.List;

public interface MijlocDeTransportService {
    void addMijlocDeTransport(MijlocDeTransport mijlocDeTransport) throws Exception;

    List<MijlocDeTransport> getMijloaceDeTransport() throws Exception;
    MijlocDeTransport getMijlocDeTransport(int id) throws Exception;
}
