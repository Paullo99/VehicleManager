package Classes;
import java.sql.Date;

public class PhysicalUser extends Profile {

	private String name;
	private String surname;
	private Date dateOfBirth;
	private String pesel;
	
	/*
	 * Konstruktor obiektu Physical User
	 */
	public PhysicalUser(String name, String surname, Date dateOfBirth, String pesel,
			String phone, String email, String country, String city, String street,
			int numberOfBuilding, String postCode, String login, String password) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.pesel = pesel;
		this.phone = phone;
		this.email = email;
		this.country = country;
		this.city = city;
		this.street = street;
		this.numberOfBuilding = numberOfBuilding;
		this.postCode = postCode;
		this.login = login;
		this.password = password;
		
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPesel() {
		return pesel;
	}
}
