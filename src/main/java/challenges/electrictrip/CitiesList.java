package challenges.electrictrip;

public class CitiesList {
    City from;
    City to;
    int distance;

    public CitiesList(City from, City to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public City getFrom() {
        return from;
    }

    public void setFrom(City from) {
        this.from = from;
    }

    public City getTo() {
        return to;
    }

    public void setTo(City to) {
        this.to = to;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
