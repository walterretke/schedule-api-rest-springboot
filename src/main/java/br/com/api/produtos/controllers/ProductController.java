package br.com.api.produtos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.models.ProductModel;
import br.com.api.produtos.models.ResponseModel;
import br.com.api.produtos.services.ProductService;

@RestController
@CrossOrigin( origins = "*")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<ResponseModel> remove(@PathVariable long id){
        return productService.remove(id);
    }

    @GetMapping("/products")
    public Iterable<ProductModel> list(){
        return productService.listar();
    }
    
    @PostMapping("/product/store")
    public ResponseEntity<?> store(@RequestBody ProductModel productModel){
        return productService.storeUpdate(productModel, "store"); 
    }

    @PutMapping("/product/update")
    public ResponseEntity<?> update(@RequestBody ProductModel productModel){
        return productService.storeUpdate(productModel, "update"); 
    }

}
