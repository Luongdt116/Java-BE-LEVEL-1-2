package Lab03;

public class ItemList {
    private Item list[];
    private int numOfItem;
    final int MAX = 100;
    public ItemList(){
        list=new Item[MAX];
        numOfItem = 0;
    }

    public boolean addItem(Item item){
        if(item == null || numOfItem >= MAX){
            return false;
        }
        list[numOfItem] = item;
        numOfItem ++;
        return true;
    }

    public void displayAll(){
        if(numOfItem == 0){
            System.out.println("The list is empty.");
            return;
        }
        for( int i=0; i < numOfItem; i++){
            System.out.println(list[i].toString());
        }
    }

    // find item by its creator - first
    public Item findItem(String creator){
        for(int i=0; i < numOfItem; i++){
            if(list[i].getCreator().equalsIgnoreCase(creator)){
                return list[i];
            }
        }
        return null;
    }

    // updatee item by id
    public boolean updateItem(String id){
        for( int i=0; i< numOfItem; i++){
            if(list[i].getId().equalsIgnoreCase(id)){
                System.out.println("Item found! Please enter new information: ");
                list[i].input();
                return true;
            }
        }
        System.out.println("Item with ID '"+ id + "' not found.");
        return false;
    }

    public void didssplayItemsByType(String type){

    }
}
