package com.rusyn.controller;

import com.rusyn.dto.ProductDto;
import com.rusyn.entity.Product;
import com.rusyn.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/product/")
    public ResponseEntity<Product> getProductById(@RequestParam("id") String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody ProductDto productDto, @RequestParam("id") String id) {
        return new ResponseEntity<>(productService.updateProduct(productDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> deleteProduct(@RequestParam("id") String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product with id:" + id + " was deleted successfully!");
    }
}
