package HW8;

public class SubscriberOdds implements Observer {
	
	public boolean notifyObserver(Event e) {
		if (e.getEventData() % 2 != 0) {
			String message = String.format("Event %d is odd: %d", e.getEventNumber(), e.getEventData());
			System.out.println(message);
			return true;
		}
		else return false;
	}
}
