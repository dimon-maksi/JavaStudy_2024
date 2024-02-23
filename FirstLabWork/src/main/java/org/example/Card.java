package org.example;

import org.example.inventory.Product;

import java.util.LinkedList;

public class Card {
    private final LinkedList<Product> _allProductsInCard = new LinkedList<>();


    protected void Add(Product product) {
        _allProductsInCard.add(product);
    }

    public String toString(Product product) {
        return "id:" + product.getId() +
                "\tname:" + product.getName() +
                "\tprice:" + product.getPrice() +
                "\tdescription: " + product.getDescription();
    }

    public LinkedList<Product> getProductsFromCard() {
        return _allProductsInCard;
    }
    public void setProductsToCard(LinkedList<Product> products){
        _allProductsInCard.addAll(products);
    }
    protected void removeProductsFromCard(Product product){
        _allProductsInCard.remove(product);
    }
}