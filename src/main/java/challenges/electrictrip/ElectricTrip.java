package challenges.electrictrip;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ElectricTrip {
    List<CitiesList> citiesLists;
    ElectricTripService electricTripService = new ElectricTripService();
    List<Trip> trips = new ArrayList<>();

    public ElectricTrip(String trip) {
        this.citiesLists = new LinkedList<>();
        String[] spliTrips = trip.split("-");
        CitiesList newCity = null;
        for (int i = 0; i < spliTrips.length - 1; i = i + 2) {
            City fromCity = new City(spliTrips[i]);
            City toCity = new City(spliTrips[i + 2]);
            newCity = new CitiesList(fromCity, toCity, Integer.parseInt(spliTrips[i + 1]));
            this.citiesLists.add(newCity);
        }
    }

    public int startTripIn(String city, int batterySize, int lowSpeedPerformance, int highSpeedPerformance) {
        Trip tripDetails = new Trip(new City(city), batterySize, lowSpeedPerformance, highSpeedPerformance);
        this.trips.add(tripDetails);
        return tripDetails.getId();
    }

    public void go(int participantId) {
        ElectricTripService.go(this.trips,this.citiesLists,participantId);
    }

    public String locationOf(int participantId) {
        return ElectricTripService.locationOf(participantId,trips);
    }

    public String chargeOf(int participantId) {
         return ElectricTripService.chargeOf(participantId,trips);
    }

    public void sprint(int participantId) {
        ElectricTripService.sprint(this.trips,this.citiesLists,participantId);
    }

    public void charge(int id, int hoursOfCharge) {
        ElectricTripService.charge(id,hoursOfCharge,citiesLists,trips);
    }
}
