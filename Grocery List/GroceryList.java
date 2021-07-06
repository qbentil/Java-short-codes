package academy.bentilzone;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> myList = new ArrayList<String>();

    public void addList(String item){
        myList.add(item);
        System.out.println(item+" added to Store");
    }

    public void printList(){
        System.out.println("You have "+ myList.size()+ " items in your grocery list");
        for(int i = 0; i< myList.size(); i++){
            System.out.println(i+1 +". "+ myList.get(i));
        }
    }
    public void modifyListItem(String item, String newItem){
        int position = getItemPosition(item);
        if(position >=0){
            modifyListItem(position, newItem);
        }else {
            System.out.println("Item not found!");
        }
    }
    private void modifyListItem(int position, String newItem){
        if(myList.size() > position){
            myList.set(position, newItem);
            System.out.println("Grocery item "+ (position+1) +" has been modified");
        }else {
            System.out.println("Item "+ (position+1)+" not found!");
//            addList(newItem);
        }
    }
    private  String findItem(String item){
        boolean exists =  myList.contains(item);
        int position = myList.indexOf(item);
        if(position >= 0){
            return myList.get(position);
        }
        return null;
    }
    public void removeItem(String item){
        int position = getItemPosition(item);
        if(position >=0){
            removeItem(position);
        }else {
            System.out.println("Item not found!");
        }
    }
    private void removeItem(int position){
        String myItem = myList.get(position);
        if(findItem(myItem) !=null){
            myList.remove(myItem);
            System.out.println(myItem+ " has been removed from grocery list");
        }else {
            System.out.println("Item to remove not found");
        }
    }
    private int getItemPosition(String item){
        return myList.indexOf(item);
    }
    public boolean inList(String item){
        int position = getItemPosition(item);
        if(position >=0){
            return true;
        }
        return false;
    }
}
