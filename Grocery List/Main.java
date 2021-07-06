package academy.bentilzone;


import java.util.Scanner;

public class Main {
    private static GroceryList myGrocery = new GroceryList();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit){
            System.out.println("Enter your option: ");
            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
            }else {
                System.out.println("Enter a number from the option above!");
            }
            scanner.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    myGrocery.printList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();

                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }

    }
    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add item to grocery");
        System.out.println("\t 3 - To modify an item in grocery");
        System.out.println("\t 4 - To remove an item from grocery list");
        System.out.println("\t 5 - To search for an item in grocery");
        System.out.println("\t 6 - To quit application");
    }
    public static void addItem(){
        System.out.println("Enter an item to add: ");
        myGrocery.addList(scanner.nextLine());
    }
    public static void modifyItem(){
        System.out.println("Enter item name: ");
        String item = scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        myGrocery.modifyListItem(item, newItem);
    }
    public static void removeItem(){
        System.out.println("Enter item to remove: ");
        String item = scanner.nextLine();
            myGrocery.removeItem(item);
    }

    public static void searchForItem(){
        System.out.println("Enter an item to search: ");
        String item = scanner.nextLine();
        if(myGrocery.inList(item)){
            System.out.println("Found "+item+" in our grocery list" );
        }else {
            System.out.println(item+" is not in our grocery list!");
        }
    }
}
