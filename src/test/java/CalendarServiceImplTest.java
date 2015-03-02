import com.home.common.Event;
import com.home.common.Person;
import com.home.service.CalendarService;
import com.home.service.CalendarServiceImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalendarServiceImplTest {

    private Event event;

    @Before
    public void setUp(){
        event = new Event.Builder() .title("Party") .description("In Club") .attenders(new ArrayList<Person>()) .build();
    }

    @Test
    public void testCreateEvent(){
        CalendarService service = mock(CalendarServiceImpl.class);
        when(service.createEvent("Party", "In Club", new ArrayList<Person>()))
                .thenReturn(event);

        Event returned = service.createEvent("Party", "In Club", new ArrayList<Person>());

        assertEquals(event, returned);
    }

    @Test
    public void testRemoveEvent(){
        CalendarService service = mock(CalendarServiceImpl.class);
        when(service.removeEvent(event.getTitle()))
                .thenReturn(event);

        Event returned = service.removeEvent(event.getTitle());

        assertEquals(event, returned);
    }

    @Test
    public void testSearchEvent(){
        CalendarServiceImpl service = mock(CalendarServiceImpl.class);
        when(service.searchEvent(event.getTitle()))
                .thenReturn(event);

        Event returned = service.searchEvent(event.getTitle());

        assertEquals(event, returned);
    }
}
