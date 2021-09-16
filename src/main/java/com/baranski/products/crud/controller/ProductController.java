package com.baranski.products.crud.controller;

import com.baranski.products.crud.domain.Product;
import com.baranski.products.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> products = productService.listAll();
        model.addAttribute("listProducts",products);
        return "index";
    }


}
