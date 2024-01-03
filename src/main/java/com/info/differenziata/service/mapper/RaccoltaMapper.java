package com.info.differenziata.service.mapper;

import com.info.differenziata.model.dto.RaccoltaDto;
import com.info.differenziata.model.entity.Raccolta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RaccoltaMapper extends BaseMapper<Raccolta, RaccoltaDto> {

}
