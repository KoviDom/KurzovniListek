package cz.kurz.service;

import cz.kurz.dto.ExchangeRateDTO;
import cz.kurz.dto.mapper.ExchangeRateMapper;
import cz.kurz.entity.ExchangeRateEntity;
import cz.kurz.entity.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{

    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateMapper exchangeRateMapper;
    private final RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    @Autowired
    public ExchangeRateServiceImpl(ExchangeRateRepository exchangeRateRepository, ExchangeRateMapper exchangeRateMapper, RestTemplate restTemplate) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.exchangeRateMapper = exchangeRateMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ExchangeRateDTO> getExchangeRates(boolean useDb) {
        if (useDb) {
            return exchangeRateRepository.findAll()
                    .stream()
                    .map(exchangeRateMapper::toDTO)
                    .collect(Collectors.toList());
        } else {
            // Získání dat z API České spořitelny
            ExchangeRateDTO[] apiRates = restTemplate.getForObject(apiUrl, ExchangeRateDTO[].class);

            if (apiRates != null) {
                // Uložení do databáze
                List<ExchangeRateEntity> entities = List.of(apiRates).stream()
                        .map(exchangeRateMapper::toEntity)
                        .collect(Collectors.toList());
                exchangeRateRepository.saveAll(entities);

                // Vrácení uložených dat jako DTO
                return List.of(apiRates);
            }
            return List.of();
        }
    }

}
