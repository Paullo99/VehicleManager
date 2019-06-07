package Classes;
import java.sql.Date;

public abstract class EventProperties {

	protected String course;
	protected String price;
	protected java.util.Date dateOfEvent;
	protected int vehicleId;
	
	
	public String getCourse() {
		return course;
	}
	public String getPrice() {
		return price;
	}
	public java.util.Date getDateOfEvent() {
		return dateOfEvent;
	}
	public int getVehicleId() {
		return vehicleId;
	}
}
