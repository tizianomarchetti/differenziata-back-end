package com.info.differenziata.service;

import com.info.differenziata.model.dto.BaseDto;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseDto> {
	Optional<Long> create(T dto);

	Optional<T> getById(Long id);

	List<T> findAll();

	void update(T dto);

	Optional<T> deleteById(Long id);
}
