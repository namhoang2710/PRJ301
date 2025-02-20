package model;

import java.io.Serializable;

public class FeastItem implements Comparable<FeastItem>, Serializable{

    private String itemId;
    private String itemName;
    private double price;
    private String ingredients;

    public FeastItem(String itemId, String itemName, double price, String ingredients) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "------------------------------------------------------------\n" +
               "Code      : " + itemId + "\n" +
               "Name      : " + itemName + "\n" +
               "Price     : " + String.format("%,f", price) + " Vnd\n" +
               "Ingredients:\n" + ingredients.replace("#", "\n") + "\n";
    }

    @Override
    public int compareTo(FeastItem o) {
       return Double.compare(this.price, o.price);
    }
    
    

   
}
