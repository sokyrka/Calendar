package com.home.datastore;

import com.home.common.Event;
import com.home.common.EventAdapter;
import com.home.common.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

public class CalendarDataStoreImpl implements CalendarDataStore {

    private final HashMap<String, Event> store;
    private EventAdapter eventAdapter;

    public CalendarDataStoreImpl(){
        store = new HashMap<String, Event>();
        File file = new File("D:/event_store");
        File[] fileList = file.listFiles();
        for(File restoreFile : fileList){
            try{
                JAXBContext jaxbContext = JAXBContext.newInstance(EventAdapter.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                EventAdapter recoverEventAdapter = (EventAdapter) unmarshaller.unmarshal(restoreFile);
                Event recoverEvent = EventAdapter.eventAdapterConvertToEvent(recoverEventAdapter);
                store.put(recoverEvent.getTitle(), recoverEvent);
            }catch (JAXBException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void publish(Event event) {
        store.put(event.getTitle(), event);
        eventAdapter = new EventAdapter(event);
        try{
            File file = new File("D:\\event_store/" + event.getTitle() + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(EventAdapter.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(eventAdapter, file);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

    @Override
    public Event remove(String title) {
        File file = new File("D:\\event_store/" + title + ".xml");
        file.delete();
        return store.remove(title);
    }

    @Override
    public Event addAttenders(String title, List<Person> attenders){
        Event recoverEvent = null;
        try{
            File file = new File("D:\\" + title + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(EventAdapter.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            recoverEvent = (Event) unmarshaller.unmarshal(file);
            remove(title);
        }catch (JAXBException e){
            e.printStackTrace();
        }

        Event event = new Event.Builder()
                .title(recoverEvent.getTitle())
                .description(recoverEvent.getDescription())
                .id(recoverEvent.getId())
                .attenders(attenders)
                .startDate(recoverEvent.getStartDate())
                .endDate(recoverEvent.getEndDate())
                .build();

        publish(event);

        return event;
    }

    @Override
    public Event getEvent(String title) {
        return store.get(title);
    }

    @Override
    public ArrayList<Event> getAllEvents(){
        ArrayList<Event> result = new ArrayList<>();
        for(Map.Entry<String, Event> entry : store.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public ArrayList<Event> searchEventsForPerson(Person person, GregorianCalendar time){
        ArrayList<Event> eventArrayList = new ArrayList<Event>();
        for(Map.Entry<String, Event> entry : store.entrySet()){
            Event value = entry.getValue();
            for(Person personInStore : value.getAttenders()){
                if(personInStore.getEmail().equals(person.getEmail()) &&
                        (value.getStartDate().getTimeInMillis() <= time.getTimeInMillis() &&
                                value.getEndDate().getTimeInMillis() >= time.getTimeInMillis())){
                    eventArrayList.add(value);
                }
            }
        }
        return eventArrayList;
    }

    @Override
    public boolean freePersonInCurrentTime(Person person, GregorianCalendar time){
        boolean result = true;
        for(Map.Entry<String, Event> entry : store.entrySet()) {
            Event value = entry.getValue();
            for(Person personInStore : value.getAttenders()){
                if(personInStore.getEmail().equals(person.getEmail()) && (value.getStartDate().getTimeInMillis() <= time.getTimeInMillis() && value.getEndDate().getTimeInMillis() >= time.getTimeInMillis())){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public ArrayList<Event> searchEventsByTitleAndAttenders(String title, String mails){
        ArrayList<Event> eventArrayList = new ArrayList<>();
        for(Map.Entry<String, Event> entry : store.entrySet()){
            Event event = entry.getValue();
            for(Person p : event.getAttenders()){
                if(p.getEmail().equals(mails) && event.getTitle().equals(title)){
                    eventArrayList.add(event);}
            }
        }
        return eventArrayList;
    }
}
