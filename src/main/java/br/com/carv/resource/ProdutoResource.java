package br.com.carv.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.carv.exception.ProdutoNotFoundException;
import br.com.carv.model.Produto;
import br.com.carv.model.dto.CadastrarProdutoDTO;
import br.com.carv.repository.ProdutoRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	private ProdutoRepository produtoRepository;

	@Inject
	public ProdutoResource(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@GET
	public List<Produto> buscarTodosProdutos() {
		PanacheQuery<Produto> result = produtoRepository.findAll();
		return result.list();
	}

	@POST
	@Transactional
	public Produto cadastrarProduto(CadastrarProdutoDTO dto) {
		Produto produto = new Produto();
		produto.setNome(dto.getNome());
		produto.setValorUnitario(dto.getValorUnitario());
		produtoRepository.persist(produto);
		return produto;
	}

	@PUT
	@Transactional
	@Path("{id}")
	public Produto atualizarProduto(@PathParam("id") Long id, CadastrarProdutoDTO dto) {

		Produto produto = produtoRepository.findById(id);
		if (produto == null) {
			throw new ProdutoNotFoundException("Produto não cadastrado. Id: " + id);
		}

		produto.setNome(dto.getNome());
		produto.setValorUnitario(dto.getValorUnitario());
		produtoRepository.persist(produto);

		return produto;

	}

	@DELETE
	@Transactional
	@Path("{id}")
	public Produto deletarProduto(@PathParam("id") Long id) {
		Produto produto = produtoRepository.findById(id);
		if (produto == null) {
			throw new ProdutoNotFoundException("Produto não cadastrado. Id: " + id);
		}
		produtoRepository.delete(produto);
		return produto;

	}
}
