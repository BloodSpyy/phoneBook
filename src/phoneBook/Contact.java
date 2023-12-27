package phoneBook;

import java.util.Objects;

public class Contact {

	private String name;
	private String surname;
	private String number;
	private String group;
	
	public Contact(String[] contactsData) {
		this.name = contactsData[0];
		this.surname = contactsData[1];
		this.number = contactsData[2];
		this.group = contactsData[3];
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		return "Имя:\s" + name + "\n" + "Фамилия:\s" + surname + "\n" + "Номер телефона:\s" + number + "\n" + "Группа:\s" + group + "\n";
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Contact otherContact = (Contact) o;
		
		return Objects.equals(this.number, otherContact.number) && Objects.equals(this.name, otherContact.name) && Objects.equals(this.surname, otherContact.surname);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(number, name, group, surname);
	}
}