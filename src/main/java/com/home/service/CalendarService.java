package com.home.service;

import com.home.common.Event;
import com.home.common.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public interface CalendarService extends Remote{

    Event createEvent(String title, String description, List<Person> attenders) throws RemoteException;

    void addEvent(Event event) throws RemoteException;

    Event removeEvent(String title) throws RemoteException;

    Event addAttenders(String title, List<Person> attenders);

    Event searchEvent(String title) throws RemoteException;

    ArrayList<Event> searchEventsForPerson(Person person, GregorianCalendar time) throws RemoteException;

    boolean freePersonInCurrentTime(Person person, GregorianCalendar time) throws RemoteException;

    ArrayList<Event> searchEventsByTitleAndAttenders(String title, String mails) throws RemoteException;
}
