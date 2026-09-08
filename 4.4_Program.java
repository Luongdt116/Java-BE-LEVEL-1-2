package Lab04;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    private Product[] products;
    private byte numOfProduct;
    private static final byte MAX = 100;

    public Program(){
        products = new Product[MAX];
    }

    public static void main(String[] args) {
        Program p = new Program();
        Scanner scanner = new Scanner(System.in);
        byte choice;

        do{
            System.out.println("1. Add product.");
            System.out.println("2. Display All.");
            System.out.println("3. Find Product by ID.");
            System.out.println("0. Exit.");
            System.out.println("Enter your choice.");
            choice = Byte.parseByte(scanner.nextLine().trim());

            switch (choice){
                case 1 ->{
                    System.out.println("Select product type to add (1. Electronics | 2. Clothing");
                    String type = scanner.nextLine().trim();

                    System.out.println("Enter Id: ");
                    int id = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("Enter Id: ");
                    String name = scanner.nextLine().trim();

                    System.out.println("Enter Id: ");
                    float price = Float.parseFloat(scanner.nextLine().trim());

                    if(type.equals("1")){
                        System.out.println("Enter Brand: ");
                        String brand = scanner.nextLine().trim();

                        Electronics electronics = new Electronics(id, name, price, brand);
                        p.addProduct(electronics);

                    }else if(type.equals("2")){
                        System.out.println("Enter size: ");
                        String size = scanner.nextLine().trim();

                        Clothing clothing = new Clothing(id, name, price, size);
                        p.addProduct(clothing);

                    }else {
                        System.out.println("Invalid product type!");
                    }
                    break;
                }
                case 2 ->{
                    p.displayProduct();
                    break;
                }
                case 3 ->{
                    System.out.println("Enter product id to find: ");
                    try{
                        int searchId = Integer.parseInt(scanner.nextLine().trim());

                        // gán foundProduct chứa kết quả sau timf kiếm
                        Optional<Product> foundProduct = p.findProduct(searchId);

                        if(foundProduct.isPresent()){
                            System.out.println("Product found: "+ foundProduct.toString());
                        }else {
                            System.out.println("Proudct with id ' "+ searchId + " ' not found ");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Invalid Id format!");
                    }
                    break;
                }
                case 0 ->{
                    System.out.println("Bye!");
                    break;
                }
                default -> System.out.println("Invalid choice. Please select 0-3");
            }
        }while (choice != 0);
        scanner.close();
    }

    public void addProduct(Product product){
        if(product == null || numOfProduct >= MAX){
            System.out.println("Restore full");
            return;
        }
        products[numOfProduct] = product;
        numOfProduct++;
        System.out.println("Product add successfully.");
    }

    public void displayProduct(){
        if(numOfProduct == 0){
            System.out.println("No product available to display.");
            return;
        }
        System.out.println("Product list: ");
        for (int i = 0; i < numOfProduct; i++){
            if(products[i]!=null){
                System.out.println(products[i].toString());
            }
        }
    }

    // để kiểu trả về là Optional<Product>
    public Optional<Product> findProduct(int id ){
        for(int i=0; i < numOfProduct; i++){
            if(products[i] != null && products[i].getId() == id){
                // nếu tìm thấy thì đưa vào optional
                return Optional.of(products[i]);
            }
        }
        //khooongg thấy thì trả về một optional rỗng
        return Optional.empty();
    }


}
