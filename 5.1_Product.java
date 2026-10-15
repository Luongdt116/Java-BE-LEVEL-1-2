package Lab05;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int quantityInStock;

    public Product(){}

    public Product( int productID, String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.productID = productID;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void displayProductInfo(){
        System.out.println("ID: " + productID + "Name: " + name + "Price: " + price + "Quantity: " + quantityInStock);
    }
}
