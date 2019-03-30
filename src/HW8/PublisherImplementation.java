package HW8;

import java.util.*;

public class PublisherImplementation implements PublisherInterface {

	public PublisherImplementation() {
	}

	private List<Observer> subscribers = new ArrayList<Observer>();

	@Override
	public void registerObserver(Observer O) {
		subscribers.add(O);
		System.out.println(" Observer is registered");
	}

	@Override
	public void removeObserver(Observer O) {
		subscribers.remove(O);
		System.out.println(" Observer is removed");

	}

	@Override
	public void notifyObserver(Observer O) {
		// TODO Auto-generated method stub
	}

	public void notifyobserver(Event e) {

	}

	private Event generateevent(int i) {
		int data = (int) (Math.random() * 5000 + 1);
		Event e = new Event(i, data);
		return e;
	}

	public void runSimulation() {
		PublisherImplementation pub = new PublisherImplementation();
		Observer subOdds = new SubscriberOdds();
		Observer subEvens = new SubscriberEvens();
		Observer subThrees = new SubscriberThrees();

		pub.registerObserver(subOdds);
		pub.registerObserver(subEvens);
		pub.registerObserver(subThrees);

		int oddCount = 0;
		int threeCount = 0;
		boolean odd = false, three = false;
		for (int i = 1; i < 201; i++) {
			Event eventRandom = pub.generateevent(i);

			pub.notifyobserver(eventRandom);

			if (pub.subscribers.contains(subOdds)) {
				odd = subOdds.notifyObserver(eventRandom);
			}

			if (pub.subscribers.contains(subThrees)) {
				three = subThrees.notifyObserver(eventRandom);
			}

			boolean even = subEvens.notifyObserver(eventRandom);

			if (odd && pub.subscribers.contains(subOdds)) {
				if (oddCount >= 20) {
					pub.removeObserver(subOdds);
					System.out.println("The Subscriber Odds is removed because it is assigned to more than 20 events \n");
					oddCount = 0;

				} else {
					oddCount += 1;
					System.out.printf(" This event is %d Subscriber Odds ", oddCount, " \n ");

				}

			}

			if (three && pub.subscribers.contains(subThrees)) {

				if (threeCount >= 6) {
					pub.removeObserver(subThrees);
					System.out.println("The Subscriber Threes is removed because it is assigned to more than 6 events \n");
					threeCount = 0;
				} else {

					threeCount += 1;
					System.out.printf(" This event is %d Subscriber Three ", threeCount, " \n ");
				}

			}

			if (i == 40 || i == 80 || i == 160 || i == 120 || i == 200) {
				if (pub.subscribers.contains(subOdds) == false) {
					pub.registerObserver(subOdds);
					System.out.printf("The Subscriber Odds is re-registred at the event number %d ", i, " \n ");
				}

				if (pub.subscribers.contains(subThrees) == false) {
					pub.registerObserver(subThrees);
					System.out.printf("The Subscriber Threes is re-registred at the event number %d", i, " \n ");
				}

			}

		}

	}

}