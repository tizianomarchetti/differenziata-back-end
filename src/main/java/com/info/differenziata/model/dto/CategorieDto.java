package com.info.differenziata.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorieDto extends BaseDto {

	private String descrizione;

	private List<RaccoltaDto> raccoltaList = new ArrayList<>();

}
