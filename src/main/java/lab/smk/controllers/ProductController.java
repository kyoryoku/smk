package lab.smk.controllers;

import lab.smk.services.journal.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public String getProduct(Model model){
        model.addAttribute("productList", productService.findAll());
        return "product";
    }

}