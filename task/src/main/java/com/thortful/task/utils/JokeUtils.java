package com.thortful.task.utils;

import java.util.List;

import com.thortful.task.utils.enums.BlacklistFlag;
import com.thortful.task.utils.enums.Category;
import com.thortful.task.utils.enums.JokeType;

public class JokeUtils {
	
	public static boolean isValidCategories(List<String> lsCategory) {
		if(lsCategory == null)
			return true;
		for(String cat: lsCategory) {
			if(Category.fromValue(cat) == null)
				return false;
		}
		return true;
	}
	
	public static boolean isValidFlag(List<String> lsFlags) {
		if(lsFlags == null)
			return true;
		for(String flag: lsFlags) {
			if(BlacklistFlag.fromValue(flag) == null)
				return false;
		}
		return true;
	}
	
	public static boolean isValidType(List<String> lsTypes) {
		if(lsTypes == null)
			return true;
		for(String type: lsTypes) {
			if(JokeType.fromValue(type) == null)
				return false;
		}
		return true;
	}

}
