package HW8;

import java.util.*;

public class PublisherImplementation implements PublisherInterface {

	private List<Observer> subscribers = new ArrayList<Observer>();

	public PublisherImplementation() {
	}

	public void registerObserver(Observer o) {
		subscribers.add(o);
	}

	public void removeObserver(Observer o) {
		subscribers.remove(o);
	}

	// not sure how to implement these
	// might just leave them, as they seem to not be needed
	public void notifyObservers(Observer o) {
	}

	public void notifyObserver(Event e) {
	}

	private Event generateEvent(int i) {
		int data = (int) (Math.random() * 5000 + 1);
		Event e = new Event(i, data);
		return e;
	}

	public void runSimulation() {
		int oddCount = 0;
		int threeCount = 0;
		Integer[] arr = { 40, 80, 120, 160, 200 };
		List<Integer> iterationStops = Arrays.asList(arr);
		boolean status = false;

		for (int i = 1; i < 201; i++) {
			Event eventRandom = generateEvent(i);
			List<Observer> rmObserver = new ArrayList<Observer>();
			List<Observer> addObserver = new ArrayList<Observer>();

			for (Observer o : subscribers) {
				status = o.notifyObserver(eventRandom);

				if (status && o.getClass() == SubscriberOdds.class) {
					if (oddCount >= 20) {
						rmObserver.add(o);
						System.out.println("\tSubscriberOdds unregistered: assigned to 20 events");
					} else {
						oddCount += 1;
						System.out.printf("\tOdd event count: %d\n", oddCount);
					}
				} else if (status && o.getClass() == SubscriberThrees.class) {
					if (threeCount >= 6) {
						rmObserver.add(o);
						System.out.println("\tSubscriberThrees unregistered: assigned to 6 events");
					} else {
						threeCount += 1;
						System.out.printf("\tThrees event count: %d\n", threeCount);
					}
				} else if (iterationStops.contains(i) && o.getClass() == SubscriberEvens.class) {
					if (oddCount >= 20) {
						addObserver.add(new SubscriberOdds());
						System.out.printf("\tEvent %d: SubscriberOdds re-registred\n", i);
						oddCount = 0;
					}
					if (threeCount >= 6) {
						addObserver.add(new SubscriberThrees());
						System.out.printf("\tEvent %d: SubscriberThrees re-registred\n", i);
						threeCount = 0;
					}
				}
			}

			if (!rmObserver.isEmpty()) {
				for (Observer o : rmObserver) {
					removeObserver(o);
				}
			}

			if (!addObserver.isEmpty()) {
				for (Observer o : addObserver) {
					registerObserver(o);
				}
			}
		}
	}
}