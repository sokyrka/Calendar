package com.home.datastore;

import com.home.common.Event;
import com.home.common.EventAdapter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;

/**
 * Created by Home on 16.03.2015.
 */
public class EventDownloadThread implements Runnable {

    private final File file;
    private final HashMap<String, Event> store;

    EventDownloadThread(File file, HashMap<String, Event> store){
        this.file = file;
        this.store = store;
    }

    @Override
    public void run(){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(EventAdapter.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            EventAdapter recoverEventAdapter = (EventAdapter) unmarshaller.unmarshal(file);
            Event recoverEvent = EventAdapter.eventAdapterConvertToEvent(recoverEventAdapter);
            store.put(recoverEvent.getTitle(), recoverEvent);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
