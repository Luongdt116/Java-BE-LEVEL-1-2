package sales.client;

import sales.entities.Customer;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class CustomerForm {
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

        System.out.println("Enter customer name: ");
        customer.setName(sc.nextLine().trim());

        System.out.println("Enter contact name: ");
        customer.setContact(sc.nextLine().trim());

        System.out.println("Enter address: ");
        customer.setAddress(sc.nextLine().trim());

        System.out.println("Enter city: ");
        customer.setCity(sc.nextLine().trim());

        System.out.println("Enter post code: ");
        customer.setPostCode(sc.nextLine().trim());

        System.out.print("Enter country: ");
        customer.setCountry(sc.nextLine().trim());

        return customer;
    }
}
