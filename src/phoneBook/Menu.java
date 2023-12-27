package phoneBook;

import java.util.Scanner;

public class Menu {
	public static void getMenu() {
		String[] menuButtons = {"Добавить контакт", "Удалить контакт", "Найти контакт", "Вывести все контакты", "Очистить контакты", "Выход"};

		System.out.print("\tМеню\n");

		for(int i = 0; i < menuButtons.length; i++) {
			System.out.printf("%d. %s\n", i + 1, menuButtons[i]);
		}
		
		System.out.println();
	}

	public static int getChooseItem(Scanner scanner) {
		System.out.print("Выберите один из пунктов:\s");
		
	    int chooseItem = scanner.nextInt();
	    
	    System.out.println();
	    
	    return chooseItem;
	}
}
