package fileoperations;

import java.io.*;

public class forFileHandling implements FileOperations {

    public void save(String fName, String data) throws IOException {
        try (FileWriter w = new FileWriter(fName, true)) {
            w.write(data + "\n");
        }
    }

    public String read(String fName) throws IOException {
        StringBuilder res = new StringBuilder();
        try (BufferedReader r = new BufferedReader(new FileReader(fName))) {
            String data = r.readLine();
            while (data != null) {
                res.append(data).append("\n");
                data = r.readLine();
            }
        }
        return res.toString();
    }
}
