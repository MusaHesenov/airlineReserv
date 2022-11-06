package com.example.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
public class FlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String no;
    private Integer countSeats;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "flights_info",joinColumns = {@JoinColumn(name = "flight_info_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "airline_id",referencedColumnName = "id")})
    private Airline airline;
}
