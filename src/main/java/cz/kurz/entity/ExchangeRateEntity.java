package cz.kurz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "exchange_rate")
@Getter
@Setter
public class ExchangeRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String shortName;

    @Column(nullable = false)
    private LocalDateTime validFrom; // Datum a čas

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private double move;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private double valBuy;

    @Column(nullable = false)
    private double valSell;

    @Column(nullable = false)
    private double valMid;

    @Column(nullable = false)
    private double currBuy;

    @Column(nullable = false)
    private double currSell;

    @Column(nullable = false)
    private double currMid;

    @Column(nullable = false)
    private int version;

    @Column(nullable = false)
    private double cnbMid;

    @Column(nullable = false)
    private double ecbMid;

}
