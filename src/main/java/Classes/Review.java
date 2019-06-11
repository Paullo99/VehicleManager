package Classes;
import java.util.Date;

public class Review extends EventsWithExpirationDate {
	
	private boolean isPassed;
	private Date expirationDate;
	private String notices;

	/**
	 * Konstruktor obiektu Review
	 */
	public Review(boolean isPassed, Date date, String notices,
			String course, String price, Date date2, int vehicleId) {
			this.isPassed = isPassed;
			this.expirationDate = date;
			this.notices = notices;
			this.course = course;
			this.price = price;
			this.dateOfEvent = date2;
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
