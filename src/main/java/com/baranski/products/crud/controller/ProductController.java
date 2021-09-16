package com.baranski.products.crud.controller;

import com.baranski.products.crud.domain.Product;
import com.baranski.products.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/new")
    public String showNewProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "newProduct";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.addProduct(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id")long id){
        ModelAndView modelAndView = new ModelAndView("editProduct");
        Product product = productService.getProduct(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }


}
