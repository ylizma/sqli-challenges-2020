package challenges.cloudinfrastructure;

import java.util.List;

public class CloudServiceImp implements Cloudservice {

    @Override
    public void uploadDocument(String storeName, String[] files, List<CloudStore> cloudStores) {
        CloudStore cloudStore = findStore(storeName, cloudStores);
        if (cloudStore != null) {
            for (String file : files
            ) {
                cloudStore.getFiles().add(file);
            }
        }
    }

    @Override
    public CloudStore findStore(String storeName, List<CloudStore> cloudStores) {
        for (CloudStore cloudStore : cloudStores
        ) {
            if (cloudStore.getName().equals(storeName))
                return cloudStore;
        }
        return null;
    }

    @Override
    public void deleteStore(String storeName, List<CloudStore> cloudStores) {
        CloudStore cloudStore = findStore(storeName, cloudStores);
        cloudStores.remove(cloudStore);
    }

    @Override
    public void emptyStore(String cloudStoreName, List<CloudStore> cloudStores) {
        CloudStore cloudStore = findStore(cloudStoreName, cloudStores);
        cloudStore.getFiles().clear();
    }

    @Override
    public boolean isStoreExist(CloudStore cloudStore, List<CloudStore> cloudStores) {
        for (CloudStore store : cloudStores
        ) {
            if (store.getName().equals(cloudStore.getName()))
                return true;
        }
        return false;
    }

    @Override
    public String listMachines(List<Machine> machines) {
        StringBuilder report = new StringBuilder();
        for (Machine machine : machines
        ) {
            report.append(machine.getName()).append(":")
                    .append(machine.getState().toString().toLowerCase());
            report.append("||");
        }
        return report.substring(0, report.length() - 2);
    }

    @Override
    public void startMachine(String machineName, List<Machine> machines) throws MachineStateException {
        Machine machine = findMachineByName(machineName, machines);
        if (machine != null) {
            if (machine.getState().equals(MachineState.RUNNING)) {
                throw new MachineStateException();
            } else {
                machine.setState(MachineState.RUNNING);
            }
        }
    }

    @Override
    public Machine findMachineByName(String machineName, List<Machine> machines) {
        for (Machine machine : machines
        ) {
            if (machine.getName().equals(machineName)) return machine;
        }
        return null;
    }

    @Override
    public void stopMachine(String machineName, List<Machine> machines) {
        Machine machine = findMachineByName(machineName, machines);
        if (machine != null) {
            machine.setState(MachineState.STOPPED);
        }
    }

    @Override
    public double usedMemory(String machine1, List<Machine> machines) {
        Machine machine = findMachineByName(machine1, machines);
        if (machine != null) {
            if (machine.getState().equals(MachineState.RUNNING)) {
                return machine.getMemorySize();
            } else return 0;
        }
        return -1;
    }

    @Override
    public double usedDisk(String machine1, List<Machine> machines, List<CloudStore> cloudStores) {
        Machine machine = findMachineByName(machine1, machines);
        if (machine != null) {
            return machine.getDiskSize();
        } else {
            CloudStore store = findStore(machine1, cloudStores);
            if (store != null) {
                return store.getFiles().size() * store.getFileSize();
            }
        }
        return -1;
    }

    @Override
    public double globalDisk(List<Machine> machines) {
        double usage = 0;
        for (Machine machine:machines
             ) {
            usage += machine.getDiskSize();
        }
        return usage;
    }

    @Override
    public double globalMemory(List<Machine> machines) {
        double usage = 0;
        for (Machine machine:machines
             ) {
            if (!machine.getState().equals(MachineState.RUNNING)){
                usage += 0;
            }else{
                usage += machine.getMemorySize();
            }
        }
        return usage;
    }
}
