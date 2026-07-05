package com.project.showdekhle.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "eventmodel")
public class EventModel {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String title;
    private String description;
    private String location;
    private String event_date;
    private Long total_seats;
    private Long available_seats;
    private Long price;
    private String created_at;
    private String updated_at;
}
