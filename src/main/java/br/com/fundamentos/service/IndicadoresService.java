package br.com.fundamentos.service;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.fundamentos.repository.IndicadoresRepository;
import net.minidev.json.JSONObject;

@Configuration
public class IndicadoresService {

	@Autowired
	private IndicadoresRepository fundamentosRepository;

	public JSONObject consultaUltimoRoe(String codigoCvm) {
		JSONObject response = new JSONObject();
		double lucroLiquido = fundamentosRepository.consultaUltimoLucroLiquido( "consolidado", codigoCvm);
		double patrimonioLiquido = fundamentosRepository.consultaUltimoPatrimonioLiquido( "consolidado", codigoCvm);
		double roe = margemLiquida(lucroLiquido, patrimonioLiquido);
		response.appendField("roe", new DecimalFormat("##.##").format(roe));
		return response;
	}
	
	public JSONObject consultaUltimaMargemLiquida(String codigoCvm) {
		JSONObject response = new JSONObject();
		double lucroLiquido = fundamentosRepository.consultaUltimoLucroLiquido( "consolidado", codigoCvm);
		double receitaVendaBensServicos = fundamentosRepository.consultaUltimaReceitaVendaBensServicos("consolidado", codigoCvm);
		double margemLiquida = margemLiquida(lucroLiquido, receitaVendaBensServicos);
		response.appendField("margemLiquida", new DecimalFormat("##.##").format(margemLiquida));
		return response;
	}
	
	public JSONObject consultaMargemLiquida(String codigoCvm, String ano) {
		JSONObject response = new JSONObject();
		double lucroLiquido = fundamentosRepository.consultaUltimoLucroLiquido( "consolidado", codigoCvm);
		double receitaVendaBensServicos = fundamentosRepository.consultaReceitaVendaBensServicos(ano, "consolidado", codigoCvm);
		double margemLiquida = margemLiquida(lucroLiquido, receitaVendaBensServicos);
		response.appendField("margemLiquida", new DecimalFormat("##.##").format(margemLiquida));
		return response;
	}
	
	public JSONObject consultaUltimaMargemBruta(String codigoCvm) {
		JSONObject response = new JSONObject();
		double resultadoBruto = fundamentosRepository.consultaUltimoResultadoBruto("consolidado", codigoCvm);
		double receitaVendaBensServicos = fundamentosRepository.consultaUltimaReceitaVendaBensServicos("consolidado", codigoCvm);
		double margemLiquida = margemLiquida(resultadoBruto, receitaVendaBensServicos);
		response.appendField("margemBruta", new DecimalFormat("##.##").format(margemLiquida));
		return response;
	}
	
	public JSONObject consultaMargemBruta(String codigoCvm, String ano) {
		JSONObject response = new JSONObject();
		double resultadoBruto = fundamentosRepository.consultaResultadoBruto(ano, "consolidado", codigoCvm);
		double receitaVendaBensServicos = fundamentosRepository.consultaReceitaVendaBensServicos(ano, "consolidado", codigoCvm);
		double margemLiquida = margemLiquida(resultadoBruto, receitaVendaBensServicos);
		response.appendField("margemBruta", new DecimalFormat("##.##").format(margemLiquida));
		return response;
	}

	private double margemLiquida(double resultadoBruto, double receitaVendaBensServicos) {
		double margemLiquida = (resultadoBruto / receitaVendaBensServicos)*100;
		return margemLiquida;
	}

	public JSONObject consultaIndicadores(String codigoCvm) {
		// TODO Auto-generated method stub
		return null;
	}

}
