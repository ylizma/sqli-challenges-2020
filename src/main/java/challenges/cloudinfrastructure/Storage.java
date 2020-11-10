package challenges.cloudinfrastructure;

public abstract class Storage {

    private String storageName;

    public Storage(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageName() {
        return storageName;
    }
     abstract String print();
    public abstract double usedDisk();

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }
}
