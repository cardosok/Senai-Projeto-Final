package com.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senai.model.Product;
import com.senai.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Product> listProducts = service.findAll();
		model.addAttribute("listProducts", listProducts);
		return "/index";
	}
	
	@GetMapping("/new")
	public String novo(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "newProduct";
	}
	
	@PostMapping("/save")
	public String save(Product product){
		service.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editar(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("editProduct");
		Product product = service.find(id);
		mav.addObject("product",product);
		return mav;
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/";
	}

}
