package challenges.cloudinfrastructure.machibestate;

public interface MachineState {
    void running();
    void inactive();
    void stopped();
    String printState();
}
