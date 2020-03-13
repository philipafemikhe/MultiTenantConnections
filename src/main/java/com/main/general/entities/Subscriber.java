package com.main.general.entities;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Entity
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String subscriberName;
    private String company;
    private String databaseName;

    public Subscriber() {
    }

    public Subscriber(String subscriberName, String company, String databaseName) {
        this.subscriberName = subscriberName;
        this.company = company;
        this.databaseName = databaseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", subscriberName='" + subscriberName + '\'' +
                ", company='" + company + '\'' +
                ", databaseName='" + databaseName + '\'' +
                '}';
    }
}
