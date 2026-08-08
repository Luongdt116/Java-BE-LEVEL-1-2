package Lab03;

public class Statue extends Item{
    private int weight;
    private String color;

    public Statue(){}

    public Statue(String id, int value, String creator, String color, int weight) {
        super(id, value, creator);
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void input(){
        super.input();

        while(true){
            System.out.println("Enter statue weight (0 <= weight <= 1000)");
            this.weight = Integer.parseInt(scanner.nextLine().trim());
            if(weight >= 0 && weight <= 1000){
                break;
            }
            System.out.println("Weight must be >=0 and <= 1000");
        }

        while (true){
            System.out.println("Enter statue color: ");
            this.color = scanner.nextLine().trim();
            if(!this.color.isEmpty()){
                break;
            }
            System.out.println("Color cannot be empty. Try again");
        }

    }

    @Override
    public String toString() {
        return String.format("Vase [ID: %-5s | Creator: %-15s | Value: %-6d | weight: %-4d | color: %s]",
                id, creator, value, weight, color);
    }
}
