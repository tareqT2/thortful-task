package com.thortful.task.controller;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thortful.task.exceptions.JokesException;
import com.thortful.task.model.Result;
import com.thortful.task.proxy.JokeClient;
import com.thortful.task.utils.JokeUtils;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
@Validated

public class JokeController {
	
	private static final Logger logger = LoggerFactory.getLogger(JokeController.class);

    @Autowired
    JokeClient webClientService;

    @GetMapping("/joke")
    public Flux<Result> getJoke(@RequestParam(required = false) List<String> type,
    		@RequestParam(required = false) List<String> blacklistFlags, @RequestParam(required = false) String contains,
    		@RequestParam(required = false) @Min(1) @Max(10) Integer amount){
    	logger.info("Getting Randmom Joke...");
    	Flux<Result> joke = webClientService.getJokeByCategory(null, type, blacklistFlags, contains, amount);
    	logger.info("Joke retreived: " + joke.toString());
        return joke;
    }

    @GetMapping(value = "/joke/{category}" )
    public Flux<Result> getJokeByCategory(@PathVariable List<String> category, @RequestParam(required = false) List<String> type,
    		@RequestParam(required = false) List<String> blacklistFlags, @RequestParam(required = false) String contains,
    		@RequestParam(required = false) @Min(1) @Max(10) Integer amount){
    	logger.info("Getting categorized jokes");
    	Flux<Result> result;
    	
    	result = validateParams(category, type, blacklistFlags);
    	if(result != null)
    		return result;
    	
    	result = webClientService.getJokeByCategory(category, type, blacklistFlags, contains, amount).switchIfEmpty(Flux.error(new JokesException("Say No Jokes!")));
    	return result;
    }

	private Flux<Result> validateParams(List<String> category, List<String> types, List<String> blacklistFlags) {
		if(!JokeUtils.isValidCategories(category))
    	{
    		logger.warn("Invalid category: "+ String.join(",", category));
    		return Flux.error(new JokesException("Invalid Category"));
    	}
    	if(!JokeUtils.isValidFlag(blacklistFlags))
    	{
    		logger.warn("Invalid blacklist flags: "+ String.join(",", blacklistFlags));
    		return Flux.error(new JokesException("Invalid blacklist flags"));
    	}
    	if(!JokeUtils.isValidType(types))
    	{
    		logger.warn("Invalid joke type: "+ String.join(",", types));
    		return Flux.error(new JokesException("Invalid Joke Type"));
    	}
		return null;
		
	}
    
}

