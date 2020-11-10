package challenges.cloudinfrastructure;

import java.util.ArrayList;
import java.util.List;

public class CloudStore extends Storage {

    private List<File> files;

    public CloudStore(String store) {
        super(store);
        this.files = new ArrayList<>();
    }

    @Override
    String print() {
        StringBuilder builder = new StringBuilder();
        builder.append(getStorageName())
                .append(":");
        if (!files.isEmpty()) {
            for (File file : files) {
                builder.append(file.getName());
                builder.append(", ");
            }
        } else {
            builder.append("empty, ");
        }

        return builder.substring(0, builder.length() - 2);
    }

    @Override
    public double usedDisk() {
        double usedDisk = 0;
            for (File file : this.getFiles()) {
                usedDisk += file.getUsedDisk();
            }
            return usedDisk;
    }


    public List<File> getFiles() {
        return files;
    }

}
