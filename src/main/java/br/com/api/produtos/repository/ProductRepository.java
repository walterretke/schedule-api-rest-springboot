package br.com.api.produtos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.models.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long> {
    
}
