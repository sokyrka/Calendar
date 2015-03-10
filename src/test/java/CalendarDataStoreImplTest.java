import com.home.common.Event;
import com.home.common.Person;
import com.home.datastore.CalendarDataStore;
import com.home.datastore.CalendarDataStoreImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class CalendarDataStoreImplTest {

    private Event event;

    @Before
    public void setUp(){
        event = new Event.Builder() .title("Party") .description("Hard") .attenders(new ArrayList<Person>()) .build();
    }

    @Test
    public void testPublish(){
        CalendarDataStore dataStore = mock(CalendarDataStore.class);
        dataStore.publish(event);

        InOrder inOrder = inOrder(dataStore);
        inOrder.verify(dataStore).publish(event);
    }

    @Test
    public void testRemove(){
        CalendarDataStore store = mock(CalendarDataStoreImpl.class);
        when(store.remove(event.getTitle()))
                .thenReturn(event);

        Event returned = store.remove(event.getTitle());

        assertEquals(event, returned);
    }

    @Test
    public void testGetEvent(){
        CalendarDataStore store = mock(CalendarDataStoreImpl.class);
        when(store.getEvent(event.getTitle()))
                .thenReturn(event);

        Event returned = store.getEvent(event.getTitle());

        assertEquals(event, returned);
    }

    @Test
    public void testSearchEventForPerson(){
        CalendarDataStore store = mock(CalendarDataStoreImpl.class);
        when(store.searchEventsForPerson(new Person.Builder().build(), new GregorianCalendar()))
                .thenReturn(new ArrayList<Event>());

        ArrayList<Event> returned = store.searchEventsForPerson(new Person.Builder().build(), new GregorianCalendar());

        assertEquals(new ArrayList<Event>(), returned);
    }

    @Test
    public void testFreePersonInCurrentTime(){
        CalendarDataStore store = mock(CalendarDataStoreImpl.class);

        boolean returned = store.freePersonInCurrentTime(new Person.Builder().build(), new GregorianCalendar());

        assertFalse(returned);
    }

}
