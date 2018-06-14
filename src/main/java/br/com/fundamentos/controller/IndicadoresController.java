package br.com.fundamentos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fundamentos.service.IndicadoresService;
import net.minidev.json.JSONObject;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@Configuration
@RequestMapping(value = "/fundamentos")
public class IndicadoresController {
	
	@Autowired
	private IndicadoresService fundamentosService;
	
	@RequestMapping( value = { "/indicadores" }, params={ "codigoCvm" }, method = RequestMethod.GET, produces = "application/json" )
	public JSONObject consultaIndicadores( @RequestParam("codigoCvm") String codigoCvm ) {
		JSONObject response = fundamentosService.consultaIndicadores(codigoCvm);
		return response; 
	}
	
	@RequestMapping( value = { "/roe" }, params={ "codigoCvm" }, method = RequestMethod.GET, produces = "application/json" )
	public JSONObject consultaRoe( @RequestParam("codigoCvm") String codigoCvm) {
		JSONObject response = fundamentosService.consultaUltimoRoe(codigoCvm);
		return response; 
	}
	
	@RequestMapping( value = { "/margem-liquida" }, params={ "codigoCvm" }, method = RequestMethod.GET, produces = "application/json" )
	public JSONObject consultaMargeLiquida( @RequestParam("codigoCvm") String codigoCvm) {
		JSONObject response = fundamentosService.consultaUltimaMargemLiquida(codigoCvm);
		return response; 
	}
	
	@RequestMapping( value = { "/margem-bruta" }, params={ "codigoCvm" }, method = RequestMethod.GET, produces = "application/json" )
	public JSONObject consultaMargeBruta( @RequestParam("codigoCvm") String codigoCvm ) {
		JSONObject response = fundamentosService.consultaUltimaMargemBruta(codigoCvm);
		return response; 
	}
	
	@RequestMapping( value = { "/cotacao" }, params={ "codigoCvm" }, method = RequestMethod.GET, produces = "application/json" )
	public JSONObject consultaCotacao( @RequestParam("codigoCvm") String codigoCvm ) {
		JSONObject response = fundamentosService.consultaIndicadores(codigoCvm);
		return response; 
	}


}
