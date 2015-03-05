package com.home.datastore;

import com.home.common.Event;
import com.home.common.Person;

import java.util.*;

public class CalendarDataStoreImpl implements CalendarDataStore {

    private final HashMap<String, Event> store = new HashMap<String, Event>();

    @Override
    public void publish(Event event) {
        store.put(event.getTitle(), event);
    }

    @Override
    public Event remove(String title) {
        return store.remove(title);
    }

    @Override
    public Event getEvent(String title) {
        return store.get(title);
    }

    @Override
    public ArrayList<Event> searchEventsForPerson(Person person, GregorianCalendar time){
        ArrayList<Event> eventArrayList = new ArrayList<Event>();
        for(Map.Entry<String, Event> entry : store.entrySet()){
            Event value = entry.getValue();
            for(Person personInStore : value.getAttenders()){
                if(personInStore.getEmail().equals(person.getEmail()) &&
                        (value.getStartDate().getTimeInMillis() <= time.getTimeInMillis() &&
                                value.getEndDate().getTimeInMillis() >= time.getTimeInMillis())){
                    eventArrayList.add(value);
                }
            }
        }
        return eventArrayList;
    }

    @Override
    public boolean freePersonInCurrentTime(Person person, GregorianCalendar time){
        boolean result = true;
        for(Map.Entry<String, Event> entry : store.entrySet()) {
            Event value = entry.getValue();
            for(Person personInStore : value.getAttenders()){
                if(personInStore.getEmail().equals(person.getEmail()) && (value.getStartDate().getTimeInMillis() <= time.getTimeInMillis() && value.getEndDate().getTimeInMillis() >= time.getTimeInMillis())){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public ArrayList<Event> searchEventsByTitleAndAttenders(String title, String mails){
        ArrayList<Event> eventArrayList = new ArrayList<>();
        for(Map.Entry<String, Event> entry : store.entrySet()){
            Event event = entry.getValue();
            for(Person p : event.getAttenders()){
                if(p.getEmail().equals(mails) && event.getTitle().equals(title)){
                    eventArrayList.add(event);}
            }
        }
        return eventArrayList;
    }
}
