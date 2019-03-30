package HW8;

public class SubscriberThrees implements Observer {

	public boolean notifyObserver(Event e) {
		if (e.getEventData() % 3 != 0) {
			String message = String.format("Event %d is divisible by three: %d", e.getEventNumber(), e.getEventData());
			System.out.println(message);
			return true;
		}
		else return false;
	}
}
