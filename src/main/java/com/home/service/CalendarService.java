package com.home.service;

import com.home.common.Event;
import com.home.common.Person;

import java.util.List;

public interface CalendarService {

    Event createEvent(String title, String description, List<Person> attenders);

    void addEvent(Event event);

    Event removeEvent(String title);

    Event searchEvent(String title);
}
