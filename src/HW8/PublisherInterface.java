package HW8;

public interface PublisherInterface {

	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObservers(Observer o);
}
