package br.com.caelum.estoque.servico;

import javax.xml.ws.Endpoint;

public class PublicarEstoqueWS {
	
	public static void main(String[] args) {

		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews";

		System.out.println("EstoqueWS rodando: " + URL);

		// associando URL com implementacao
		Endpoint.publish(URL, implementacaoWS);
	}
}
