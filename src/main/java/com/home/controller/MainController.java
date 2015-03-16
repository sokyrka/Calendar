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
import java.util.UUID;

@Controller
public class MainController {

    Person person;
    private CalendarServiceImpl calendarService = new CalendarServiceImpl(new CalendarDataStoreImpl());

    @RequestMapping(value = "/welcomePage.html", method = RequestMethod.GET)
    public ModelAndView createEnterForm(){
        ModelAndView modelAndView = new ModelAndView("WelcomePage");

        return modelAndView;
    }

    @RequestMapping(value = "/menuPage.html", method = RequestMethod.GET)
    public ModelAndView successCreatePerson(@RequestParam("firstName") String firstName,
                                           @RequestParam("secondName") String secondName,
                                           @RequestParam("email") String email){

        person = new Person.Builder()
                .firstName(firstName)
                .secondName(secondName)
                .email(email)
                .phone("78678")
                .build();

        ModelAndView modelAndView = new ModelAndView("MenuPage");
        modelAndView.addObject("msg", "Hello " + firstName);

        return modelAndView;
    }

    @RequestMapping(value = "/newEvent.html", method = RequestMethod.GET)
    public ModelAndView createNewEvent(){
        ModelAndView modelAndView = new ModelAndView("NewEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/successNewEvent.html", method = RequestMethod.GET)
    public ModelAndView successCreateEvent(@RequestParam("title") String title,
                                           @RequestParam("description") String description,
                                           @RequestParam("startDate") String startDate,
                                           @RequestParam("endDate") String endDate
                                           ) throws Exception{

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person.Builder().build());
        Event event = new Event.Builder()
                .title(title)
                .description(description)
                .id(UUID.randomUUID())
                .startDate(calendarService.dateConverter(startDate))
                .endDate(calendarService.dateConverter(endDate))
                .attenders(arrayList)
                .build();

        calendarService.addEvent(event);

        ModelAndView modelAndView = new ModelAndView("SuccessNewEvent");
        modelAndView.addObject("msg", "Success create new Event "+ title);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteEvent.html", method = RequestMethod.GET)
    public ModelAndView deleteEvent(){
        ModelAndView modelAndView = new ModelAndView("DeleteEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/successDeleteEvent.html", method = RequestMethod.GET)
    public ModelAndView successDeleteEvent(@RequestParam("title") String title){
        calendarService.removeEvent(title);
        ModelAndView modelAndView = new ModelAndView("SuccessDeleteEvent");
        modelAndView.addObject("msg", "The event " + title + " was successfully deleted");

        return modelAndView;
    }

    @RequestMapping(value="/searchEvent.html", method = RequestMethod.GET)
    public ModelAndView searchEvent(){
        ModelAndView modelAndView = new ModelAndView("SearchEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/successSearchEvent.html", method = RequestMethod.GET)
    public ModelAndView successSearchEvent(@RequestParam("title") String title){
        Event event = calendarService.searchEvent(title);

        ModelAndView modelAndView = new ModelAndView("SuccessSearchEvent");
        modelAndView.addObject("event", event);
        return modelAndView;
    }

    @RequestMapping(value = "/allEvents.html", method = RequestMethod.GET)
    public ModelAndView showAllEvents(){
        ModelAndView modelAndView = new ModelAndView("ShowAllEvents");
        modelAndView.addObject("calendarService", calendarService);
        return modelAndView;
    }
}
