package challenges.tournament;

public class Axe implements BasicArm {
    int damage = 6;

    @Override
    public int getDamage() {
        return this.damage;
    }
}
