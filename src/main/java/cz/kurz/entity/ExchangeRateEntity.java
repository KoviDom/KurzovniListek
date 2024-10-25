package cz.kurz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "exchange_rate")
@Getter
@Setter
public class ExchangeRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String shortName; // ID může být např. zkratka měny
    private LocalDateTime validFrom; // Datum a čas
    private String name;
    private String country;
    private double move;
    private int amount;
    private double valBuy;
    private double valSell;
    private double valMid;
    private double currBuy;
    private double currSell;
    private double currMid;
    private int version;
    private double cnbMid;
    private double ecbMid;

}
