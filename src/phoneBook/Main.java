package phoneBook;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		Contacts contacts = new Contacts(AddData.addNameDataBase(scanner));
			
		boolean exit = false;
		
		while(!exit) {
			Menu.getMenu();
			int chooseItem = Menu.getChooseItem(scanner);
		
			if(chooseItem == 1) {
				contacts.addContact(new Contact(AddData.addContactData(scanner)));
			}
			else if(chooseItem == 2) {
				contacts.remove(AddData.addNumber(scanner));
			}
			else if(chooseItem == 3) {
				contacts.print(AddData.addNumber(scanner));
			}
			else if(chooseItem == 4) {
				contacts.printAllContact();
			}
			else if(chooseItem == 5) {
				contacts.clear();
			}
			else if(chooseItem == 6) {
				exit = true;
			}
		}
		
		System.out.println("Спасибо за использование!");
		
		contacts.write(contacts.getContacts());

		scanner.close();
	}


}
