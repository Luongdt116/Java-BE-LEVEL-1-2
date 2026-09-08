package Lab03;

public class AntiqueShop {
    private final ItemList ITEMLIST = new ItemList();

    public static void main(String[] args) {
        new AntiqueShop().runMenu();
    }

    public void runMenu(){
        while(true){
            System.out.println("\n======== Antique Shop Management ===========");
            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Statue");
            System.out.println("3. Add a new Painting");
            System.out.println("4. Display all items");
            System.out.println("5. Find the items by the creator");
            System.out.println("6. Display the list of vase items");
            System.out.println("7. Update by id");
            System.out.println("8. Delete by id");
            System.out.println("9. Quit");
            System.out.println("Choose: ");

            String choice = Item.scanner.nextLine().trim();

            switch (choice){
                case "1" ->{
                    Vase vase = new Vase();
                    vase.input();
                    if(ITEMLIST.addItem(vase)) System.out.println("Added a vase successfully!");
                }
                case "2" ->{
                    Statue statue = new Statue();
                    statue.input();
                    if(ITEMLIST.addItem(statue)) System.out.println("Added a statue successfully!");
                }
                case "3" ->{
                    Painting painting = new Painting();
                    painting.input();
                    if(ITEMLIST.addItem(painting)) System.out.println("Added a painting successfully!");
                }
                case "4" ->{
                    ITEMLIST.displayAll();
                }
                case "5" ->{
                    System.out.println("Enter creator name to find: ");
                    String creator = Item.scanner.nextLine().trim();

                    if(creator.isEmpty()){
                        System.out.println("Creator name cannot be empty!");
                    }else{
                        Item foundItem = ITEMLIST.findItem(creator);
                        System.out.println(foundItem != null ? foundItem.toString() : "Not found.");
                    }
                }
                case "6" ->{
                    ITEMLIST.displayItemsByType("Vase");
                }
                case "7" ->{
                    System.out.println("Enter ID to Update: ");
                    String id = Item.scanner.nextLine().trim();

                    Item itemToUpdate = ITEMLIST.getItemById(id);

                    if(itemToUpdate != null){
                        System.out.println("Item found! Please enter new information ");
                        itemToUpdate.input();
                        System.out.println("Update successfully");
                    }else{
                        System.out.println("Item with ID '" + id + "' not found.");
                    }
                }
                case "8" ->{
                    System.out.println("Enter ID to Delete: ");
                    String idToDelete = Item.scanner.nextLine().trim();

                    if (ITEMLIST.deleteItem(idToDelete)) {
                        System.out.println("Item deleted successfully!");
                    } else {
                        System.out.println("Delete failed! Item with ID '" + idToDelete + "' not found or invalid.");
                    }

                }
                case "9" ->{
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please choose from 1-9");

            }
        }
    }
}
