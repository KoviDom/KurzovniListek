package cz.kurz.service;

import cz.kurz.dto.ExchangeRateDTO;

import java.util.List;

public interface ExchangeRateService {

    /**
     * Fetchuji vsechny exchange rates
     * @param useDb
     * @return vraci list všech Exchange Rates
     */
    List<ExchangeRateDTO> getExchangeRates(boolean useDb);

}
