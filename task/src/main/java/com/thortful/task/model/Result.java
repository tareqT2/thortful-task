package com.thortful.task.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Result {
	
		@JsonProperty("setup")
		private String setup;
		
		@JsonProperty("delivery")
		private String delivery;
		
		@JsonProperty("error")
		private Boolean error;
		@JsonProperty("amount")
		private Integer amount;
		@JsonProperty("jokes")
		private List<Joke> jokes = null;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<>();

		@JsonProperty("error")
		public Boolean getError() {
		return error;
		}

		@JsonProperty("error")
		public void setError(Boolean error) {
		this.error = error;
		}

		@JsonProperty("amount")
		public Integer getAmount() {
		return amount;
		}

		@JsonProperty("amount")
		public void setAmount(Integer amount) {
		this.amount = amount;
		}

		@JsonProperty("jokes")
		public List<Joke> getJokes() {
		return jokes;
		}

		@JsonProperty("jokes")
		public void setJokes(List<Joke> jokes) {
		this.jokes = jokes;
		}
		

		


}
