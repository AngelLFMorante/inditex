package com.inditex.web.mapper;

import com.inditex.domain.model.Price;
import com.inditex.web.dto.PriceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceDTO toDto(Price price);
}

