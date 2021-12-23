package api_get_simulacao;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import util.BaseAcesso;

public class ConsultaSimulacao extends BaseAcesso {

	@Test
	public void consultaTodos() {
		RestAssured.given()
		.get("v1/simulacoes")
		.then()
		.statusCode(200).log().all();
		System.out.println("----Lista de todas simulações com sucesso----");
	}
	
	@Test
	public void consultaCpf() {
		
		//Digite o cpf abaixo para consultar
		String cpf = "35615569820";
				
		RestAssured.given()
			.get("v1/simulacoes/"+cpf)
		.then()
			.statusCode(200).log().body()
			.body("cpf", Matchers.is(cpf));
		System.out.println("----O CPF "+cpf+" foi encontrado com sucesso----");
	}


}
