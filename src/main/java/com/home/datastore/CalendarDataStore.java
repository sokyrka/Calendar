package com.home.datastore;

import com.home.common.Event;
import com.home.common.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface CalendarDataStore {

    void publish(Event event);

    Event remove(String title);

    Event getEvent(String title);

    ArrayList<Event> searchEventForPerson(Person person, GregorianCalendar time);

    boolean freePersonInCurrentTime(Person person, GregorianCalendar time);

    ArrayList<GregorianCalendar> theRightTimeForTheEvent(Person person);
}
