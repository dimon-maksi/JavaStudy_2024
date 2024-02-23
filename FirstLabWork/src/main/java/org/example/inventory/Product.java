package org.example.inventory;
import org.example.Category;
public class Product {
    protected int _id;
    private String _name;
    private double _price;
    private String _description;
    private Category _category;

    public int getId() {
        return _id;
    }
    protected void setId(int id) {
        this._id = id;
    }
    public String getName() {
        return _name;
    }
    protected void setName(String name) {
        this._name = name;
    }
    public double getPrice() {
        return _price;
    }
    protected void setPrice(double price) {
        this._price = price;
    }
    public String getDescription() {
        return _description;
    }
    protected void setDescription(String description) {
        this._description = description;
    }
    public Category getCategory() {
        return _category;
    }

    protected void setCategory(Category _category) {
        this._category = _category;
    }

}
