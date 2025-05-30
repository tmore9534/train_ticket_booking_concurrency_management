package main.entities;

import java.util.ArrayList;

public class Train {
    String trainId;
    int trainNo;
    String departTime;
    String arrivalTime;
    String source;
    String destination;
    List<List<Integer>> seats = new ArrayList<>();
    Map<String, String> stationTime = new HashMap<>();

    public class Train {
        private String trainId;
        private int trainNo;
        private String departTime;
        private String arrivalTime;
        private String source;
        private String destination;
        private List<List<Integer>> seats = new ArrayList<>();
        private Map<String, String> StationTime = new HashMap<>();

        // Getter and Setter for trainId
        public String getTrainId() {
            return trainId;
        }

        public void setTrainId(String trainId) {
            this.trainId = trainId;
        }

        // Getter and Setter for trainNo
        public int getTrainNo() {
            return trainNo;
        }

        public void setTrainNo(int trainNo) {
            this.trainNo = trainNo;
        }

        // Getter and Setter for departTime
        public String getDepartTime() {
            return departTime;
        }

        public void setDepartTime(String departTime) {
            this.departTime = departTime;
        }

        // Getter and Setter for arrivalTime
        public String getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        // Getter and Setter for source
        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        // Getter and Setter for destination
        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        // Getter and Setter for seats
        public List<List<Integer>> getSeats() {
            return seats;
        }

        public void setSeats(List<List<Integer>> seats) {
            this.seats = seats;
        }

        // Getter and Setter for StationTime
        public Map<String, String> getStationTime() {
            return StationTime;
        }

        public void setStationTime(Map<String, String> stationTime) {
            this.StationTime = stationTime;
        }
    }

}
