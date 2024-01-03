package com.info.differenziata.service.mapper;

import com.info.differenziata.service.mapper.utils.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BaseMapper<T, V> {

	@Mapping(source = "id", target = "id")
	V mapToDTO(T type, @Context CycleAvoidingMappingContext context);

	@InheritInverseConfiguration()
	T mapToEntity(V dto, @Context CycleAvoidingMappingContext context);
}
