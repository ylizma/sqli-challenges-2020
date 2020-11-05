package challenges.electrictrip;

import java.util.Random;

public class Trip {
    int id;
    City currentCity;
    int batterySize;
    int lowSpeed;
    int highSpeed;
    int charge;
    int allDistance;

    public Trip(City startCity, int batterySize, int lowSpeed, int highSpeed) {
        this.id = new Random().nextInt(1000);
        this.currentCity = startCity;
        this.batterySize = batterySize;
        this.lowSpeed = lowSpeed;
        this.highSpeed = highSpeed;
    }

    public int getAllDistance() {
        return allDistance;
    }

    public void setAllDistance(int allDistance) {
        this.allDistance = allDistance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    public int getLowSpeed() {
        return lowSpeed;
    }

    public void setLowSpeed(int lowSpeed) {
        this.lowSpeed = lowSpeed;
    }

    public int getHighSpeed() {
        return highSpeed;
    }

    public void setHighSpeed(int highSpeed) {
        this.highSpeed = highSpeed;
    }
}
