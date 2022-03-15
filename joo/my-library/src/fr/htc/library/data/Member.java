package fr.htc.library.data;
import java.util.Map;
public class Member {
	private static /* static : => variable globale */ int cpt = 100;
	private String matricule;
	private String firstName;
	private String lastName;
	private int age;

	public Member(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.matricule = generateMatricule();

	}

	private String generateMatricule() {

		return ((this.lastName == null || this.lastName.isEmpty() ? "X" :this.lastName.substring(0,1))
				+ (this.firstName == null || this.firstName.isEmpty() ? "Y" :this.firstName.substring(0,1)) +cpt++).toUpperCase();
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
	String[] arrBook = new String[3];
	

}
