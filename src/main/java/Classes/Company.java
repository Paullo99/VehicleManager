package Classes;

public class Company extends Profile {

	private String name;
	private int nip;
	
	//Konstruktor
	public Company(String name, int nip, String phone, String email, String country,
			String city, String street,	int numberOfBuilding, String postCode) {
		this.name = name;
		this.nip = nip;
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

	public double getNip() {
		return nip;
	}
		
}
