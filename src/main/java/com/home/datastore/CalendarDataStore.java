package com.home.datastore;

import com.home.common.Event;

public interface CalendarDataStore {

    void publish(Event event);

    Event remove(String title);

    Event getEvent(String title);
}
