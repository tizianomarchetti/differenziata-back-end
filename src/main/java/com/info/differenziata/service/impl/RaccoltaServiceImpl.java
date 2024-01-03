package com.info.differenziata.service.impl;

import com.info.differenziata.model.dto.RaccoltaDto;
import com.info.differenziata.model.entity.Raccolta;
import com.info.differenziata.repository.RaccoltaRepository;
import com.info.differenziata.service.RaccoltaService;
import com.info.differenziata.service.mapper.RaccoltaMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RaccoltaServiceImpl extends BaseServiceImpl<RaccoltaRepository, RaccoltaMapper, RaccoltaDto, Raccolta> implements RaccoltaService {

}
