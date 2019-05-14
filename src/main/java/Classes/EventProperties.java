package Classes;
import java.sql.Date;

public abstract class EventProperties {

	protected double course;
	protected double price;
	protected Date dateOfEvent;
	protected int vehicleId;
	
	
	public double getCourse() {
		return course;
	}
	public double getPrice() {
		return price;
	}
	public Date getDateOfEvent() {
		return dateOfEvent;
	}
	public int getVehicleId() {
		return vehicleId;
	}
}
