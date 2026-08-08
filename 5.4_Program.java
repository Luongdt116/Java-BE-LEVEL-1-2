package Lab05;

import java.lang.foreign.SymbolLookup;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Program {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ProductManagement PM = new ProductManagement();

    public static void main(String[] args) {
        byte choice = -1;

        do{
            System.out.println("========== Menu =========");
            System.out.println("1. Add Product.");
            System.out.println("2. Retrieve Product by ID.");
            System.out.println("3. Update Product Quantity.");
            System.out.println("4. Exit.");
            System.out.println("Enter your choice: ");

            try{
                choice = Byte.parseByte(SCANNER.nextLine().trim());
            }catch (NumberFormatException e){
                choice = -1;
            }

            switch (choice){
                case 1 ->{
                    System.out.println("------- Add new product ---------");
                    try {
                        System.out.println("Enter Id: ");
                        int id = Integer.parseInt(SCANNER.nextLine().trim());

                        System.out.println("Enter name: ");
                        String name = SCANNER.nextLine().trim();

                        System.out.println("Enter price: ");
                        double price = Double.parseDouble(SCANNER.nextLine().trim());

                        System.out.println("Enter quantity");
                        int quantity = Integer.parseInt(SCANNER.nextLine().trim());

                        Product newProduct = new Product(id, name, price, quantity);
                        PM.addProduct(newProduct);

                    }catch (NumberFormatException e){
                        System.out.println("Error: ID, price, and quantity must be numbers.");
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 2 ->{
                    System.out.println("--- Retrieve Product ---");
                    try{
                        System.out.println("Enter Product ID to search: ");
                        int id = Integer.parseInt(SCANNER.nextLine().trim());

                        Product product = PM.getProductByID(id);
                        product.displayProductInfo();
                    }catch (NumberFormatException e){
                        System.out.println("Error: ID must be a number.");
                    }catch (ProductNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 3 ->{
                    System.out.println("------ Update Quantity --------");
                    try{
                        System.out.println("Enter Product ID to update: ");
                        int id = Integer.parseInt(SCANNER.nextLine().trim());

                        System.out.println("Enter new quantity: ");
                        int quantity = Integer.parseInt(SCANNER.nextLine().trim());

                        PM.updateProductQuantity(id, quantity);
                        System.out.println("Product quantity updated successfully");
                    }catch (NumberFormatException e){
                        System.out.println("Error: ID and quantity must be numbers.");
                    }catch (ProductNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 4 ->{
                    System.out.println("Exit");
                }
                default ->{
                    System.out.println("Invalid choice. Please select 1-4");
                }
            }

        }while(choice != 4);
//        ProductManagement pm = new ProductManagement();
//        try{
//            pm.addProduct(new Product(101,"Laptop",999.99, 10));
//            pm.addProduct(new Product(102, "Smartphone", 799.99, 20));
//        } catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Product product = pm.getProductByID(101);
//            product.displayProductInfo();
//        }catch (ProductNotFoundException e){
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            pm.updateProductQuantity(105,15);
//        }catch (ProductNotFoundException | IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }

    }
}
