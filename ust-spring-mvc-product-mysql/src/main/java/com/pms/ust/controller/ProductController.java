


package com.pms.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.model.Product;
import com.ust.pms.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("/addProduct")
	public ModelAndView addProduct() {
		// command

		return new ModelAndView("addProduct", "command", new Product());
	}

	
//	@RequestMapping("/cart/{productId}") 
//	public ModelAndView cartProduct(@PathVariable("productId") int productId, Model model) { 
//		//	  command 
//	  //code to fetch all the details of this product
//	  // add this product	  to cart table 
//	  //update product - minus 1 quantity of this productid
	
//	  ModelAndView view = new ModelAndView(); 
//	  Product product=productService.getProduct(productId);
//	  System.out.println(product.getProductName()+"product price :"+product. getPrice());
//	  model.addAttribute("product",product);
//	  view.addObject("product",product); return new ModelAndView("cart", "command",
//	  new Product());
//	  
//	  }
	 
	
	
	  @RequestMapping("/delete/{productId}") public ModelAndView
	  deleteProduct(@PathVariable("productId")String productId) {
	  
	  Integer pId = new Integer(productId); productService.deleteProduct(pId);
	  ModelAndView view = new ModelAndView();
	  view.addObject("productId",productId);
	  
	  return new ModelAndView("redirect:/viewAllProducts"); 
	  }
	 
	  
	@RequestMapping("/saveProduct")
	public String saveProduct(Product product) {
		productService.saveProduct(product);
		return "success";
	}

	@RequestMapping("/searchProductByIdForm")
	public ModelAndView searchProductByIdForm() {
		return new ModelAndView("searchProductByIdForm", "command", new Product());
	}

	@RequestMapping("/searchProductById")
	public ModelAndView searchProductById(Product product) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchProductByIdForm");
		int pId = product.getProductId();

		if (productService.isProductExists(pId)) {
			Product productDetails = productService.getProduct(pId);
			modelAndView.addObject("command", productDetails);

		} else {
			modelAndView.addObject("command", new Product());
			modelAndView.addObject("msg", "Product with product id :" + pId + "does not exists");
		}

		return modelAndView;
	}

	
	//delete functionality in spring boot mvc
	@RequestMapping("/deleteProductById")
	public ModelAndView deleteProductById(Product product) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchProductByIdForm");
		modelAndView.addObject("command", new Product());

		int pId = product.getProductId();

		if (productService.isProductExists(pId)) {
			productService.deleteProduct(pId);
			modelAndView.addObject("msg", "Product with product id :" + pId + "deleted successfully");

		} else {
			modelAndView.addObject("msg", "Product with product id :" + pId + "does not exists");
		}

		return modelAndView;
	}
	
	
	//Fetch all the products

	@RequestMapping("/viewAllProducts")
	public ModelAndView viewAllProducts() {
		List<Product> products = productService.getProducts();
		return new ModelAndView("viewAllProducts","products", products);
	}
	
	
}















