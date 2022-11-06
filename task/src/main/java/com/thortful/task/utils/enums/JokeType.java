package com.thortful.task.utils.enums;

import org.apache.commons.lang3.StringUtils;

public enum JokeType {
	SINGLE,
	TWOPART;
	
	public static JokeType fromValue(String value) {
		if(StringUtils.isBlank(value))
			return null;
		for(JokeType bf: JokeType.values()) {
			if(bf.name().equalsIgnoreCase(value))
				return bf;
		}
		return null;
	}
}
