package com.info.differenziata.controller;

import com.info.differenziata.model.dto.CategorieDto;
import com.info.differenziata.service.CategorieService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("categorie")
public class CategorieController extends BaseController<CategorieService, CategorieDto> {

}
