package cz.kurz.controller;

import cz.kurz.dto.ExchangeRateDTO;
import cz.kurz.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exchangerates")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("")
    public List<ExchangeRateDTO> getExchangeRates(@RequestParam boolean usedb) {
        return exchangeRateService.getExchangeRates(usedb);
    }

}
