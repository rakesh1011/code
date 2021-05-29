package com.pms.ust.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.model.Cart;
import com.ust.pms.model.Product;
import com.ust.pms.service.CartService;
import com.ust.pms.service.ProductService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;
	
	@RequestMapping("/viewCartItems")
	public ModelAndView viewCartItems() {
		List<Cart> cartItems = cartService.getCartDetails();
		return new ModelAndView("viewCartItems","cartItems", cartItems);
	}
	
	@RequestMapping("/Delete/{cartProductId}")
	public ModelAndView deleteCartProduct(@PathVariable("cartProductId")String cartProductId) {
	  
	  Integer pId = new Integer(cartProductId); cartService.deleteMyCartById(pId);
	  ModelAndView view = new ModelAndView();
	  view.addObject("cartProductId",cartProductId);
	  
	  return new ModelAndView("redirect:/viewCartItems"); 
	  }



//	@RequestMapping("/cartList")
//	public ModelAndView checkProductList(Model model, Product products) {
//
//		model.addAttribute("username", UserUtil.getUserName());
//		model.addAttribute("command", products);
//
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("cart");
//
//		if(products.getProductId()!=0) {
//		Product product = productService.getProduct(products.getProductId());
//		Cart cart = new Cart();
//		cart.setProductId(product.getProductId());
//		cart.setProductName(product.getProductName());
//		cart.setPrice(product.getPrice());
//		cart.setQuantityOnHand(product.getQuantityOnHand());
//
//		cartService.saveCart(cart);
//
//		productService.deleteProduct(products.getProductId());
//		}
		//

//		List<Cart> cartList = cartService.getCartDetails();
//		mav.addObject("cartList", cartList);
//
//		return mav;
//
//	}

//	@RequestMapping("/deleteCart/{productId}")
//	public String deleteCart(@PathVariable("productId") int productId, Model model) {
//			
//		Cart cart = cartService.getCart(productId);
//		
//		
//		/*
//		 * Product product=new Product(); product.setProductId(cart.getProductId());
//		 * product.setProductName(cart.getProductName());
//		 * product.setQuantityOnHand(cart.getQuantityOnHand());
//		 * product.setPrice(cart.getPrice()); productService.saveProduct(product);
//		 */
//		 
//		
//		
//		
//		cartService.deleteCart(cart);
//		
//		
//		
//		return "redirect:/cartList";
//	}
		@RequestMapping("/cart/{productId}")
				public ModelAndView saveCart(@PathVariable("productId") int productId, Model model) {
			     ModelAndView view = new ModelAndView();
			     
			    Product product=productService.getProduct(productId);
				System.out.println("My product--------------------------------------------------------------------------------------------"+product.toString());
				Cart cart=new Cart(product.getProductId(),product.getProductName(),product.getQuantityOnHand(),product.getPrice(),product.getQuantityOnHand() * product.getPrice());
				
				
				/*
				 * if(cartService.getCartDetails().listIterator().stream().map(i->i.itemid).
				 * distinct().count() > 11) { cartService.saveCart(cart); }
				 */
				 
				cartService.saveCart(cart);
				
				model.addAttribute("product",product);
				view.addObject("product",product); 
				return new ModelAndView("cart", "command", new Product());
				//List<Product> products =productService.getProducts();
				//return new ModelAndView("viewAllProducts","products",products);
				
				
//				@RequestMapping("/cart/{productId}") 
//				public ModelAndView cartProduct(@PathVariable("productId") int productId, Model model) { 
//					//	  command 
//				  //code to fetch all the details of this product
//				  // add this product	  to cart table 
//				  //update product - minus 1 quantity of this productid
//				  ModelAndView view = new ModelAndView(); 
//				  Product product=productService.getProduct(productId);
//				  System.out.println(product.getProductName()+"product price :"+product. getPrice());
//				  model.addAttribute("product",product);
//				  view.addObject("product",product); return new ModelAndView("cart", "command", new Product());
//				
				//Cart cart = cartService.getCart(productI);		
////		
////		/*
////		 * Product product=new Product(); product.setProductId(cart.getProductId());
////		 * product.setProductName(cart.getProductName());
////		 * product.setQuantityOnHand(cart.getQuantityOnHand());
////		 * product.setPrice(cart.getPrice()); productService.saveProduct(product);
////		 */
////		 
////		
////		
////		
////		cartService.deleteCart(cart);
////		
////		
////		
////		return "redirect:/cartList";
				//return "Pruduct saved";
				}

}
