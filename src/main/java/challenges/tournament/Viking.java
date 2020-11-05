package challenges.tournament;

import java.util.ArrayList;

public class Viking extends Warior {

    public Viking() {
        this.equipements = new ArrayList<>();
        this.arm = new Axe();
        this.hitPoints = 120;
    }
        public Viking equip(String equipment) {
        if (equipment.equals("buckler")){
            this.equipements.add(new Buckler());
        }
        return this;
    }
}
