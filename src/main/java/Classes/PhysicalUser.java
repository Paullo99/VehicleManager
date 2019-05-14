package Classes;
import java.sql.Date;

public class PhysicalUser extends Profile {

	private String name;
	private String surname;
	private Date dateOfBirth;
	private double pesel;
	
	public PhysicalUser(String name, String surname, Date dateOfBirth, double pesel,
			double phone, String email, String country, String city, String street,
			int numberOfBuilding, String postCode) {
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

	public double getPesel() {
		return pesel;
	}
}
