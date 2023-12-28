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

	public DataBase(String name){
		this.name = name;
	}

	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void deleteDataBase() {
		File dataBase = new File(name);
		dataBase.delete();
	}
	
	public Map<String, Contact> read() {
		Map<String, Contact> contacts = new HashMap<>();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(name));	
			String line;
		
			while ((line = reader.readLine()) != null) {
			String[] arrayContact = line.split("\s");
			
			String number = arrayContact[2];
			Contact contact = new Contact(arrayContact);

			contacts.put(number, contact);
			}
		} catch(IOException e) {
			System.out.println("База данных не найдена. Начинаю её создание.");
			System.out.println();
			File dataBase = new File(name);
			try {
				dataBase.createNewFile();
			} catch (IOException e1) {
				System.out.println("Не могу создать файл. Попробуйте ещё раз.");
				System.out.println();
				System.exit(1);
			}
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch(IOException e2) {
					System.out.print(e2.getMessage());
				}
			}
		}

		return contacts;
	}
	
	public void write(Map<String, Contact> contacts) {
		FileWriter writerToFile = null;

		try {
			writerToFile = new FileWriter(name, true);
		
			List<Contact> contactsCollection = new ArrayList<>(contacts.values());
		
			for(int i = 0; i < contactsCollection.size(); i++) {
				Contact contact = contactsCollection.get(i);
				writerToFile.write(contact.getName() + "\s" + contact.getSurname() + "\s" + contact.getNumber() + "\s" + contact.getGroup() + "\n");
			}
		} catch(IOException e){
			System.out.println(e.getMessage());
		} finally {
			if(writerToFile != null) {
				try {
					writerToFile.close();
				} catch(IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		}
	}
}
