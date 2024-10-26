package cz.kurz.dto.mapper;

import cz.kurz.dto.ExchangeRateDTO;
import cz.kurz.entity.ExchangeRateEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {

    ExchangeRateEntity toEntity(ExchangeRateDTO source);

    ExchangeRateDTO toDTO(ExchangeRateEntity source);

}
