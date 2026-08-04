package Lab04;

public class Electronics extends Product{
    private String brand;

    public Electronics(int id, String name, float price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("Electronics [ID: %-5s | name: %-6s | price: %-6.f | size: % -3s ]",
                id, name, price, brand);
    }
}
