package com.czechowski.spring5webfluxrest.controllers;

import com.czechowski.spring5webfluxrest.domain.Category;
import com.czechowski.spring5webfluxrest.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/api/v1/categories")
    public Flux<Category> list() {
        return categoryRepository.findAll();
    }

    @GetMapping("/api/v1/categories/{id}")
    public Mono<Category> getCategoryById(@PathVariable String id) {
        return categoryRepository.findById(id);
    }
}
