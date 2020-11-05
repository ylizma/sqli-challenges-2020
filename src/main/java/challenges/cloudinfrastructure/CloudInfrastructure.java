package challenges.cloudinfrastructure;

import java.util.ArrayList;
import java.util.List;

public class CloudInfrastructure {

    private List<CloudStore> cloudStores = new ArrayList<>();
    private Cloudservice cloudservice = new CloudServiceImp();
    private List<Machine> machines = new ArrayList<>();

    public void createStore(String storeName) throws CreateStoreException {
        CloudStore cloudStore = new CloudStore(storeName);
        boolean isExist = cloudservice.isStoreExist(cloudStore, cloudStores);
        if (isExist) {
            throw new CreateStoreException();
        } else {
            this.cloudStores.add(cloudStore);
        }
    }

    public void uploadDocument(String storeName, String... files) {
        cloudservice.uploadDocument(storeName, files, cloudStores);
    }

    public String listStores() {
        StringBuilder result = new StringBuilder();
        for (CloudStore cloudStore : cloudStores
        ) {
            result.append(cloudStore.toString())
                    .append("||");
        }
        return result.substring(0, result.length() - 2);
    }

    public void deleteStore(String storeName) {
        cloudservice.deleteStore(storeName, cloudStores);
    }

    public void emptyStore(String storeName) {
        cloudservice.emptyStore(storeName, cloudStores);
    }

    public void createMachine(String name, String system, String diskSize, String memorySize) {
        Machine machine = new Machine(name, system, diskSize, memorySize);
        this.machines.add(machine);
    }

    public String listMachines() {
        return cloudservice.listMachines(machines);
    }

    public void startMachine(String machineName) throws MachineStateException {
        cloudservice.startMachine(machineName, machines);
    }

    public void stopMachine(String machineName) {
        cloudservice.stopMachine(machineName, machines);
    }

    public double usedMemory(String machine1) {
        return cloudservice.usedMemory(machine1,machines);
    }

    public double usedDisk(String machine1) {
        return cloudservice.usedDisk(machine1,machines,cloudStores);

    }

    public double globalUsedDisk() {
        return cloudservice.globalDisk(machines);
    }

    public double globalUsedMemory() {
        return cloudservice.globalMemory(machines);
    }
}
