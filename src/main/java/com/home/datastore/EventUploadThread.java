package com.home.datastore;

import com.home.common.EventAdapter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class EventUploadThread implements Runnable {

    private final File file;
    private final EventAdapter eventAdapter;

    EventUploadThread(File file, EventAdapter eventAdapter){
        this.file = file;
        this.eventAdapter=eventAdapter;
    }

    @Override
    public void run() {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(EventAdapter.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(eventAdapter, file);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
