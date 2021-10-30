package br.com.caelum.estoque.servico;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@RequestWrapper(localName="listaItens")
	@WebMethod(operationName = "todosOsItens")
	@ResponseWrapper(localName="itens")
	@WebResult(name = "item")
	public List<Item> getItens(@WebParam(name="filtros") Filtros filtros) {

		List<Filtro> lista = filtros.getLista();

		System.out.println("Chamando getItens()");
		//return new ListaItens(dao.todosItens(lista));
		return dao.todosItens(lista);
	}
	
	@WebMethod(operationName="CadastrarItem") 
	public Item cadastrarItem(@WebParam(name="tokenUsuario", header=true) TokenUsuario token, @WebParam(name="item") Item item) throws AutorizacaoException {
		
		if(!new TokenDao().ehValido(token)) {
		    throw new AutorizacaoException("Autorizacao falhou");
		}
		
		 //novo
        new ItemValidador(item).validate();
		
	    System.out.println("Cadastrando " + item);
	    this.dao.cadastrar(item);
	    return item;
	}
}
