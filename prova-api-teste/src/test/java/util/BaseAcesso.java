package util;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class BaseAcesso {
	
	@BeforeClass
	public static void base() {
		
		RestAssured.baseURI = "http://localhost:8080";
		RestAssured.port = 8080;
		RestAssured.basePath = "/api";
		
	}

}
