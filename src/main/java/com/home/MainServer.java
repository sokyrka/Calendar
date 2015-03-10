package com.home;

import com.home.datastore.CalendarDataStoreImpl;

public class MainServer {

    public static void main(String[] args){

        //new ClassPathXmlApplicationContext("serviceApplicationContext.xml");

        /*ArrayList<PersonAdapter> adapters = new ArrayList<>();
        adapters.add(new PersonAdapter());
        Event event = new Event.Builder()
                .title("wetit")
                .description("asd")
                .attenders(new ArrayList<Person>())
                .startDate(new GregorianCalendar())
                .endDate(new GregorianCalendar())
                .build();

        EventAdapter eventAdapter = new EventAdapter(event);


        try{
            File file = new File("D:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(EventAdapter.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.marshal(eventAdapter, file);
        }catch (JAXBException e){
            e.printStackTrace();
        }*/

        CalendarDataStoreImpl calendarDataStore = new CalendarDataStoreImpl();
        //System.out.println(calendarDataStore.getEvent("aaw"));




    }
}
