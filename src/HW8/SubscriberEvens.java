package HW8;

public class SubscriberEvens implements Observer {

	public boolean notifyObserver(Event e) {
		if (e.getEventData() % 2 == 0) {
			String message = String.format("Event %d is even: %d", e.getEventNumber(), e.getEventData());
			System.out.println(message);
			return true;
		}
		else return false;
	}
}
