package api_delete_simulacao;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import util.BaseAcesso;

public class DeleteSimulacao extends BaseAcesso {
	
	String id;
	String consultaCpfString;
	String nome = "Ramires dos Santos";
	String cpf = "37178545822";
	

	@Test
	public void deletarCadastro() {
		inserirParaDeletar();
		pegarId();
		
		RestAssured.given()
		.delete("v1/simulacoes/"+id)
		.then()
		.statusCode(200).log().all()
		.and().assertThat();
		System.out.println("----CPF Deletado com Sucesso----");
		
		
	}
	
	@Test
	public void inserirParaDeletar() {
		
		RestAssured.given()
			.contentType("application/json")
			.body("{\n" +
                    "  \"nome\": \""+nome+" \",\n" +
                    "  \"cpf\": \""+cpf+" \",\n" +
                    "  \"email\": \"jh@testando.com.br\",\n" +
                    "  \"valor\": 5000,\n" +
                    "  \"parcelas\": 3,\n" +
                    "  \"seguro\": true\n" +
                    "}")
			.when()
			.post("v1/simulacoes")
			.body();
	}
	
	@Test
	public void pegarId() {
		Response response = RestAssured.given()
				.get("v1/simulacoes");
		response.then();
		id = response.jsonPath().getString("id[1]");
		
	}
}
