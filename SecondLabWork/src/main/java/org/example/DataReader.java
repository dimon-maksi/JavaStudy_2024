package org.example;
import java.util.List;
import java.io.IOException;

public abstract class DataReader {
    public abstract List<String[]> readData(String filePath) throws IOException;
}
