package Lab03;

import java.util.Scanner;

public class Vase extends Item{
    private int height;
    private String material;

    public Vase(){}

    public Vase(String id,int value, String creator, int height , String material) {
        super(id, value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void input(){
        super.input();

        while (true){
            System.out.println("Enter Vase height (0 <= height <= 2000): ");
            this.height = Integer.parseInt(scanner.nextLine().trim());
            if(this.height >= 0 || this.height <= 2000){
                break;
            }
            System.out.println("Height must be 0 <= height <= 2000. Try again");
        }

        while (true){
            System.out.println("Enter Vase Material: ");
            this.material = scanner.nextLine().trim();
            if(!this.material.isEmpty()){
                break;
            }
            System.out.println("Material cannot be empty. Try again");
        }
    }

    @Override
    public String toString() {
        return String.format("Vase [ID: %-5s | Creator: %-15s | Value: %-6d | Height: %-4d | Material: %s]",
                id, creator, value, height, material);
    }
}
