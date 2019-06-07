package Classes;
import java.sql.Date;

public class Insurance extends EventsWithExpirationDate {

	private String type;
	private double policyNumber;
	private Date expirationDate;
	private String description;
	
	public Insurance(String type, double policyNumber, Date expirationDate, String description,
			String course, String price, Date dateOfEvent, int vehicleId) {
			this.type = type;
			this.policyNumber = policyNumber;
			this.expirationDate = expirationDate;
			this.description = description;
			this.course = course;
			this.price = price;
			this.dateOfEvent = dateOfEvent;
			this.vehicleId = vehicleId;
	}

	public String getType() {
		return type;
	}

	public double getPolicyNumber() {
		return policyNumber;
	}
	
	@Override
	public Date getExpirationDate() {
		return expirationDate;
	}

	public String getDescription() {
		return description;
	}	
	
}
