package com.home.controller;

import com.home.common.Event;
import com.home.common.Person;
import com.home.datastore.CalendarDataStoreImpl;
import com.home.service.CalendarServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {

    @RequestMapping(value = "/newEvent.html", method = RequestMethod.GET)
    public ModelAndView createEventForm(){
        ModelAndView modelAndView = new ModelAndView("NewEventForm");

        return modelAndView;
    }

    @RequestMapping(value = "/successEvent.html", method = RequestMethod.GET)
    public ModelAndView successCreateEvent(@RequestParam("title") String title,
                                           @RequestParam("description") String description,
                                           @RequestParam("attender") String name){

        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person.Builder().firstName(name).build());
        CalendarServiceImpl calendarService = new CalendarServiceImpl(new CalendarDataStoreImpl());

        Event event = calendarService.createEvent(title, description, personArrayList);
        calendarService.addEvent(event);

        ModelAndView modelAndView = new ModelAndView("SuccessEvent");
        modelAndView.addObject("msg", "You have already create new Event: " + calendarService.searchEvent(title).toString());

        return modelAndView;
    }

}
