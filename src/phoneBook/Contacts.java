package phoneBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Contacts extends DataBase{
	
	public Contacts(String name) throws IOException {
		super(name);
		contacts = super.read();
	}

	Map<String, Contact> contacts;

	public void addContact(Contact contact) {
		contacts.put(contact.getNumber(), contact);
	}
	
	public Map<String, Contact> getContacts() {
		return contacts;
	}
	
	public void print(String number) {
		if(!contacts.containsKey(number)){
			System.out.println("Контакт не найден");
			System.out.println();
		}
		else {
			System.out.println(contacts.get(number));
		}
	}
	
	public void remove(String number) {
		contacts.remove(number);
		super.deleteDataBase();
		System.out.println("Контакт удалён");
		System.out.println();
	}
	
	public void clear() {
		contacts.clear();
		super.deleteDataBase();
		System.out.println("Контакты очищены");
		System.out.println();
	}
	
	public void printAllContact() {
		if(contacts.size() == 0) {
			System.out.println("Контакты отсутствуют");
			System.out.println();
		}
		
		List<Contact> contactsCollection = new ArrayList<>(contacts.values());
		
		for(int i = 0; i < contactsCollection.size(); i++) {
			System.out.println(contactsCollection.get(i));
		}
	}
}
