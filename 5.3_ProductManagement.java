package Lab05;

public class ProductManagement {
    private Product[] products = new Product[10];
    private int productCount = 0;

    public void addProduct(Product product) throws IllegalArgumentException {
        if(productCount >= 10){
            System.out.println("Array is full");
            return;
        }

        if(product == null) throw new IllegalArgumentException("Product cannot be null");
        
        if(product.getPrice() <= 0 || product.getQuantityInStock() <= 0) throw new IllegalArgumentException("Price and quantity must be non-negative");

        for (int i = 0; i < productCount; i++) {
            if (products[i] != null && products[i].getProductID() == product.getProductID()) {
                throw new IllegalArgumentException("Product ID already exists. Please enter a unique ID.");
            }
        }

        products[productCount] = product;
        productCount++;
        System.out.println("Product Added Successfully");
    }

    public Product getProductByID(int productID) throws ProductNotFoundException{
        for(int i = 0; i < productCount; i++){
            if(products[i] != null && products[i].getProductID() == productID){
                return products[i];
            }
        }
        throw new ProductNotFoundException("Not found Product");
    }

    public void updateProductQuantity(int productID, int newQuantity) throws ProductNotFoundException{
        if(newQuantity < 0){
            throw new IllegalArgumentException("Price and quantity must be non-negative.");
        }

        Product productToUpdate = getProductByID(productID);
        productToUpdate.setQuantityInStock(newQuantity);
        System.out.println("Quantity updated successfully.");
    }
}
