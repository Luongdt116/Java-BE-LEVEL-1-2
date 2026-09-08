package Lab04;

public class Clothing extends Product{
    private String size;

    public Clothing(int id, String name, float price, String size) {
        super(id,name,price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Clothing [ID: %-5s | name: %-6s | price: %-6.2f | size: % -3s ]",
                id, name, price, size);
    }
}
