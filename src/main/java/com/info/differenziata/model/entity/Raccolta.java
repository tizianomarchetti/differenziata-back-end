package com.info.differenziata.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "RACCOLTA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "RACCOLTA_SEQ", allocationSize=1)
public class Raccolta extends BaseEntity {

	@Column(name = "DATA")
	private Date data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_CATEGORIA")
	private Categorie categoria;

}
