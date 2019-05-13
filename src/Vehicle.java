
public class Vehicle implements IVehicle {

	private int vehicleId;
	private String vehicleType;
	private String mark;
	private String model;
	private double course;
	private int yearOfProduction;
	private double engineCapacity;
	private double power;
	private String fuelType;
	private int load;
	private String imageUrl;
	private String registrationNumber;
	
	public Vehicle(int vehicleId, String vehicleType, String mark,	String model,double course, 
					int yearOfProduction, double engineCapacity, double power,
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
	public double getCourse() {
		return course;
	}

	@Override
	public void setCourse(double course) {
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
	public double getEngineCapacity() {
		return engineCapacity;
	}

	@Override
	public double getPower() {
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
