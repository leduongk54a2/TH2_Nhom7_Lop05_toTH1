package com.example.th2.control;


import com.example.th2.entity.ProductEntity;
import com.example.th2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private  final ProductRepository repo;

    @Autowired
    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String showProducts(Model model) {
        model.addAttribute("products",(List<ProductEntity>)repo.findAll());
        return "product";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("product",new ProductEntity());
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid ProductEntity pe) {

        repo.save(pe);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable(name="id") String id,Model model) {
        ProductEntity pe = repo.findProductEntityByID(id).get(0);
        model.addAttribute("product",pe);
        return "delete";
    }
    @PostMapping("/delete/{id}")
    public  String deleteProduct(@PathVariable(name="id") String id) {
        repo.deleteById(id);
        return "redirect:/product";
    }





    @GetMapping("/edit/{id}")
    public String showFormAdd(@PathVariable(name="id") String id,Model model) {
        ProductEntity pe = repo.findProductEntityByID(id).get(0);
        model.addAttribute("product",pe);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public  String editProduct(ProductEntity pe ) {
        repo.updateProductEntity(pe.getCode(), pe.getDes(),pe.getPrice());
        return "redirect:/product";
    }


}
