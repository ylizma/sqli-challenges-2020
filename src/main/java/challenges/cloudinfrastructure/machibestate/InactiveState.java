package challenges.cloudinfrastructure.machibestate;

import challenges.cloudinfrastructure.Machine;
import challenges.cloudinfrastructure.machibestate.MachineState;

public class InactiveState implements MachineState {
    Machine machine;

    public InactiveState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void running() {
        machine.setCurrentMachineState(machine.toRunning());
    }

    @Override
    public void inactive() {
        System.out.println("already inactive");
    }

    @Override
    public void stopped() {
        machine.setCurrentMachineState(machine.toStopped());
    }

    @Override
    public String printState() {
        return "inactive";
    }
}
