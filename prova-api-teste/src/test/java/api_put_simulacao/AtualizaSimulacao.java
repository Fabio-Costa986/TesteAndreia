package api_put_simulacao;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import util.BaseAcesso;

public class AtualizaSimulacao extends BaseAcesso {

	//Adicione o CPF que deseja atualizar
	String cpf = "35685559720";
	
	@Test
	public void atualizarCpfCadastrado() {
		
		RestAssured.given()
		.contentType("application/json")
		.body("{\n" +
                "  \"nome\": \"Jorgito Valdivia \",\n" +
                "  \"cpf\": \""+cpf+"\",\n" +
                "  \"email\": \"alterandoemail@teste.com.br\",\n" +
                "  \"valor\": 2000,\n" +
                "  \"parcelas\": 5,\n" +
                "  \"seguro\": false\n" +
                "}")
		.put("v1/simulacoes/"+cpf)
		.then().statusCode(200).log().all()
		.body("cpf", Matchers.is(cpf));
	System.out.println("----Cadastro Alterado com Sucesso----");
		
	}
	
	@Test
	public void atualizarCpfNaoCadastradoNaBase() {
		
		RestAssured.given()
		.contentType("application/json")
		.body("{\n" +
                "  \"nome\": \"Jorge Valdivia \",\n" +
                "  \"cpf\": \"45132565601\",\n" +
                "  \"email\": \"alterandoemail@teste.com.br\",\n" +
                "  \"valor\": 2000,\n" +
                "  \"parcelas\": 5,\n" +
                "  \"seguro\": false\n" +
                "}")
		.put("v1/simulacoes/"+cpf+"0")
		.then().statusCode(404).log().all();
	System.err.println("----CPF Não encontrado----");
		
	}
	
}
