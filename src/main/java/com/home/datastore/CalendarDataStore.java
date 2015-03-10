package com.home.datastore;

import com.home.common.Event;
import com.home.common.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public interface CalendarDataStore {

    void publish(Event event);

    Event remove(String title);

    Event addAttenders(String title, List<Person> attenders);

    Event getEvent(String title);

    ArrayList<Event> searchEventsForPerson(Person person, GregorianCalendar time);

    boolean freePersonInCurrentTime(Person person, GregorianCalendar time);

    ArrayList<Event> searchEventsByTitleAndAttenders(String title, String mail);
}
