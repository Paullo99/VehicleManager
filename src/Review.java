import java.sql.Date;

public class Review extends EventsWithExpirationDate {
	
	private boolean isPassed;
	private Date expirationDate;
	private String notices;

	public Review(boolean isPassed, Date expirationDate, String notices,
			double course, double price, Date dateOfEvent, int vehicleId) {
			this.isPassed = isPassed;
			this.expirationDate = expirationDate;
			this.notices = notices;
			this.course = course;
			this.price = price;
			this.dateOfEvent = dateOfEvent;
			this.vehicleId = vehicleId;
	}

	public boolean isPassed() {
		return isPassed;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public String getNotices() {
		return notices;
	}	
}
