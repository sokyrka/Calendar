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

    Event searchEvent(String title) throws RemoteException;

    ArrayList<Event> searchEventForPerson(Person person, GregorianCalendar time) throws RemoteException;

    boolean freePersonInCurrentTime(Person person, GregorianCalendar time) throws RemoteException;

    ArrayList<GregorianCalendar> theRightTimeForTheEvent(Person person) throws RemoteException;
}
