package com.home;

import com.home.common.Event;
import com.home.common.Person;
import com.home.service.CalendarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        CalendarService service = (CalendarService) context.getBean("calendarServiceImpl");

        Event event = new Event.Builder()
                .title("Beer Party")
                .description("Mega beer")
                .attenders(new ArrayList<Person>())
                .build();

        service.addEvent(event);

        System.out.println(service.searchEvent(event.getTitle()));
    }
}
