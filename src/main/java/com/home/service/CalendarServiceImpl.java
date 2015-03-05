package com.home.service;

import com.home.common.Event;
import com.home.common.Person;
import com.home.datastore.CalendarDataStore;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class CalendarServiceImpl implements CalendarService{

    private final CalendarDataStore calendarDataStore;

    public CalendarServiceImpl(CalendarDataStore calendarDataStore){
        this.calendarDataStore = calendarDataStore;
    }

    @Override
    public Event createEvent(String title, String description, List<Person> attenders) {
        return new Event.Builder() .title(title) .description(description) .attenders(attenders) .build();
    }

    @Override
    public void addEvent(Event event) {
        calendarDataStore.publish(event);
    }

    @Override
    public Event removeEvent(String title) {
        return calendarDataStore.remove(title);
    }

    @Override
    public Event searchEvent(String title) {
        return calendarDataStore.getEvent(title);
    }

    @Override
    public ArrayList<Event> searchEventsForPerson(Person person, GregorianCalendar time) {
        return calendarDataStore.searchEventsForPerson(person, time);
    }

    @Override
    public boolean freePersonInCurrentTime(Person person, GregorianCalendar time) {
        return calendarDataStore.freePersonInCurrentTime(person, time);
    }

    @Override
    public ArrayList<Event> searchEventsByTitleAndAttenders(String title, String mails){
        return calendarDataStore.searchEventsByTitleAndAttenders(title, mails);
    }
}
