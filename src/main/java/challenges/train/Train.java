package challenges.train;

import java.util.LinkedList;
import java.util.List;

public class Train {

    private List<Wagon> wagons = new LinkedList<>();

    public Train(String wagons) {
        for (int i = 0; i < wagons.length(); i++) {
            Wagon wagon = null;
            if (wagons.charAt(i) == 'H') {
                if (this.wagons.size() > 1) {
                    wagon = new LastHead(new BasicTrain());
                } else {
                    wagon = new Head(new BasicTrain());
                }
            } else if (wagons.charAt(i) == 'P') {
                wagon = new Passenger(new BasicTrain());
            } else if (wagons.charAt(i) == 'R') {
                wagon = new Restaurant(new BasicTrain());
            } else if (wagons.charAt(i) == 'C') {
                wagon = new EmptyCargo(new BasicTrain());
            }
            this.wagons.add(wagon);
        }
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (Wagon wagon : this.wagons
        ) {
            result.append(wagon.print());
            result.append("::");
        }
        return result.substring(0, result.length() - 2);
    }

    public void detachEnd() {
        this.wagons.remove(this.wagons.size() - 1);
    }

    public void detachHead() {
        this.wagons.remove(0);
    }

    public boolean fill() {
        int i = 0;
        for (Wagon wagon : wagons
        ) {
            if (wagon instanceof EmptyCargo) {
                wagons.set(i, new FilledCargo(new BasicTrain()));
                return true;
            }
            i++;
        }
        return false;
    }
}
