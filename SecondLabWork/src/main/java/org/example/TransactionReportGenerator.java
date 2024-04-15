package org.example;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class TransactionReportGenerator {

    public void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 найбільших витрат:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public void printTransactionsInRangeReport(List<Transaction> transactionsInRange) {
        System.out.println("Транзакції за вказаний період:");
        for (Transaction transaction : transactionsInRange) {
            System.out.println(transaction);
        }
    }

    // Метод для створення текстового звіту зі сумарними витратами по категоріях

    public void printTotalExpensesByCategoryReport(List<Transaction> transactions) {
        Map<String, Double> totalExpensesByCategory = new HashMap<>();

        // Обчислення сумарних витрат по категоріях
        for (Transaction transaction : transactions) {
            String category = transaction.getDescription(); // Припускаємо, що опис транзакції містить категорію
            double amount = transaction.getAmount();

            totalExpensesByCategory.put(category, totalExpensesByCategory.getOrDefault(category, 0.0) + amount);
        }

        // Виведення текстового звіту
        System.out.println("Сумарні витрати по категоріях:");
        for (Map.Entry<String, Double> entry : totalExpensesByCategory.entrySet()) {
            String category = entry.getKey();
            double totalExpense = entry.getValue();
            int symbolsCount = Math.abs((int) (totalExpense / 1000)); // Кількість символів для візуалізації суми
            // Кількість символів для візуалізації суми

            // Форматування рядка з використанням символів для візуалізації
            String visualRepresentation = "*".repeat(symbolsCount);
            System.out.printf("%s: %s%n", category, visualRepresentation);
        }
    }

    public void printTotalExpensesByMonthReport(List<Transaction> transactions) {
        Map<String, Double> totalExpensesByMonth = new HashMap<>();

        for (Transaction transaction : transactions) {
            String month = transaction.getDate().substring(3, 10);
            double amount = transaction.getAmount();

            totalExpensesByMonth.put(month, totalExpensesByMonth.getOrDefault(month, 0.0) + amount);
        }

        System.out.println("Сумарні витрати по місяцях:");
        for (Map.Entry<String, Double> entry : totalExpensesByMonth.entrySet()) {
            String month = entry.getKey();
            double totalExpense = entry.getValue();
            int symbolsCount = (int) (totalExpense / 1000);

            String visualRepresentation = "*".repeat(symbolsCount);
            System.out.printf("%s: %s%n", month, visualRepresentation);
        }
    }
}
