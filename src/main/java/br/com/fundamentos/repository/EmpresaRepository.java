package br.com.fundamentos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import net.minidev.json.JSONObject;

@Component
public class EmpresaRepository {

	@Autowired
	private MongoTemplate repository;
	
	public List<JSONObject> listaEmpresas() {
		Query query = new Query();
		query.fields().exclude("_id");

	    List<JSONObject> empresas = repository.find(query, JSONObject.class, "empresa");
		return empresas;
	}
	
}
