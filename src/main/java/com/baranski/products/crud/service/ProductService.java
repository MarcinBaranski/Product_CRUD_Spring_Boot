package com.baranski.products.crud.service;

import com.baranski.products.crud.domain.Product;
import com.baranski.products.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> listAll(){
        return repository.findAll();
    }

    public Product getProduct(Long id){
        return repository.getById(id);
    }

    public void addProduct(Product product){
        repository.save(product);
    }

    public void deleteProduct(Long id){
        repository.deleteById(id);
    }

}
