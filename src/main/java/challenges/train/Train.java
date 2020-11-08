package challenges.train;

import java.util.LinkedList;
import java.util.List;

public class Train {

    private List<Wagon> wagons = new LinkedList<>();

    public Train(String wagons) {
        for (int i = 0; i < wagons.length(); i++) {
            if (wagons.charAt(i) == 'H') {
                if (this.wagons.size() > 1) {
                    this.wagons.add(new Head(true));
                } else {
                    this.wagons.add(new Head(false));
                }
            } else if (wagons.charAt(i) == 'P') {
                this.wagons.add(new Passenger());
            } else if (wagons.charAt(i) == 'R') {
                this.wagons.add(new Restaurant());
            } else if (wagons.charAt(i) == 'C') {
                this.wagons.add(new Cargo(false));
            }
        }
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (Wagon wagon : this.wagons
        ) {
            result.append(wagon.getWagon());
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
        for (Wagon wagon : wagons
        ) {
            if (wagon instanceof Cargo) {
                Cargo cargo = (Cargo) wagon;
                if (!cargo.isFilled()) {
                    cargo.setFilled(true);
                    return true;
                }
            }
        }
        return false;
    }
}
