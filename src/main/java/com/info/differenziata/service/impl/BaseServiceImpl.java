package com.info.differenziata.service.impl;

import com.info.differenziata.model.dto.BaseDto;
import com.info.differenziata.model.entity.BaseEntity;
import com.info.differenziata.repository.BaseRepository;
import com.info.differenziata.service.mapper.BaseMapper;
import com.info.differenziata.service.mapper.utils.CycleAvoidingMappingContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public abstract class BaseServiceImpl<S extends BaseRepository, T extends BaseMapper, U extends BaseDto, V extends BaseEntity> {

	@Autowired
	private S repo;

	@Autowired
	private T mapper;

	protected S getRepo() {
		return repo;
	}

	protected T getMapper() {
		return mapper;
	}

	public CycleAvoidingMappingContext createCycleAvoidingMappingContext() {
		return new CycleAvoidingMappingContext();
	}

	public Class<U> getDTO() {
		return (Class<U>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
	}

	public Class<V> getEntity() {
		return (Class<V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[3];
	}

	public Optional<Long> create(U dto) {
		return Optional.ofNullable(((V) repo.save(mapper.mapToEntity(dto, createCycleAvoidingMappingContext()))).getId());
	}

	public Optional<U> getById(Long id) {
		Optional optional = repo.findById(id).map(o -> mapper.mapToDTO((V) o, createCycleAvoidingMappingContext()));

		return optional;
	}

	public List<U> findAll() {
		return (List<U>) repo.findAll().stream().map(el -> mapper.mapToDTO((V) el, createCycleAvoidingMappingContext())).collect(Collectors.toList());
	}

	public void update(U dto) {
		if (dto.getId() != null) {
			repo.save(mapper.mapToEntity(dto, createCycleAvoidingMappingContext()));
		}
	}

	public Optional<U> deleteById(Long id) {
		return this.getById(id).map(u -> {
			repo.deleteById(id);
			return u;
		});
	}

}
