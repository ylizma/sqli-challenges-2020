package challenges.cloudinfrastructure;

import challenges.cloudinfrastructure.machibestate.RunningState;
import challenges.cloudinfrastructure.machibestate.StoppedState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CloudInfrastructure {

    //    List of cloudStores and Machines
    List<Storage> storages;

    public CloudInfrastructure() {
        storages = new ArrayList<>();
    }

    public void createStore(String storeName) throws CreateStoreException {
        CloudStore managedStore = findCloudStoreByName(storeName);
        if (managedStore == null) {
            CloudStore cloudStore = new CloudStore(storeName);
            storages.add(cloudStore);
        } else {
            throw new CreateStoreException("Store already exist !!");
        }

    }

    public void uploadDocument(String storeName, String... myFiles) {
        CloudStore cloudStore = findCloudStoreByName(storeName);
        for (String file : myFiles) {
            File currentFile = new File(file);
            if (cloudStore != null) {
                cloudStore.getFiles().add(currentFile);
            }
        }
    }

    public CloudStore findCloudStoreByName(String storeName) {
        List<Storage> cloudstores = storages.stream().filter(storage -> storage instanceof CloudStore).collect(Collectors.toList());
        for (Storage cloudStore : cloudstores) {
            if (cloudStore.getStorageName().equals(storeName)) {
                return (CloudStore) cloudStore;
            }
        }
        return null;
    }

    public String listStores() {
         List<Storage> cloudstores = storages.stream().filter(storage -> storage instanceof CloudStore).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (Storage cloudStore : cloudstores) {
            result.append(cloudStore.print())
                    .append("||");
        }
        return result.substring(0, result.length() - 2);
    }

    public void deleteStore(String storeName) {
        CloudStore store = findCloudStoreByName(storeName);
        if (store != null) {
            this.storages.remove(store);
        }
    }

    public void emptyStore(String storeName) {
        CloudStore store = findCloudStoreByName(storeName);
        if (store != null) {
            store.getFiles().clear();
        }
    }

    public void createMachine(String machineName, String os, String disk, String memory) {
        int machineDisk = Integer.parseInt(disk.substring(0, disk.indexOf("gb")));
        int machineMemory = Integer.parseInt(memory.substring(0, memory.indexOf("gb")));
        Machine machine = new Machine(machineName, machineDisk, machineMemory, os);
        this.storages.add(machine);
    }

    public String listMachines() {
        StringBuilder builder = new StringBuilder();
        for (Storage machine : storages) {
            builder.append(machine.print())
                    .append("||");
        }
        return builder.substring(0, builder.length() - 2);
    }

    public void startMachine(String machineName) throws MachineStateException {
        Machine machine = findMachineByName(machineName);
        if (machine != null) {
            if (machine.getCurrentMachineState() instanceof RunningState)
                throw new MachineStateException("machine already running");
            machine.setCurrentMachineState(machine.toRunning());
        }
    }

    private Machine findMachineByName(String storeName) {
        List<Storage> machines = storages.stream().filter(storage -> storage instanceof Machine).collect(Collectors.toList());
        for (Storage machine : machines) {
            if (machine.getStorageName().equals(storeName)) {
                return (Machine) machine;
            }
        }
        return null;
    }

    public void stopMachine(String machineName) {
        Machine machine = findMachineByName(machineName);
        if (machine != null) {
            machine.setCurrentMachineState(machine.toStopped());
        }
    }

    public int usedMemory(String machineName) {
        Machine machine = findMachineByName(machineName);
        if (machine != null) {
            if (machine.getCurrentMachineState() instanceof RunningState) {
                return  machine.getMemory();
            } else{
                return 0;
            }
        }
        return -1;
    }

    public double usedDisk(String storageName) {
        Machine machine = findMachineByName(storageName);
        if (machine != null) {
            return machine.getDisk();
        }
        CloudStore store = findCloudStoreByName(storageName);
        if (store != null) {
            return store.usedDisk();
        }
        return -1;
    }

    public double globalUsedDisk() {
        double usedDisk = 0;
        for (Storage storage : storages) {
            usedDisk += storage.usedDisk();
        }
        return usedDisk;
    }

    public double globalUsedMemory() {
        double memory = 0;
        List<Storage> cloudstores = storages.stream().filter(storage -> storage instanceof Machine).collect(Collectors.toList());
        for (Storage cloudStore : cloudstores) {
            System.out.println(this.usedMemory(cloudStore.getStorageName()));
            memory += this.usedMemory(cloudStore.getStorageName());
        }
        return memory;
    }
}
