package com.home.datastore;

import com.home.common.Event;

import java.util.HashMap;

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
}
