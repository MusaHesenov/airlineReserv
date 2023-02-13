package com.example.entity;

import com.example.enums.Currency;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "fare")
@Data
@Builder
@Entity
public class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Currency currency;
    private BigDecimal fare;
}
