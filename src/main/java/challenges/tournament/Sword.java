package challenges.tournament;

public class Sword implements BasicArm {

    private int damage = 5;

    @Override
    public int getDamage() {
        return this.damage;
    }
}
