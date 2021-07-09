package academy.bentilzone;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Phone phone = new Phone("PHONE_NAME");
    public static void main(String[] args) {
	    boolean switchedOff = false;
	    startPhone();
	    while (switchedOff!= true){
            System.out.println("Enter action: (6 to print available actions)");
            int action = scanner.nextInt();
            switch (action){
                case 0:
                    System.out.println(phone.getPhoneName()+" Shutting down..........");
                    switchedOff = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                   queryContact();
                   break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void startPhone(){
        System.out.println(phone.getPhoneName()+" Started..............");
    }
    private static void printActions(){
        System.out.println("\n Available actions: \npress");
        System.out.println(" 0 - To shutdown"+
                            "\n 1 - To print all contacts"+
                            "\n 2 - To add new contact"+
                            "\n 3 - To update existing contact"+
                            "\n 4 - To delete a contact"+
                            "\n 5 - To search for contact"+
                            "\n 6 - To print available options");
        System.out.println("Choose your action: ");
    }
    public static void printContacts(){
        phone.printContacts();
    }
    public static void addNewContact(){
        System.out.println("Enter contact name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        System.out.println("Enter contact phone number: ");
        scanner.nextLine();
        String number = scanner.nextLine();
        Contacts contact = Contacts.addNewContact(name, age, number);
        if(phone.addContact(contact)){
            System.out.println("New contact added. name: "+ name+", Age: "+age+ ", number: "+ number);
        }else {
            System.out.println("Cannot add. '"+name+"' already in phonebook.");
        }
    }
    public static void updateContact(){
        System.out.println("Enter contact name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        Contacts oldContact = phone.queryContact(name);
        if(oldContact !=null){
            System.out.println("Enter new contact name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            System.out.println("Enter new contact phone number: ");
            scanner.nextLine();
            String number = scanner.nextLine();
            Contacts newContact = Contacts.addNewContact(newName, age, number);
            if(phone.updateContact(oldContact, newContact)){
                System.out.println("Contact updated successfully");
            }else {
                System.out.println("Failed to update contact");
            }
        }else {
            System.out.println("Contact not found!");
        }
    }
    public static void deleteContact(){
        System.out.println("Enter contact name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        Contacts contact = phone.queryContact(name);
        if(contact !=null){
            if(phone.removeContact(contact)){
                System.out.println("Contact Deleted successfully");
            }else {
                System.out.println("Failed to delete contact");
            }
        }else {
            System.out.println("Contact not found!");
        }
    }
    public static void queryContact(){
        System.out.println("Enter contact name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        Contacts contact = phone.queryContact(name);
        if(contact !=null){
            System.out.println("Contact found");
            System.out.println("Name: "+contact.getName()+ "--> Number: "+contact.getNumber());
        }else {
            System.out.println("Contact does not exist!");
        }
    }
}
