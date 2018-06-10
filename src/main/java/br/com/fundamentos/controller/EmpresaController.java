package br.com.fundamentos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fundamentos.service.EmpresaService;
import net.minidev.json.JSONObject;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@Configuration
@RequestMapping(value = "/fundamentos")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping( value = { "/empresas" }, method = RequestMethod.GET, produces = "application/json" )
	public List<JSONObject> listaEmpresas() {
		List<JSONObject> response = empresaService.listaEmpresas();
		return response; 
	}
	
}
