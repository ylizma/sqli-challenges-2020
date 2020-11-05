package challenges.cloudinfrastructure;

import java.util.ArrayList;
import java.util.List;

public class CloudStore {

    private String name;
    private List<String> files = new ArrayList<>();
    private double fileSize = 0.100;

    public CloudStore(String storeName) {
        this.name = storeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        StringBuilder object = new StringBuilder(this.name).append(":");
        if (this.files.isEmpty()) {
            System.out.println(name);
            object.append("empty");
            return object.toString();
        } else {
            for (String file : files
            ) {
                object.append(file).append(", ");
            }
            return object.substring(0,object.length() - 2);
        }
    }
}
