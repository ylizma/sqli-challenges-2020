package challenges.electrictrip;

import java.util.List;

public class ElectricTripService {

    public static void go(List<Trip> trips, List<CitiesList> citiesLists, int participantId) {
        Trip trip = findTripById(participantId, trips);
        if (trip != null) {
            CitiesList cityIndex = getStartedCity(trip.getCurrentCity(), citiesLists);
            int batterySize = trip.getBatterySize();
            while (cityIndex != null) {
                if (trip.getBatterySize() * trip.getLowSpeed() >= cityIndex.getDistance()) {
                    trip.setCurrentCity(cityIndex.getTo());
                    trip.setAllDistance(trip.getAllDistance() + cityIndex.getDistance());
                    trip.setBatterySize(trip.getBatterySize() - (trip.getAllDistance() / trip.getLowSpeed()));
                    cityIndex = getStartedCity(cityIndex.getTo(), citiesLists);
                } else
                    break;
            }
            trip.setBatterySize(batterySize);
            trip.setCharge(calculateCharge(trip));
        }
        System.out.println(trip.getCurrentCity().getName());
    }

    private static int calculateCharge(Trip trip) {
        return 100 - ((trip.getAllDistance() * 100) / (trip.getLowSpeed() * trip.getBatterySize()));
    }

    private static CitiesList getStartedCity(City currentCity, List<CitiesList> citiesLists) {
        for (CitiesList citiesList : citiesLists
        ) {
            if (citiesList.getFrom().name.equals(currentCity.getName()))
                return citiesList;
        }
        return null;
    }

    private static Trip findTripById(int participantId, List<Trip> trips) {
        for (Trip trip : trips
        ) {
            if (trip.getId() == participantId)
                return trip;
        }
        return null;
    }

    public static String locationOf(int participantId, List<Trip> trips) {

        return findTripById(participantId, trips).getCurrentCity().getName();
    }

    public static String chargeOf(int participantId, List<Trip> trips) {
        return findTripById(participantId, trips).getCharge() + "%";
    }

    public static void sprint(List<Trip> trips, List<CitiesList> citiesLists, int participantId) {
        switchSpeedPerformance(findTripById(participantId,trips));
        go(trips,citiesLists,participantId);
    }

    private static void switchSpeedPerformance(Trip trip) {
        int oldSpeed = trip.getHighSpeed();
        trip.setHighSpeed(trip.getLowSpeed());
        trip.setLowSpeed(oldSpeed);
    }

    public static void charge(int id, int hoursOfCharge, List<CitiesList> citiesLists, List<Trip> trips) {
        Trip ctrip = findTripById(id,trips);
        if (ctrip != null){
            if(ctrip.currentCity.getStation() != -1){
                ctrip.setBatterySize(ctrip.getBatterySize()+ctrip.getCurrentCity().getStation()*hoursOfCharge);
                ctrip.setCharge(calculateCharge(ctrip));
            }
        }
    }
}
