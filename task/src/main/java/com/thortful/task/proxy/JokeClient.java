package com.thortful.task.proxy;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.thortful.task.model.Result;

import reactor.core.publisher.Flux;

@Service
public class JokeClient {
    private final WebClient webClient;

    public JokeClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://v2.jokeapi.dev/joke/").build();
    }

    public Result getJoke(){
        return this.webClient.get().uri("/Any")
                .retrieve()
                .bodyToMono(Result.class).block();
    }

	public Flux<Result> getJokeByCategory(List<String> category, List<String> type, List<String> blacklistFlags, String contains, Integer amount) {
		try { return this.webClient.get().uri(
				 UriBuilder -> 
		         UriBuilder
		        .path((category == null || category.isEmpty())? "Any":String.join(",", category))
			    .queryParamIfPresent("type", Optional.ofNullable( (type == null )? null : String.join(",", type)))
			    .queryParamIfPresent("blacklistFlags", Optional.ofNullable( (blacklistFlags == null )? null : String.join(",", blacklistFlags)))
			    .queryParamIfPresent("contains", Optional.ofNullable(contains))
			    .queryParamIfPresent("amount", Optional.ofNullable(amount))
			    .build()
		 )
        .retrieve()
        .bodyToFlux(Result.class);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
