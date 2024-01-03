package com.info.differenziata.controller;

import com.info.differenziata.model.dto.RaccoltaDto;
import com.info.differenziata.service.RaccoltaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("raccolta")
public class RaccoltaController extends BaseController<RaccoltaService, RaccoltaDto> {

}
