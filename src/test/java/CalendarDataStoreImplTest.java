import com.home.common.Event;
import com.home.common.Person;
import com.home.datastore.CalendarDataStore;
import com.home.datastore.CalendarDataStoreImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalendarDataStoreImplTest {

    private Event event;

    @Before
    public void setUp(){
        event = new Event.Builder() .title("Party") .description("Hard") .attenders(new ArrayList<Person>()) .build();
    }

    @Test
    public void testPublish(){

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
}
