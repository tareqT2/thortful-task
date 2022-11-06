package com.thortful.task.utils.enums;

import org.apache.commons.lang3.StringUtils;

public enum BlacklistFlag {

	NSFW,
	RELIGIOUS,
	POLITICAL,
	RACIST,
	SEXIST,
	EXPLICIT;
	
	public static BlacklistFlag fromValue(String value) {
		if(StringUtils.isBlank(value))
			return null;
		for(BlacklistFlag bf: BlacklistFlag.values()) {
			if(bf.name().equalsIgnoreCase(value))
				return bf;
		}
		return null;
	}
}
