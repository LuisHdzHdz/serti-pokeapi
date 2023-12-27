package com.serti.pokeapi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serti.pokeapi.mdl.AccessLog;
import com.serti.pokeapi.service.AccesLogService;
import com.serti.pokeapi.service.RequestService;
import com.serti.pokeapi.util.HttpClient;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ApiController {
	@Autowired
    private RequestService requestService;
	@Autowired
    private AccesLogService accesLogService;
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
	HttpClient  client = new HttpClient();
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/pokemon")
    public String findAll(HttpServletRequest request) {
		AccessLog accesParam = new AccessLog();
		String urlAll ="https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0"; 
		String response = client.get(urlAll);
		String clientIp = requestService.getClientIp(request);
		accesParam.setClient(clientIp);
		accesParam.setResource("/pokemon/evolution-chain");
		accesLogService.saveAccesLog(accesParam);
		LOGGER.info("Ip del cliente: { }",clientIp);
        return response;
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/pokemon/evolution-chain")
    public String gatEvolutionChain(@RequestParam(value = "id") String id, HttpServletRequest request) {
		AccessLog accesParam = new AccessLog();
		String urlChain =String.format("https://pokeapi.co/api/v2/evolution-chain/%s/",id);
		String response = client.get(urlChain);
		String clientIp = requestService.getClientIp(request);
		accesParam.setClient(clientIp);
		accesParam.setResource("/pokemon/evolution-chain");
		accesLogService.saveAccesLog(accesParam);
		LOGGER.info("Ip del cliente: { }",clientIp);
        return response;
    }
}
