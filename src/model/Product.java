package model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int amount;
    private String color;
    private String category;
    private String describes;

    public Product(int id, String name, float price, int amount, String color, String category, String describes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.category = category;
        this.describes = describes;
    }
    public Product( String name, float price, int amount, String color, String category, String describes) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.category = category;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}
