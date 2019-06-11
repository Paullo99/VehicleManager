package Classes;

public class Company extends Profile {

	private String name;
	private String nip;
	
	/*
	 * Konstruktor obiektu Company
	 */
	public Company(String name, String nip, String phone, String email, String country,
			String city, String street,	int numberOfBuilding, String postCode, String login, String password) {
		this.name = name;
		this.nip = nip;
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

	public String getNip() {
		return nip;
	}
		
}
