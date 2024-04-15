package org.example;
import java.util.List;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;

import java.time.format.DateTimeFormatter;

public class TransactionAnalyzer {

    private List<Transaction> transactions;
    private DateTimeFormatter dateFormatter;

    public TransactionAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
        this.dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    // Метод для розрахунку загального балансу
    public double calculateTotalBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public int countTransactionsByMonth(String monthYear) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    public List<Transaction> findTopExpenses() {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Вибірка лише витрат (від'ємні значення)
                .sorted(Comparator.comparing(Transaction::getAmount)) // Сортування за сумою
                .limit(10) // Обмеження результату першими 10 записами
                .collect(Collectors.toList()); // Збір результату в список
    }

    public List<Transaction> findTopExpensesInRange(LocalDate startDate, LocalDate endDate, int count) {

        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .filter(t -> LocalDate.parse(t.getDate(), dateFormatter).isAfter(startDate) && LocalDate.parse(t.getDate(), dateFormatter).isBefore(endDate)) // Вибірка транзакцій вказаного періоду
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(count)
                .collect(Collectors.toList());
    }
}

