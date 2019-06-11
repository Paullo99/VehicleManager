package Classes;
import java.util.Date;

public class Insurance extends EventsWithExpirationDate {

	private String type;
	private String policyNumber;
	private Date expirationDate;
	private String description;
	
	/*
	 * Konstruktor obiektu Insurance
	 */
	public Insurance(String type, String policyNumber, Date date, String description,
			String course, String price, Date date2, int vehicleId) {
			this.type = type;
			this.policyNumber = policyNumber;
			this.expirationDate = date;
			this.description = description;
			this.course = course;
			this.price = price;
			this.dateOfEvent = date2;
			this.vehicleId = vehicleId;
	}

	public String getType() {
		return type;
	}

	public String getPolicyNumber() {
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
