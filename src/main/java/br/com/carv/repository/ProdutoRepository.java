package br.com.carv.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.carv.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto>{

}
