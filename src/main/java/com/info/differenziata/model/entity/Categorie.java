package com.info.differenziata.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "CATEGORIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "CATEGORIE_SEQ", allocationSize=1)
public class Categorie extends BaseEntity {

	@Column(name = "DESCRIZIONE")
	private String descrizione;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Raccolta> raccoltaList = new ArrayList<>();

}
