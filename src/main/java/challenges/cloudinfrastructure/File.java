package challenges.cloudinfrastructure;

public class File {
    private String Name;
    private final double usedDisk = 0.100;

    public double getUsedDisk() {
        return usedDisk;
    }

    public File(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

}
