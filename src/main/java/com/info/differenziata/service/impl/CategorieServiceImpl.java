package com.info.differenziata.service.impl;

import com.info.differenziata.model.dto.CategorieDto;
import com.info.differenziata.model.entity.Categorie;
import com.info.differenziata.repository.CategorieRepository;
import com.info.differenziata.service.CategorieService;
import com.info.differenziata.service.mapper.CategorieMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategorieServiceImpl extends BaseServiceImpl<CategorieRepository, CategorieMapper, CategorieDto, Categorie> implements CategorieService {

}
