package com.home.service;

import com.home.common.Event;
import com.home.common.Person;
import com.home.datastore.CalendarDataStore;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class CalendarServiceImpl implements CalendarService{

    private final CalendarDataStore calendarDataStore;

    public CalendarServiceImpl(CalendarDataStore calendarDataStore){
        this.calendarDataStore = calendarDataStore;
    }

    @Override
    public Event createEvent(String title, String description, List<Person> attenders)  throws RemoteException {
        return new Event.Builder() .title(title) .description(description) .attenders(attenders) .build();
    }

    @Override
    public void addEvent(Event event) throws RemoteException {
        calendarDataStore.publish(event);
    }

    @Override
    public Event removeEvent(String title) throws RemoteException {
        return calendarDataStore.remove(title);
    }

    @Override
    public Event searchEvent(String title) throws RemoteException {
        return calendarDataStore.getEvent(title);
    }

    @Override
    public ArrayList<Event> searchEventForPerson(Person person, GregorianCalendar time) throws RemoteException {
        return calendarDataStore.searchEventForPerson(person, time);
    }

    @Override
    public boolean freePersonInCurrentTime(Person person, GregorianCalendar time) throws RemoteException {
        return calendarDataStore.freePersonInCurrentTime(person, time);
    }

    @Override
    public ArrayList<GregorianCalendar> theRightTimeForTheEvent(Person person) throws RemoteException {
        return null;//under construction
    }
}
