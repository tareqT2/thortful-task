package com.thortful.task.utils.enums;

import org.apache.commons.lang3.StringUtils;

public enum Category {
	
	PROGRAMMING,
	MISCELLANEOUS,
	DARK,
	PUN,
	SPOOKY,
	CHRISTMAS;
	
	
	public static Category fromValue(String value) {
		if(StringUtils.isBlank(value))
			return null;
		for(Category cat: Category.values()) {
			if(cat.name().equalsIgnoreCase(value))
				return cat;
		}
		return null;
	}
	

}
