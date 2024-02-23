package org.example;
import org.example.inventory.Inventory;
import org.example.inventory.Product;

import java.util.LinkedList;
import java.util.Scanner;

public class UserInterface {
    private static final Inventory inventory = new Inventory();
    private static final Card card = new Card();
    public void Start() {
        ShowInterface();
        Scanner scanner = new Scanner(System.in);
        int _numberFromConsole = scanner.nextInt();
        functionCalling(_numberFromConsole);
    }

    private void ShowInterface() {
        System.out.print("1.Show all products" +
                "   2.Search product" +
                "   3.My card" +
                "   4.Add products to card" +
                "   5.Remove products from card" +
                "   6.Order" +
                "   7.Exit" +
                "\nChoose your number : ");
    }

    private void DisplayProductsInfo(LinkedList<Product> products)
    {
        if (products.isEmpty())
        {
            System.out.println("Your query result is empty");
            return;
        }
        for (Product product : products) {
            System.out.printf("Name:%s\tCategory:%s\tPrice:%s\tDescription:%s%n", product.getName(), product.getCategory(), product.getPrice(), product.getDescription());
        }
    }


    private void functionCalling(int option) {
        if (option > 7 || option < 0) {
            System.out.println("\nChoose correct option value! Try again)");
            Start();
        }
        switch(option){
            case 1: {
                DisplayProductsInfo(inventory.getAllProducts());
                Start();
            }
            case 2:{
                System.out.print("Choose name or category of the product : ");
                Scanner scanner = new Scanner(System.in);
                DisplayProductsInfo(inventory.SearchWithCategories(scanner.next()));
                Start();
            }
            case 3:{
                DisplayProductsInfo(card.getProductsFromCard());
                Start();
            }
            case 4: {
                System.out.print("Write name or category of your product : ");
                Scanner scanner = new Scanner(System.in);
                card.setProductsToCard(inventory.SearchWithCategories(scanner.next()));
                Start();
            }
            case 5:
                System.out.print("Write name or category of your product  : ");
                Scanner scanner = new Scanner(System.in);
                card.removeProductsFromCard(inventory.Search(scanner.next()));
                Start();
            case 6:

        }

    }
}
