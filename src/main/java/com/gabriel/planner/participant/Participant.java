package com.gabriel.planner.participant;

import com.gabriel.planner.trip.Trip;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "participants")
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name ="is_confirmed", nullable = false)
    private boolean isConfirmed;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    public Participant(String email, Trip trip){
        this.email = email;
        this.trip = trip;
        this.isConfirmed = false;
        this.name = "";
    }
}
