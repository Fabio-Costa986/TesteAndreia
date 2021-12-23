package api_post_simulacao;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import util.BaseAcesso;


public class CadastroSimulacao extends BaseAcesso{
	
	//Altere somente os valores de nome e cpf abaixo:
	String nome = "Deyverson Ramires";
	String cpf = "73366853077";
	
	@Test
	public void cadastrarSimulacaoPositivo() {
		
		RestAssured.given()
			.contentType("application/json")
			.body("{\n" +
                    "  \"nome\": \""+nome+" \",\n" +
                    "  \"cpf\": "+cpf+",\n" +
                    "  \"email\": \"db@testando.com.br\",\n" +
                    "  \"valor\": 5000,\n" +
                    "  \"parcelas\": 3,\n" +
                    "  \"seguro\": true\n" +
                    "}")
			.when().log().all()
			.post("v1/simulacoes")
			.then().statusCode(201)
			.body("cpf", Matchers.is(cpf));
		System.out.println("----Cadastro Realizado com Sucesso----");
		
	}
	
	@Test
	public void falhadeInformacoesNoCadastro() {
		
		RestAssured.given()
			.contentType("application/json")
			.body("{\n" +
                    "  \"nome\": \"Carlitos Teves \",\n" +
                    "  \"email\": \"ct@teste.com.br\",\n" +
                    "  \"valor\": 2000,\n" +
                    "  \"parcelas\": 2,\n" +
                    "  \"seguro\": true\n" +
                    "}")
			.when().log().all()
			.post("v1/simulacoes")
			.then().statusCode(400);
		System.err.println("----Falta de informação----");
		
	}
	
	@Test
	public void tentativaDeCadastroComCpfNaBase() {
		
		RestAssured.given()
			.contentType("application/json")
			.body("{\n" +
                    "  \"nome\": \"Miguel Amorim \",\n" +
                    "  \"cpf\": \"35615569820\",\n" +
                    "  \"email\": \"jv@teste.com.br\",\n" +
                    "  \"valor\": 1500,\n" +
                    "  \"parcelas\": 3,\n" +
                    "  \"seguro\": true\n" +
                    "}")
			.when().log().all()
			.post("v1/simulacoes")
			.then().statusCode(409);
		System.err.println("----Erro ao tentar cadastra CPF já existente----");
		
	}
	

}
