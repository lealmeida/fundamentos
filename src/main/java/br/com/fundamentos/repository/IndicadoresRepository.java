package br.com.fundamentos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import net.minidev.json.JSONObject;

@Component
public class IndicadoresRepository {

	@Autowired
	private MongoTemplate repository;
	
	public double consultaUltimoLucroLiquido( String tipo, String codigoCvm) {
		Query query = new Query().addCriteria(Criteria.where("tipo").is(tipo)
				.and("codigoCvm").is(codigoCvm)).limit(1).with(new Sort(Sort.Direction.DESC,"periodo"));
		query.with(new Sort(Sort.Direction.DESC,"ano"));
		query.fields().exclude("_id");
	    query.fields().include("lucroLiquidoConsolidadoDoPeriodo");

	    JSONObject demonstracaoResultado = repository.findOne(query, JSONObject.class, "demonstracaoResultadoAbrangente");
		return Double.valueOf(demonstracaoResultado.getAsString("lucroLiquidoConsolidadoDoPeriodo").replace(".", ""));
	}
	
	public double consultaUltimoPatrimonioLiquido( String tipo, String codigoCvm) {
		Query query = new Query().addCriteria(Criteria.where("tipo").is(tipo)
				.and("codigoCvm").is(codigoCvm)).limit(1).with(new Sort(Sort.Direction.DESC,"periodo"));
		query.with(new Sort(Sort.Direction.DESC,"ano"));
	    query.fields().include("patrimonioLiquidoConsolidado");
	    query.fields().exclude("_id");

	    JSONObject demonstracaoResultado = repository.findOne(query, JSONObject.class, "balancoPatrimonialPassivo");
		return Double.valueOf(demonstracaoResultado.getAsString("patrimonioLiquidoConsolidado").replace(".", ""));
	}
	
	public double consultaPatrimonioLiquido(String ano, String tipo, String codigoCvm) {
		Query query = new Query().addCriteria(Criteria.where("ano").is(ano)
				.and("tipo").is(tipo)
				.and("codigoCvm").is(codigoCvm)).limit(1).with(new Sort(Sort.Direction.DESC,"periodo"));
	    query.fields().include("patrimonioLiquidoConsolidado");
	    query.fields().exclude("_id");

	    JSONObject demonstracaoResultado = repository.findOne(query, JSONObject.class, "balancoPatrimonialPassivo");
		return Double.valueOf(demonstracaoResultado.getAsString("patrimonioLiquidoConsolidado").replace(".", ""));
	}
	
	public double consultaUltimaReceitaVendaBensServicos( String tipo, String codigoCvm) {
		Query query = new Query().addCriteria(Criteria.where("tipo").is(tipo)
				.and("codigoCvm").is(codigoCvm)).limit(1).with(new Sort(Sort.Direction.DESC,"periodo"));
		query.with(new Sort(Sort.Direction.DESC,"ano"));
	    query.fields().include("receitaDeVendaDeBensE/OuServicos");
	    query.fields().exclude("_id");

	    JSONObject demonstracaoResultado = repository.findOne(query, JSONObject.class, "demonstracaoResultado");
		return Double.valueOf(demonstracaoResultado.getAsString("receitaDeVendaDeBensE/OuServicos").replace(".", ""));
	}
	
	public double consultaReceitaVendaBensServicos(String ano, String tipo, String codigoCvm) {
		Query query = new Query().addCriteria(Criteria.where("ano").is(ano)
				.and("tipo").is(tipo)
				.and("codigoCvm").is(codigoCvm)).limit(1).with(new Sort(Sort.Direction.DESC,"periodo"));
	    query.fields().include("receitaDeVendaDeBensE/OuServicos");
	    query.fields().exclude("_id");

	    JSONObject demonstracaoResultado = repository.findOne(query, JSONObject.class, "demonstracaoResultado");
		return Double.valueOf(demonstracaoResultado.getAsString("receitaDeVendaDeBensE/OuServicos").replace(".", ""));
	}
	
	public double consultaUltimoResultadoBruto( String tipo, String codigoCvm) {
		Query query = new Query().addCriteria(Criteria.where("tipo").is(tipo)
				.and("codigoCvm").is(codigoCvm)).limit(1).with(new Sort(Sort.Direction.DESC,"periodo"));
		query.with(new Sort(Sort.Direction.DESC,"ano"));
	    query.fields().include("resultadoBruto");
	    query.fields().exclude("_id");

	    JSONObject demonstracaoResultado = repository.findOne(query, JSONObject.class, "demonstracaoResultado");
		return Double.valueOf(demonstracaoResultado.getAsString("resultadoBruto").replace(".", ""));
	}
	
	public double consultaResultadoBruto(String ano, String tipo, String codigoCvm) {
		Query query = new Query().addCriteria(Criteria.where("ano").is(ano)
				.and("tipo").is(tipo)
				.and("codigoCvm").is(codigoCvm)).limit(1).with(new Sort(Sort.Direction.DESC,"periodo"));
	    query.fields().include("resultadoBruto");
	    query.fields().exclude("_id");

	    JSONObject demonstracaoResultado = repository.findOne(query, JSONObject.class, "demonstracaoResultado");
		return Double.valueOf(demonstracaoResultado.getAsString("resultadoBruto").replace(".", ""));
	}
	
}
