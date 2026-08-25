package sales.client;
import sales.InputUtil;
import sales.entities.Customer;
import java.util.Scanner;

public class CustomerForm {
    public static final int MAX_NAME_LENGTH = 50;

    private final Scanner sc;

    public CustomerForm(Scanner sc){
        this.sc =sc;
    }

    public int getId(){
        int id;

        System.out.println("Enter Id: ");
        id = Integer.parseInt(sc.nextLine().trim());

        return id;
    }

    public Customer getCustomer(){
        Customer customer = new Customer();

        customer.setName(InputUtil.readStringWithLimit("Enter customer name: ", 255));
        customer.setContact(InputUtil.readStringWithLimit("Enter contact name: ", 255));
        customer.setAddress(InputUtil.readStringWithLimit("Enter address: ", 255));
        customer.setCity(InputUtil.readStringWithLimit("Enter city: ", 255));
        customer.setPostCode(InputUtil.readStringWithLimit("Enter post code: ", 10));
        customer.setCountry(InputUtil.readStringWithLimit("Enter country: ", 50));

        return customer;
    }
}
