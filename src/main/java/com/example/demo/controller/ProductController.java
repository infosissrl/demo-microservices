package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Product> getProductsById(@PathVariable("id") Integer id) {
        return productRepository.findByProductId(id);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public List<Product> getProductsByName(@PathVariable("name") String name) {
        return productRepository.findProductByLastName(name);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        List<Product> products = productRepository.findByProductId(id);
        if (products != null) {
            for (Product p : products) {
                p.setName(product.getName());
                p.setDescription(product.getDescription());
                productRepository.save(p);
            }
        }
    }
}
