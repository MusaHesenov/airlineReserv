package com.example.entity;

import com.example.enums.Gender;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String phoneNumber;
    private Gender gender;
    @Column(nullable = false)
    @Size(min = 5,max = 15, message = "Size of username must be between 5 and 15")
    private String userName;
    @Column(nullable = false)
    @Size(min = 5,max = 15,message = "Size of password must be between 5 and 15")
    private String password;
}
