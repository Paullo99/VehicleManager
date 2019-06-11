package Classes;

public class Vehicle implements IVehicle {

	private int vehicleId;
	private String vehicleType;
	private String mark;
	private String model;
	private String course;
	private int yearOfProduction;
	private String engineCapacity;
	private int power;
	private String fuelType;
	private int load;
	private String imageUrl;
	private String registrationNumber;
	
	/**
	 * Konstruktor obiektu Vehicle
	 */
	public Vehicle(int vehicleId, String vehicleType, String mark,	String model,String course, 
					int yearOfProduction, String engineCapacity, int power,
					String fuelType, int load, String imageUrl,	String registrationNumber) {
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.mark = mark;
		this.model = model;
		this.course = course;
		this.yearOfProduction = yearOfProduction;
		this.engineCapacity = engineCapacity;
		this.power = power;
		this.fuelType = fuelType;
		this.load = load;
		this.imageUrl = imageUrl;
		this.registrationNumber = registrationNumber;
		
	}

	@Override
	public String getCourse() {
		return course;
	}

	@Override
	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public int getVehicleId() {
		return vehicleId;
	}

	@Override
	public String getVehicleType() {
		return vehicleType;
	}

	@Override
	public String getMark() {
		return mark;
	}

	@Override
	public String getModel() {
		return model;
	}

	@Override
	public int getYearOfProduction() {
		return yearOfProduction;
	}

	@Override
	public String getEngineCapacity() {
		return engineCapacity;
	}

	@Override
	public int getPower() {
		return power;
	}

	@Override
	public String getFuelType() {
		return fuelType;
	}

	@Override
	public int getLoad() {
		return load;
	}

	@Override
	public String getImageUrl() {
		return imageUrl;
	}

	@Override
	public String getRegistrationNumber() {
		return registrationNumber;
	}

}
