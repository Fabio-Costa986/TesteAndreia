package api_get_restricoes;

import org.hamcrest.Matchers;
import org.junit.Test;
import io.restassured.RestAssured;
import util.BaseAcesso;

public class TestGet_Restricoes extends BaseAcesso {

	@Test
	public void consultaCpfSemRestricao() {
		
		//Digite o cpf abaixo para consultar
		String cpf = "35615569820";
				
		RestAssured.given()
			.get("v1/restricoes/"+cpf)
		.then()
			.statusCode(204).log().all();
		System.out.println("----O CPF "+cpf+" foi encontrado com sucesso----");
	}
	
	@Test
	public void consultaCpfComRestricao() {
		
		//Digite o cpf abaixo para consultar
		String cpf = "84809766080";
				
		RestAssured.given()
			.get("v1/restricoes/"+cpf)
		.then()
			.statusCode(200).log().all()
			.body("mensagem", Matchers.contains("O CPF "+cpf+" possui restrição"));
	}
}
