package com.nace.model;

import lombok.Data;

@Data
public class NaceDetails {
	
	private long orderId;
	private int level;
	private String code;
	private String parent;
	private String description;
	private String includes;
	private String extraIncludes;
	private String rulings;
	private String excludes;
	private String referencesDetails;
}
