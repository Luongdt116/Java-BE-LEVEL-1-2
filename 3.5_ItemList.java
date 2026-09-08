package Lab03;

import java.util.List;

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
            if(list[i] != null && list[i].getCreator() != null && list[i].getCreator().equalsIgnoreCase(creator)){
                return list[i];
            }
        }
        return null;
    }

    public int findIndexByID(String Id){
        if(Id == null || Id.isEmpty()){
            return -1;
        }
        for(int i = 0; i < numOfItem; i++){
            if(list[i] != null && list[i].getId() != null && list[i].getId().equalsIgnoreCase(Id)){
                return i;
            }
        }
        return -1;
    }

    public Item getItemById(String id){
       int index = findIndexByID(id);
       if(index != -1){
           return list[index];
       }
        return null;
    }


    public void displayItemsByType(String type){
        if(type == null || type.isEmpty()){
            System.out.println("Type cannot be empty!.");
            return;
        }

        if ("vase".equalsIgnoreCase(type)) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Vase) {
                    System.out.println(list[i].toString());
                }
            }
        } else if ("statue".equalsIgnoreCase(type)) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Statue) {
                    System.out.println(list[i].toString());
                }
            }
        } else if ("painting".equalsIgnoreCase(type)) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Painting) {
                    System.out.println(list[i].toString());
                }
            }
        } else {
            System.out.println("Invalid type. Please enter Vase, Statue, or Painting.");
        }

    }

    //remove
    public boolean deleteItem(String id){
        int index = findIndexByID(id);

        if(index == -1){
            return false;
        }
        for(int j = index; j < numOfItem - 1; j++){
            list[j] = list[j+1];
        }
        numOfItem --;
        list[numOfItem] = null;
        return true;
    }
}
