package HW8;

import java.util.*;

public class PublisherImplementation implements PublisherInterface {

	public PublisherImplementation() {
	}

	private List<Observer> subscribers = new ArrayList<Observer>();

	@Override
	public void registerObserver(Observer O) {
		// TODO Auto-generated method stub
		subscribers.add(O);
		System.out.println(" observer is registered");
	}

	@Override
	public void removeObserver(Observer O) {
		// TODO Auto-generated method stub

		subscribers.remove(O);
		System.out.println(" observer is removed");

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

	public void runsimulation() {
		PublisherImplementation pub = new PublisherImplementation();
		Observer Odds = new SubscriberOdds();
		Observer Evens = new SubscriberEvens();
		Observer Threes = new SubscriberThrees();

		pub.registerObserver(Odds);
		pub.registerObserver(Evens);
		pub.registerObserver(Threes);

		int odd_count = 0;
		int three_count = 0;
		boolean odd = false, three = false;
		for (int i = 1; i < 201; i++) {
			Event event_random = pub.generateevent(i);

			pub.notifyobserver(event_random);

			if (pub.subscribers.contains(Odds)) {
				odd = Odds.notifyobserver(event_random);
			}

			if (pub.subscribers.contains(Threes)) {
				three = Threes.notifyobserver(event_random);
			}

			boolean even = Evens.notifyobserver(event_random);

			if (odd && pub.subscribers.contains(Odds)) {
				if (odd_count >= 20) {
					pub.removeObserver(Odds);
					System.out
							.println("The SubScriber Odds is removed because it is assigned to more than 20events \n");
					odd_count = 0;

				} else {
					odd_count = odd_count + 1;
					System.out.printf(" This event is %d Subscriber Odds ", odd_count, " \n ");

				}

			}

			if (three && pub.subscribers.contains(Threes)) {

				if (three_count >= 6) {
					pub.removeObserver(Threes);
					System.out.println(
							"The SubScriber Threes is removed because it is assigned to more than 6 events \n");
					three_count = 0;
				} else {

					three_count = three_count + 1;
					System.out.printf(" This event is %d Subscriber Three ", three_count, " \n ");
				}

			}

			if (i == 40 || i == 80 || i == 160 || i == 120 || i == 200) {
				if (pub.subscribers.contains(Odds) == false) {
					pub.registerObserver(Odds);
					System.out.printf("The SubScriber Odds is re-registred at the event number %d ", i, " \n ");
				}

				if (pub.subscribers.contains(Threes) == false) {
					pub.registerObserver(Threes);
					System.out.printf("The SubScriber Threes is re-registred at the event number %d", i, " \n ");
				}

			}

		}

	}

}