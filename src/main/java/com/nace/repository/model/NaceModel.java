package com.nace.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_nace")
public class NaceModel {
	
	@Id
	private long orderId;
	@Column(name = "level")
	private int level;
	@Column(name = "code")
	private String code;
	@Column(name = "parent")
	private String parent;
	@Column(name = "description")
	private String description;
	@Column(name = "includes")
	private String includes;
	@Column(name = "extra_includes")
	private String extraIncludes;
	@Column(name = "rulings")
	private String rulings;
	@Column(name = "excludes")
	private String excludes;
	@Column(name = "reference_details")
	private String referencesDetails;

}
