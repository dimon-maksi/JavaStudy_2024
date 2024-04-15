package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class TransactionCSVReader {
    private DataReader dataReader;
    public TransactionCSVReader(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    public List<Transaction> readTransactions(String filePath) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            List<String[]> data = dataReader.readData(filePath);
            for (String[] values : data) {
                Transaction transaction = new Transaction(values[0], Double.parseDouble(values[1]), values[2]);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}

