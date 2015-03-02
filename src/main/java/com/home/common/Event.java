package com.home.common;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Event {

    private final String title;
    private final String description;
    private final UUID id;
    private final List<Person> attenders;
    private final Date startDate;
    private final Date endDate;

    private Event(Builder builder){
        this.title = builder.title;
        this.description = builder.description;
        this.id = builder.id;
        this.attenders = builder.attenders;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public List<Person> getAttenders() {
        return attenders;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (attenders != null ? !attenders.equals(event.attenders) : event.attenders != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (endDate != null ? !endDate.equals(event.endDate) : event.endDate != null) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (startDate != null ? !startDate.equals(event.startDate) : event.startDate != null) return false;
        if (title != null ? !title.equals(event.title) : event.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (attenders != null ? attenders.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "com.home.common.Event{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", attenders=" + attenders +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public static class Builder{

        private String title;
        private String description;
        private UUID id;
        private List<Person> attenders;
        private Date startDate;
        private Date endDate;

        public Builder(){

        }

        public Builder(Event event){
            this.title = event.title;
            this.description = event.description;
            this.id = event.id;
            this.attenders = event.attenders;
            this.startDate = event.startDate;
            this.endDate = event.endDate;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder id(UUID id){
            this.id = id;
            return this;
        }

        public Builder attenders(List<Person> attenders){
            this.attenders = attenders;
            return this;
        }

        public Builder startDate(Date startDate){
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(Date endDate){
            this.endDate = endDate;
            return this;
        }

        public Event build(){
            return new Event(this);
        }

    }
}
