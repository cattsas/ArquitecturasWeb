package com.producto.controller;

import com.producto.model.Product;
import com.producto.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Products", description = "Servicio de productos")
public class ProductController {
    @Qualifier("productService")
    @Autowired
    private ProductService service;

    public ProductController(@Qualifier ("productService") ProductService service){
        super();
        this.service = service;
    }

    //metodos para controller
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getProducts();
    }

    @PostMapping("/products")
    public Product newProduct(@RequestBody Product p){
        return service.newProduct(p);
    }
    //devolveria un listado de productos

    @PutMapping("/products/{id}")
    Product modifyProduct (@RequestBody Product productUpdated, @PathVariable Integer id) {return service.updateProduct(productUpdated,id);}

    @GetMapping("/products/{id}")
    Optional<Product> getById (@PathVariable Integer id){return service.getById(id);}

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value="id")int id) {
        service.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
