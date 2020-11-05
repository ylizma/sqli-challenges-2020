package challenges.tournament;

public class Fight {
    static void hit(Warior warior, Warior victim){
        victim.hitPoints=victim.hitPoints() - warior.getArm().getDamage();
    }
}
