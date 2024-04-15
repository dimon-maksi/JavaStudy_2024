package org.example;
import java.util.List;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        DataReader csvDataReader = new CSVDataReader();
        TransactionCSVReader csvReader = new TransactionCSVReader(csvDataReader);
        List<Transaction> transactions = csvReader.readTransactions(filePath);

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);
        TransactionReportGenerator reportGenerator = new TransactionReportGenerator();


        double totalBalance = analyzer.calculateTotalBalance();

        reportGenerator.printBalanceReport(totalBalance);

        String monthYear = "01-2024";
        int transactionsCount = analyzer.countTransactionsByMonth(monthYear);
        reportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        List<Transaction> topExpenses = analyzer.findTopExpenses();
        reportGenerator.printTopExpensesReport(topExpenses);

        LocalDate startDate = LocalDate.parse("2023-12-10");
        LocalDate endDate = LocalDate.parse("2024-01-30");
        List<Transaction> topExpensesInRange = analyzer.findTopExpensesInRange(startDate, endDate, 10);

        reportGenerator.printTransactionsInRangeReport(topExpensesInRange);

        reportGenerator.printTotalExpensesByCategoryReport(transactions);

        reportGenerator.printTotalExpensesByMonthReport(transactions);
    }
}
