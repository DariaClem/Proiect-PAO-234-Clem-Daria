package Service;

import Model.MeansOfTransport;

import java.util.List;

public interface MeanOfTransportService {
    void addMeanOfTransport(MeansOfTransport meanOfTransport) throws Exception;

    List<MeansOfTransport> getMeansOfTransport() throws Exception;
    MeansOfTransport getMeanOfTransport(int id) throws Exception;
}
