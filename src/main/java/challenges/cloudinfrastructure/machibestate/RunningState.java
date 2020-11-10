package challenges.cloudinfrastructure.machibestate;

import challenges.cloudinfrastructure.Machine;

public class RunningState implements MachineState {

    Machine machine;

    public RunningState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void running() {
        System.out.println("machine already running");
    }

    @Override
    public void inactive() {
        machine.setCurrentMachineState(machine.toInactive());
    }

    @Override
    public void stopped() {
        machine.setCurrentMachineState(machine.toStopped());
    }

    @Override
    public String printState() {
        return "running";
    }
}
