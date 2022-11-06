package com.example.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
@Table(name = "airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "airline_name",nullable = false)
    @Size(min = 5,max = 500, message = "Size of airline name must be between 5 and 500")
    private String name;

}
