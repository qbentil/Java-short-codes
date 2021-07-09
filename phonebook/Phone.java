package academy.bentilzone;

import java.util.ArrayList;

public class Phone{
    private String phoneName;
    private ArrayList<Contacts> myContact;

    public String getPhoneName() {
        return phoneName;
    }

    public Phone(String phoneName){
        this.phoneName =phoneName;
        this.myContact = new ArrayList<Contacts>();
    }

    public boolean addContact(Contacts contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact already exist");
            return false;
        }
        myContact.add(contact);
        return true;
    }

    private int findContact(Contacts contacts){
        return myContact.indexOf(contacts);
    }
    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition< 0){
            System.out.println(oldContact.getName()+" was not found");
            return false;
        }
        int findNewContact = findContact(newContact.getName());
        if(findNewContact >=0){
            System.out.println("Contact with name '"+newContact.getName()+ "' already exists!");
            return false;
        }
        this.myContact.set(foundPosition, newContact);
        System.out.println(oldContact.getName()+ " was replaced with "+ newContact.getName());
        return true;
    }
    public boolean removeContact(Contacts contacts){
        int foundPosition = findContact(contacts);
        if(foundPosition< 0){
            System.out.println(contacts.getName()+" was not found");
            return false;
        }
        this.myContact.remove(contacts);
        System.out.println(contacts.getName()+ " has been deleted");
        return true;
    }
    public int findContact(String user){
        for(int i = 0; i<myContact.size(); i++){
            Contacts contacts = myContact.get(i);
            if(contacts.getName().toLowerCase().equals(user.toLowerCase())){
                return myContact.indexOf(contacts);
            }
        }
        return -1;
    }

    private String queryContact(Contacts contacts){
        if(findContact(contacts.getName()) >= 0){
            return contacts.getName();
        }
        return null;
    }
    public Contacts queryContact(String user){
        int position = findContact(user);
        if( position>= 0){
            return this.myContact.get(position);
        }
        return null;
    }
    public void printContacts(){
        if(myContact.size() > 0){
            System.out.println("Contact List");
            for(int i = 0; i < myContact.size(); i++){
                System.out.println((i+1)+ ". Name:"+
                        this.myContact.get(i).getName()+
                        "\t Age: "+this.myContact.get(i).getAge()+
                        "\t Number: "+this.myContact.get(i).getNumber());
            }
        }else {
            System.out.println("Phonebook is empty.");

        }
    }
}
