package Model;

import Utils.TransportType;

import java.util.List;

public class MeansOfTransport {
    private int id;
    private TransportType transportType;
    private String registrationNumber;
    private int routeNumber;
    private List<String> route;
    private int startTime;
    private int endTime;
    private boolean accessibility;

    public MeansOfTransport() {
    }

    public MeansOfTransport(int id, TransportType transportType, String registrationNumber, int routeNumber, List<String> route, int startTime, int endTime, boolean accessibility) {
        this.id = id;
        this.transportType = transportType;
        this.registrationNumber = registrationNumber;
        this.routeNumber = routeNumber;
        this.route = route;
        this.startTime = startTime;
        this.endTime = endTime;
        this.accessibility = accessibility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public boolean isAccessible() {
        return accessibility;
    }

    public void setAccessibility(boolean accessibility) {
        this.accessibility = accessibility;
    }

    @Override
    public String toString() {
        return "MeansOfTransport{" +
                "id=" + id +
                ", transportType=" + transportType +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", routeNumber=" + routeNumber +
                ", route=" + route +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", accessibility=" + accessibility +
                '}';
    }
}
