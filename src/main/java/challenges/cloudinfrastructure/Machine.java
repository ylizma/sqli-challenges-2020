package challenges.cloudinfrastructure;

public class Machine {
    private String name;
    private String system;
    private int diskSize;
    private int memorySize;
    private MachineState state;

    public Machine(String name, String system, String diskSize, String memorySize) {
        this.name = name;
        this.system = system;
        this.state = MachineState.INACTIVE;
        this.diskSize = Integer.parseInt(diskSize.substring(0,diskSize.indexOf("gb")));
        this.memorySize = Integer.parseInt(memorySize.substring(0,memorySize.indexOf("gb")));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public MachineState getState() {
        return state;
    }

    public void setState(MachineState state) {
        this.state = state;
    }
}
