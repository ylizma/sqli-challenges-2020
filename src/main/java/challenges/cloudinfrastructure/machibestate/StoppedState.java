package challenges.cloudinfrastructure.machibestate;

import challenges.cloudinfrastructure.Machine;

public class StoppedState implements MachineState {
    Machine machine;

    public StoppedState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void running() {
        machine.setCurrentMachineState(machine.toRunning());
    }

    @Override
    public void inactive() {
        machine.setCurrentMachineState(machine.toInactive());
    }

    @Override
    public void stopped() {
        System.out.println("already stopped");
    }

    @Override
    public String printState() {
        return "stopped";
    }
}
