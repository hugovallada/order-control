package com.github.hugovallada.orderscontrol.services;

import com.github.hugovallada.orderscontrol.entities.Category;
import com.github.hugovallada.orderscontrol.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> optCategory = repository.findById(id);
        return optCategory.get();
    }

}
