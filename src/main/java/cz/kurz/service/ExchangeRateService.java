package cz.kurz.service;

import cz.kurz.dto.ExchangeRateDTO;

import java.util.List;

public interface ExchangeRateService {

    /**
     * Fetches all exchange rates
     * @param useDb
     * @return List of all Exchange Rates
     */
    List<ExchangeRateDTO> getExchangeRates(boolean useDb);

}
