package Classes;
import java.sql.Date;

public class Refuelling extends EventProperties {

	private double amountOfFuel;
	
	public Refuelling(double course, double price, double amountOfFuel, Date dateOfEvent) {
			this.course = course;
			this.price = price;
			this.amountOfFuel = amountOfFuel;
			this.dateOfEvent = dateOfEvent;
	}
	

	public double getAmountOfFuel() {
		return amountOfFuel;
	};
	
	
}
