package HW8;

import java.util.*;

public class Event {

	private int eventnumber;
	private int eventdata;

	public Event(int eventnumber, int eventdata) {
		this.eventdata = eventdata;
		this.eventnumber = eventnumber;

	}

	public int getEventData() {

		return eventdata;
	}

	public int getEventNumber() {

		return eventnumber;
	}

}