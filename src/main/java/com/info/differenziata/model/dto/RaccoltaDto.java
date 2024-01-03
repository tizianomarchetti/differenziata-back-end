package com.info.differenziata.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaccoltaDto extends BaseDto {

	private Date data;

	private CategorieDto categoria;

}
