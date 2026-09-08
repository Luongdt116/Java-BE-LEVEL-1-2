package Lab03;

public class Painting extends Item{
    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;

    public Painting(){}

    public Painting(String id, int value, String creator, int height, int width, boolean isWaterColor, boolean isFramed) {
        super(id, value, creator);
        this.height = height;
        this.isFramed = isFramed;
        this.isWaterColor = isWaterColor;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setFramed(boolean framed) {
        isFramed = framed;
    }

    public boolean isWaterColor() {
        return isWaterColor;
    }

    public void setWaterColor(boolean waterColor) {
        isWaterColor = waterColor;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void input(){
        super.input();

        while (true){
            System.out.println("Enter painting height (0 <= height <= 2000: ");
            this.height = Integer.parseInt(scanner.nextLine().trim());
            if(this.height >= 0 && this.height <= 1000){
                break;
            }
            System.out.println("Height must be >=0 and <= 2000. Try again");
        }

        while (true){
            System.out.println("Enter painting width (0 <= width <= 3000: ");
            this.width = Integer.parseInt(scanner.nextLine().trim());
            if(this.width >= 0 && this.width <= 3000){
                break;
            }
            System.out.println("width must be >=0 and <= 3000. Try again");
        }

        while (true){
            System.out.println("Is it a watercolor painting? (true/false): ");
            String waterInput = scanner.nextLine().trim().toLowerCase();
            if(waterInput.equals("true") || waterInput.equals("false")){
                this.isWaterColor = Boolean.parseBoolean(waterInput);
                break;
            }
            System.out.println("Invalid input. Please enter 'true' or 'false'.");
        }

        while (true){
            System.out.println("Is the painting framed? (true/false): ");
            String frameInput = scanner.nextLine().trim().toLowerCase();
            if(frameInput.equals("true") || frameInput.equals("false")){
                this.isFramed = Boolean.parseBoolean(frameInput);
                break;
            }
            System.out.println("Invalid input. Please enter 'true' or 'false'.");
        }
    }

    @Override
    public String toString() {
        return String.format("Vase [ID: %-5s | Creator: %-15s | Value: %-6d | height: %-4d | width: %-4d | WaterColor: %-6b | Framed: %-6b]",
                id, creator, value, height, width, isWaterColor, isFramed);
    }
}
