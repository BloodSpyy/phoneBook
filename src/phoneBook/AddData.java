package phoneBook;

import java.util.Scanner;

public class AddData {

	public static String[] addContactData(Scanner scanner) {
		
		System.out.print("Введите имя:\s");
		String name = scanner.next();
		
		System.out.print("Введите фамилию:\s");
		String surname = scanner.next();

		System.out.print("Введите номер:\s");
		String number = scanner.next();
		
		System.out.print("Введите группу:\s");
		String group = scanner.next();
		
		String[] contactsData = {name, surname, number, group};
		
		System.out.println();
		
		System.out.println("Контакт добавлен");
		
		System.out.println();
		
		return contactsData;
	}
	
	public static String addNameDataBase(Scanner scanner) {
		System.out.print("Введите название базы данных с расширением:\s");
		String name = scanner.next();
		System.out.println();
		
		return name;
	}
	
	public static String addNumber(Scanner scanner) {
		System.out.print("Введите номер:\s");
		String number = scanner.next();
		System.out.println();
		
		return number;
	}
}