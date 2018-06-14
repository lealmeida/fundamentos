package br.com.fundamentos.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;

@Configuration
public class CotacaoService {


	public Double cotacao() {
		RestTemplate restTemplate = new RestTemplate();
		LinkedHashMap<Object, Object> response = restTemplate.getForObject("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=OSXB3.SA&apikey=G2LBQYA52OW3ZO5E", LinkedHashMap.class);
		response = (LinkedHashMap<Object, Object>) response.get("Time Series (Daily)");
		List values = new ArrayList<>(response.values());
		response = (LinkedHashMap<Object, Object>) values.get(0);
		String val = String.valueOf(response.get("4. close"));
		double numero = Double.valueOf(val.substring(0, val.length()-2));
		return numero;
	}

}
