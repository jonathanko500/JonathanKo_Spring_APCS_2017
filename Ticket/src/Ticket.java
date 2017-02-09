
public abstract class Ticket {
	private int ticketNumber;
	private double price;
	public double getPrice(){
		return price;
	}
	public String toString() {
		return ("Number : " +  ticketNumber + "Price : " + price);
	}
}
