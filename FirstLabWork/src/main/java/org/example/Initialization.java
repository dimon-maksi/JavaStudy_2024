package org.example;

import org.example.inventory.Inventory;

public class Initialization {

    public static void InitProducts()
    {
        Inventory inventory = new Inventory();
        inventory.AddProduct(3, "bread", 12345.1, "2 breads", Category.PRODUCTS);
        inventory.AddProduct(53, "water", 120.24, "2L", Category.PRODUCTS);
        inventory.AddProduct(11, "crown", 1227.32, "Made of silver", Category.ACCESSORIES);
        inventory.AddProduct(7, "lipstick", 125.743, "For lips coloring", Category.BEAUTY);
        inventory.AddProduct(4, "ball", 546.54, "Small ball for cats", Category.PET_SUPPLIES);
        inventory.AddProduct(6, "cucumber", 527.34, "1500 gr", Category.PRODUCTS);
        inventory.AddProduct(54, "candy", 1345.1, "15 candies", Category.PRODUCTS);
        inventory.AddProduct(73, "Cola", 120.24, "1.5L", Category.PRODUCTS);
        inventory.AddProduct(57, "bracelet", 51227.32, "Made of gold", Category.ACCESSORIES);
        inventory.AddProduct(21, "powder", 125.743, "For shading", Category.BEAUTY);
        inventory.AddProduct(48, "potato", 527.34, "500 gr", Category.PRODUCTS);
    }
}
