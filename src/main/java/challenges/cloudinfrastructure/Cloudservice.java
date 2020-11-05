package challenges.cloudinfrastructure;

import java.util.List;

public interface Cloudservice {
    
    void uploadDocument(String storeName, String[] files, List<CloudStore> cloudStores);

    CloudStore findStore(String storeName, List<CloudStore> cloudStores);

    void deleteStore(String storeName, List<CloudStore> cloudStores);

    void emptyStore(String cloudStoreName, List<CloudStore> cloudStores);

    boolean isStoreExist(CloudStore cloudStore, List<CloudStore> cloudStores);

    String listMachines(List<Machine> machines);

    void startMachine(String machineName, List<Machine> machines) throws MachineStateException;

    Machine findMachineByName(String machineName, List<Machine> machines);

    void stopMachine(String machineName, List<Machine> machines);

    double usedMemory(String machine1, List<Machine> machines);

    double usedDisk(String machine1, List<Machine> machines, List<CloudStore> cloudStores);

    double globalDisk(List<Machine> machines);

    double globalMemory(List<Machine> machines);
}
