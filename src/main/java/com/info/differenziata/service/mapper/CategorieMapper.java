package com.info.differenziata.service.mapper;

import com.info.differenziata.model.dto.CategorieDto;
import com.info.differenziata.model.entity.Categorie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategorieMapper extends BaseMapper<Categorie, CategorieDto> {

}
