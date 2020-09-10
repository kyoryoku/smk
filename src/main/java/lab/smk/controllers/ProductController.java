package lab.smk.controllers;

import lab.smk.models.Product;
import lab.smk.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public String getProductId(@PathVariable Long id, Model model){

        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }
}
