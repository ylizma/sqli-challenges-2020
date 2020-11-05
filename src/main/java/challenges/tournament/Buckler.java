package challenges.tournament;

public class Buckler implements Equipement {
    private int hits = 3;

    @Override
    public String getEquipementName() {
        return "buckler";
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
