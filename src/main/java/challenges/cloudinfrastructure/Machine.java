package challenges.cloudinfrastructure;

import challenges.cloudinfrastructure.machibestate.InactiveState;
import challenges.cloudinfrastructure.machibestate.MachineState;
import challenges.cloudinfrastructure.machibestate.RunningState;
import challenges.cloudinfrastructure.machibestate.StoppedState;

public class Machine extends Storage {
    private int disk;
    private int memory;
    private String operatingSystem;

    private MachineState running, stopped, inactive;
    private MachineState currentMachineState;

    public Machine(String machineName, int disk, int memory, String operatingSystem) {
        super(machineName);
        this.disk = disk;
        this.memory = memory;
        this.operatingSystem = operatingSystem;
//        init all the states
        running = new RunningState(this);
        stopped = new StoppedState(this);
        inactive = new InactiveState(this);
        currentMachineState = inactive;
    }

    public MachineState toRunning() {
        return this.currentMachineState = running;
    }

    public MachineState toStopped() {
        return this.currentMachineState = stopped;
    }

    public MachineState toInactive() {
        return this.currentMachineState = inactive;
    }

    public void setCurrentMachineState(MachineState currentMachineState) {
        this.currentMachineState = currentMachineState;
    }

    public MachineState getCurrentMachineState() {
        return currentMachineState;
    }

    public int getDisk() {
        return disk;
    }

    public int getMemory() {
        return memory;
    }


    @Override
    String print() {
        StringBuilder builder = new StringBuilder(getStorageName());
        builder.append(":").append(this.getCurrentMachineState().printState());
        return builder.toString();
    }

    @Override
    public double usedDisk() {
        return this.disk;
    }
}
