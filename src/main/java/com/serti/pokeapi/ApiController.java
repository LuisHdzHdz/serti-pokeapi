package com.serti.pokeapi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serti.pokeapi.util.HttpClient;

@RestController
public class ApiController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
	HttpClient  client = new HttpClient();
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/pokemon")
    public String findAll() {
		String urlAll ="https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0"; 
		String response = client.get(urlAll);
		
        return response;
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/pokemon/evolution-chain")
    public String gatEvolutionChain(@RequestParam(value = "id") String id) {
		String urlChain =String.format("https://pokeapi.co/api/v2/evolution-chain/%s/",id);
		String response = client.get(urlChain);
		
        return response;
    }
}
