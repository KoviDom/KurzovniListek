package cz.kurz.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateDTO {

    private String shortName;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
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
