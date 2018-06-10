package br.com.fundamentos.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.fundamentos.repository.EmpresaRepository;
import net.minidev.json.JSONObject;

@Configuration
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public List<JSONObject> listaEmpresas() {
		List<JSONObject> empresas = empresaRepository.listaEmpresas();
		return empresas;
	}

}
