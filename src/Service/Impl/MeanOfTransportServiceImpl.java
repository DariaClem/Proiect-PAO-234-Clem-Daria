package Service.Impl;

import Exceptions.*;
import Model.MeansOfTransport;
import Service.MeanOfTransportService;
import Utils.AuditSingleton;

import java.util.ArrayList;
import java.util.List;

import static Validations.MeanOfTransportValidation.*;

public class MeanOfTransportServiceImpl implements MeanOfTransportService {
    List<MeansOfTransport> meansOfTransport;

    @Override
    public void addMeanOfTransport(MeansOfTransport meanOfTransport) throws Exception {
        boolean validMeanOfTransport = true;
        try {
            if (!routeValidation(meanOfTransport.getRoute()))
                throw new InvalidRouteException("The route must contain at least 2 stations.");
            if (!numberValidation(meanOfTransport.getRouteNumber()))
                throw new InvalidRouteNumberException("The bus number must be greater than 0.");
        } catch (InvalidRouteException | InvalidRouteNumberException exception) {
            validMeanOfTransport = false;
            System.out.println(exception.getMessage());
        }
        if (validMeanOfTransport) {
            if (meansOfTransport == null)
                meansOfTransport = new ArrayList<>();
            meansOfTransport.add(meanOfTransport);
            AuditSingleton.INSTANCE.writeAction("Add mean of transport");
        }
    }

    @Override
    public List<MeansOfTransport> getMeansOfTransport() throws Exception {
        try {
            if (meansOfTransport == null)
                throw new MeansOfTransportNotFoundException("Mean of Transport list cannot be empty.");
        } catch (MeansOfTransportNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get means of transport");
        return meansOfTransport;
    }

    @Override
    public MeansOfTransport getMeanOfTransport(int id) throws Exception {
        MeansOfTransport foundMeanOfTransport = new MeansOfTransport();
        boolean found = false;
        try {
            if (meansOfTransport == null) {
                throw new MeansOfTransportNotFoundException("Means of transport cannot be empty.");
            }
            for (MeansOfTransport meanOfTransport : meansOfTransport) {
                if (id == meanOfTransport.getId()) {
                    foundMeanOfTransport = meanOfTransport;
                    found = true;
                }
            }
            if (!found) {
                throw new MeanOfTransportNotFoundException("The requested means of transport was not found.");
            }
        } catch (MeansOfTransportNotFoundException | MeanOfTransportNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        AuditSingleton.INSTANCE.writeAction("Get mean of transport by id");
        return foundMeanOfTransport;
    }
}
