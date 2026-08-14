package Lab03;

import java.util.Scanner;

public class Item {
    protected String id;
    protected int value;
    protected String creator;

    protected static final Scanner scanner = new Scanner(System.in);

    public Item(){}

    public Item(String id, int value, String creator) {
        this.creator = creator;
        this.id = id;
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void input(){
        while (true){
            System.out.println("Enter item ID: ");
            this.id = scanner.nextLine().trim();
            if(!this.id.isEmpty()){
                break;
            }
            System.out.println("IC cannot be empty. Try again");
        }

        while(true){
            try{
                System.out.println("Enter item value (>=0): ");
                this.value = Integer.parseInt(scanner.nextLine().trim());
                if(this.value >= 0){
                    break;
                }
                System.out.println("Value must be >= 0. Try again");
            }catch (NumberFormatException e){
                System.out.println("Invalid number format. Try again.");
            }
        }

        while (true){
            System.out.println("Enter creator name: ");
            this.creator = scanner.nextLine().trim();
            if(!this.creator.isEmpty()){
                break;
            }
            System.out.println("Creator cannot be empty. Try again.");
        }
    }
    @Override
    public String toString() {
        return String.format("Vase [ID: %-5s | Creator: %-15s | Value: %-6d ]",
                id, creator, value);
    }
}
