package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TransactionAnalyzerTest {
    @Test
    public void testCalculateTotalBalance() {
        // Створення тестових даних
        Transaction transaction1 = new Transaction("2023-01-01", 100.0, "Дохід");
        Transaction transaction2 = new Transaction("2023-01-02", -50.0, "Витрата");
        Transaction transaction3 = new Transaction("2023-01-03", 150.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        // Створення екземпляру TransactionAnalyzer з тестовими даними
        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        // Виклик методу, який потрібно протестувати
        double result = analyzer.calculateTotalBalance();

        // Перевірка результату
        Assertions.assertEquals(200.0, result, "Розрахунок загального балансу неправильний");
    }

    @Test
    public void testCountTransactionsByMonth() {
        // Підготовка тестових даних
        Transaction transaction1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        // Створення екземпляру TransactionAnalyzer з тестовими даними
        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        int countFeb = analyzer.countTransactionsByMonth("02-2023");
        int countMar = analyzer.countTransactionsByMonth("03-2023");

        // Перевірка результатів
        Assertions.assertEquals(2, countFeb, "Кількість транзакцій за лютий неправильна");
        Assertions.assertEquals(1, countMar, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void testReadTransactionsFromCSV() {
        // тест для перевірки читання даних із CSV
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        TransactionCSVReader csvReader = new TransactionCSVReader(new CSVDataReader());

        List<Transaction> transactions = csvReader.readTransactions(filePath);

        Assertions.assertNotNull(transactions, "Список транзакцій не повинен бути пустим");

        Assertions.assertEquals(26, transactions.size(), "Кількість транзакцій неправильна");
    }

    @Test
    public void testFindTopExpenses() {
        // Тест на визначення 10 найбільших витрат
        Transaction transaction1 = new Transaction("2023-01-01", -100.0, "Витрата 1");
        Transaction transaction2 = new Transaction("2023-01-02", -200.0, "Витрата 2");
        Transaction transaction3 = new Transaction("2023-01-03", -300.0, "Витрата 3");
        Transaction transaction4 = new Transaction("2023-01-04", 100.0, "Дохід 1");
        Transaction transaction5 = new Transaction("2023-01-05", -400.0, "Витрата 4");
        Transaction transaction6 = new Transaction("2023-01-06", -500.0, "Витрата 5");
        List<Transaction> transactions = List.of(transaction1, transaction2, transaction3, transaction4, transaction5, transaction6);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        List<Transaction> topExpenses = analyzer.findTopExpenses();

        Assertions.assertTrue(topExpenses.size() >= 3, "Неправильна кількість транзакцій");

        // Перевірка сум витрат (перевірка, що транзакції відсортовані від найбільшої до найменшої суми)
        Assertions.assertEquals(-500.0, topExpenses.get(0).getAmount(), "Неправильна сума першої транзакції");
        Assertions.assertEquals(-400.0, topExpenses.get(1).getAmount(), "Неправильна сума другої транзакції");
        Assertions.assertEquals(-300.0, topExpenses.get(2).getAmount(), "Неправильна сума третьої транзакції");
    }

    @Test
    public void testFindTopExpensesInRange() {
        // тест  функції для визначення найбільших і найменших витрат за вказаний період
        Transaction transaction1 = new Transaction("2023-01-01", -100.0, "Витрата 1");
        Transaction transaction2 = new Transaction("2023-01-02", -200.0, "Витрата 2");
        Transaction transaction3 = new Transaction("2023-01-03", -300.0, "Витрата 3");
        Transaction transaction4 = new Transaction("2023-01-04", 100.0, "Дохід 1");
        Transaction transaction5 = new Transaction("2023-01-05", -400.0, "Витрата 4");
        List<Transaction> transactions = List.of(transaction1, transaction2, transaction3, transaction4, transaction5);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        LocalDate startDate = LocalDate.parse("2023-01-01");
        LocalDate endDate = LocalDate.parse("2023-01-05");

        List<Transaction> topExpensesInRange = analyzer.findTopExpensesInRange(startDate, endDate, 3);

        Assertions.assertEquals(3, topExpensesInRange.size(), "Неправильна кількість транзакцій");

        Assertions.assertEquals(-400.0, topExpensesInRange.get(0).getAmount(), "Неправильна сума першої транзакції");
        Assertions.assertEquals(-300.0, topExpensesInRange.get(1).getAmount(), "Неправильна сума другої транзакції");
        Assertions.assertEquals(-200.0, topExpensesInRange.get(2).getAmount(), "Неправильна сума третьої транзакції");
    }
}
