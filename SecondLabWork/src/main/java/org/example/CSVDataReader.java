package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class CSVDataReader extends DataReader {
    public List<String[]> readData(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try {
            URL url = new URL(filePath);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    data.add(values);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
