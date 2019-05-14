package Classes;

public abstract class Profile implements IProfile {

	protected double phone;
	protected String email;
	protected String country;
	protected String city;
	protected String street;
	protected int numberOfBuilding;
	protected String postCode;
	
	@Override
	public double getPhone() {
		return phone;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public String getCountry() {
		return country;
	}
	
	@Override
	public String getCity() {
		return city;
	}
	
	@Override
	public String getStreet() {
		return street;
	}
	
	@Override
	public int getNumberOfBuilding() {
		return numberOfBuilding;
	}
	
	@Override
	public String getPostCode() {
		return postCode;
	}
}
