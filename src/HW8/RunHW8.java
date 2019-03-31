package HW8;

public class RunHW8 {

	public static void main(String[] args) {
		PublisherImplementation pub = new PublisherImplementation();
		
		Observer subOdds = new SubscriberOdds();
		Observer subEvens = new SubscriberEvens();
		Observer subThrees = new SubscriberThrees();

		pub.registerObserver(subOdds);
		pub.registerObserver(subEvens);
		pub.registerObserver(subThrees);
		
		pub.runSimulation();
	}

}
