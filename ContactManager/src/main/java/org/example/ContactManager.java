package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ContactManager {
    static Map<String,String> contacts= new HashMap<>();
    static Set<Map.Entry<String,String>> entries=contacts.entrySet();
    public static void addContact(String name,String phone){
        contacts.put(name,phone);
    }
    public static void readContacts() {
        if(contacts.isEmpty()){
            System.out.println("Contact list is empty.");
        }
        else{
            System.out.println("Contact list contains:");
            for(var entry :entries){
                System.out.println(entry.getKey()+ " "+entry.getValue());
            }

        }}
    public static void updateContact(String name,String phone) {
        if (contacts.containsKey(name)) {
            contacts.put(name, phone);
            System.out.println("Contact updated");
        } else {
            System.out.println("Contact not found");
        }
    }
    public static void removeContact(String name,String phone) {
        if (contacts.containsKey(name)) {
            contacts.remove(name, phone);
            System.out.println("Contact removed");
        }else {
            System.out.println("Contact not found");
        }}
    public static void main(String[] args) {
            Scanner n = new Scanner(System.in);
            ContactManager C = new ContactManager();
            while(true){
                System.out.println("1.Add Contact/n"
                        + "2.Show Contact/n"
                        + "3.Update Contact/n"
                        + "4.Delete Contact/n");
                System.out.println("Enter your choice: ");
                int choice = n.nextInt();
                switch (choice) {
                    case 1:
                    {
                        String name = n.nextLine();
                        System.out.println("Enter your name: ");
                        String phone = n.nextLine();
                        System.out.println("Enter your phone number: ");
                        addContact(name,phone);
                        break;
                    }
                    case 2:{
                        readContacts();
                        break;
                    }
                    case 3:{
                        String name = n.nextLine();
                        System.out.println("Enter your name: ");
                        String phone = n.nextLine();
                        System.out.println("Enter your phone number: ");
                        updateContact(name,phone);
                        break;
                    }
                    case 4:{
                        String name = n.nextLine();
                        System.out.println("Enter your name: ");
                        String phone = n.nextLine();
                        System.out.println("Enter your phone number: ");
                        removeContact(name,phone);
                        break;
                    }
                    default:{
                        System.out.println("Invalid choice");
                        break;
                    }


                }
            }


}}
