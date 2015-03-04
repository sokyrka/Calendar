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
    public ArrayList<Event> searchEventForPerson(Person person, GregorianCalendar time){
        ArrayList<Event> eventArrayList = new ArrayList<Event>();

        for(Map.Entry<String, Event> entry : store.entrySet()){
            String key = entry.getKey();
            Event value = entry.getValue();
            for(Person personInStore : value.getAttenders()){
                if(personInStore.getEmail().equals(person.getEmail()) && (value.getStartDate().getTimeInMillis() <= time.getTimeInMillis() && value.getEndDate().getTimeInMillis() >= time.getTimeInMillis())){
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
            String key = entry.getKey();
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
    public ArrayList<GregorianCalendar> theRightTimeForTheEvent(Person person){
        ArrayList<GregorianCalendar> freeTime = new ArrayList<GregorianCalendar>();

        GregorianCalendar startDay = new GregorianCalendar();
        Date date = new Date();
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        startDay.setTime(date);
        long startDayInMillis = startDay.getTimeInMillis();

        for(int i = 0; i< 96; i++){
            startDayInMillis+=900000;
            if(freePersonInCurrentTime(person, startDay)){
                startDay.setTimeInMillis(startDayInMillis);
                freeTime.add(startDay);
            }
        }

        return freeTime;
    }
}
