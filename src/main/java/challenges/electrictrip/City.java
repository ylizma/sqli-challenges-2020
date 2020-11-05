package challenges.electrictrip;

public class City {
    String name;
    int station;

    public City(String name) {
        if (name.split(":").length > 1) {
            this.station = Integer.parseInt(name.split(":")[1]);
            this.name = name.split(":")[0];
        } else {
            this.name = name;
            this.station = -1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
