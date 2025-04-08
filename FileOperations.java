package fileoperations;

import java.io.IOException;

public interface FileOperations {
    void save(String fName, String data) throws IOException;
    String read(String fName) throws IOException;
}
