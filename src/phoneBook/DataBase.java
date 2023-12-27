package phoneBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {

	public DataBase(String name) throws IOException {
		this.name = name;

		File dataBase = new File(this.name);
		dataBase.createNewFile();
	}

	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void deleteDataBase() {
		File dataBase = new File(name);
		dataBase.delete();
	}
	
	public Map<String, Contact> read() throws NumberFormatException, IOException {
		Map<String, Contact> contacts = new HashMap<>();
		
		BufferedReader reader = new BufferedReader(new FileReader(name));	
		String line;
		
		while ((line = reader.readLine()) != null) {
			String[] arrayContact = line.split("\s");
			
			String number = arrayContact[2];
			Contact contact = new Contact(arrayContact);

			contacts.put(number, contact);
		}
		
		reader.close();	

		return contacts;
	}
	
	public void write(Map<String, Contact> contacts) throws IOException {
		FileWriter writerToFile = new FileWriter(name, true);
		
		List<Contact> contactsCollection = new ArrayList<>(contacts.values());
		
		for(int i = 0; i < contactsCollection.size(); i++) {
			Contact contact = contactsCollection.get(i);
			writerToFile.write(contact.getName() + "\s" + contact.getSurname() + "\s" + contact.getNumber() + "\s" + contact.getGroup() + "\n");
		}
		
		writerToFile.close();
	}
}
