package fr.htc.library.data;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private static int cpt = 100;
	private static final int MAX_BOOK = 3;
	private String matricule;
	private String firstName;
	private String lastName;
	private int age;

	private List<Book> checkedOutBooks = new ArrayList<Book>();

	public Member(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.matricule = this.generateMatricule();

	}

	public boolean addBook(Book book) {

		return checkedOutBooks.add(book);

	}

	public boolean deleteBook(Book book) {
		return checkedOutBooks.remove(book);
	}

	public boolean canCheckout() {
		if (this.checkedOutBooks.size() < MAX_BOOK) {
			System.out.println("you have made : " + checkedOutBooks.size() + 1 + "borrows");
			return true;
		}
		return false;
	}

	public boolean hasBook(String cote) {
		for (int i = 0; i < checkedOutBooks.size(); i++) {
			if (checkedOutBooks.get(i).getCote().equals(cote)) {
				return true;
			}
		}
		return false;
	}

	private String generateMatricule() {
		// NP101

		String n = (this.lastName == null || this.lastName.isEmpty()) ? "X" : this.lastName.substring(0, 1);
		String p = (this.firstName == null || this.firstName.isEmpty()) ? "X" : this.firstName.substring(0, 1);
		String mat = (n + p + cpt++);

		return mat.toUpperCase();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMatricule() {
		return matricule;
	}

	@Override
	public String toString() {
		return "Member [matricule=" + matricule + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ "]";
	}

}
