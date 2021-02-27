package com.github.hugovallada.orderscontrol.services;

import com.github.hugovallada.orderscontrol.entities.Product;
import com.github.hugovallada.orderscontrol.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optProduct = repository.findById(id);

        return optProduct.get();
    }
}
