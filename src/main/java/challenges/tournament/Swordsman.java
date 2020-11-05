package challenges.tournament;

import java.util.ArrayList;

public class Swordsman extends Warior {

    public Swordsman() {
        this.equipements = new ArrayList<>();
        this.arm = new Sword();
        this.hitPoints = 100;
    }


    public void engage(Viking viking) {
        while (this.hitPoints() >= 0 && viking.hitPoints() >= 0) {
            Fight.hit(this, viking);
            Fight.hit(viking, this);
        }
        if (this.hitPoints < 0)
            this.hitPoints = 0;
        else if (viking.hitPoints < 0)
            viking.hitPoints = 0;
    }

    public Swordsman equip(String equipment) {
        if (equipment.equals("buckler")){
            this.equipements.add(new Buckler());
        }
        return this;
    }
}
