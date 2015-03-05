package client;

import com.home.common.Event;
import com.home.common.Person;
import com.home.service.CalendarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

public class MainClient {

    private static final Logger log = Logger.getAnonymousLogger();

    public static void main(String[] args) throws RemoteException {

        ApplicationContext factory = new ClassPathXmlApplicationContext("clientApplicationContext.xml");
        CalendarService service = (CalendarService) factory.getBean("calendarService");

        ArrayList<Person> personArrayList = new ArrayList<Person>();

        Person ivanIvanov = new Person.Builder()
                .firstName("Ivan")
                .secondName("Ivanov")
                .email("i@i.ua")
                .build();

        Person ivanPetrov = new Person.Builder()
                .firstName("Ivan")
                .secondName("Petrov")
                .email("p@i.ua")
                .build();

        Person ivanStupakov = new Person.Builder()
                .firstName("Ivan")
                .secondName("Stupakov")
                .email("s@i.ua")
                .build();

        personArrayList.add(ivanIvanov);
        personArrayList.add(ivanPetrov);
        personArrayList.add(ivanStupakov);

        Event studyEvent = new Event.Builder()
                .title("Day of study")
                .description("Good event")
                .attenders(personArrayList)
                .startDate(new GregorianCalendar(2015, 03, 05, 12, 00))
                .endDate(new GregorianCalendar(2015, 03, 05, 15, 00))
                .build();

        Event partyEvent = new Event.Builder()
                .title("Beer party")
                .description("Very good")
                .attenders(personArrayList)
                .startDate(new GregorianCalendar(2015, 03, 05, 18, 00))
                .endDate(new GregorianCalendar(2015, 03, 05, 23, 00))
                .build();

        service.addEvent(studyEvent);
        service.addEvent(partyEvent);

        ArrayList<Event> eventArrayList = service.searchEventsForPerson(ivanIvanov, new GregorianCalendar(2015, 03, 05, 19, 30));
        log.info(eventArrayList.toString());
    }
}
