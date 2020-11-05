package challenges.tournament;

import java.util.List;

public abstract class Warior {
     int hitPoints;
     BasicArm arm;
     List<Equipement> equipements;

     public int hitPoints(){
          return this.hitPoints;
     }

     public BasicArm getArm() {
          return this.arm;
     }
}
