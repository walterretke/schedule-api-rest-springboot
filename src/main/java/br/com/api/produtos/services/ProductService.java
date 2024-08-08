package br.com.api.produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.models.ProductModel;
import br.com.api.produtos.models.ResponseModel;
import br.com.api.produtos.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ResponseModel responseModel;

    // Listar produtos
    public Iterable<ProductModel> listar() {
        return productRepository.findAll();
    }

    // Cadastrar e alterar produtos
    public ResponseEntity<?> storeUpdate(ProductModel productModel, String action) {

        if (productModel.getName().equals("")) {
            responseModel.setMessage("O nome do produto é obrigatório!");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else if (productModel.getBrand().equals("")) {
            responseModel.setMessage("O nome da marca é obrigatório!");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else {
            if (action.equals("store")) {
                return new ResponseEntity<ProductModel>(productRepository.save(productModel), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ProductModel>(productRepository.save(productModel), HttpStatus.OK);
            }
        }
    }

    // Remover produtos

    public ResponseEntity<ResponseModel> remove(long id) {
        productRepository.deleteById(id);
        responseModel.setMessage("O produto foi removido com sucesso!");;
        return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }

}
