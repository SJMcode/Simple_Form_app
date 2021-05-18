package com.example.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Products;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/{userId}")
	public String displayUser(@PathVariable int userId) {
		return "User Found "+ userId;
	}

	@RequestMapping("/{userId}/invoice")
	public String displayUserInvoice(@PathVariable int userId,@RequestParam(value="d", required=false) Date dateOrNull) {
		return "Invoice found for the user : "+ userId+" on the date: "+dateOrNull;
	}
	
	@RequestMapping("/{userId}/product")
	public List<String> displayUserProduct(@PathVariable int userId) {
		return Arrays.asList("Shoes","Bag","Clothes");
	}
	
	@RequestMapping("/{userId}/product_list")
	public List<Products> displayUserDefinedProduct(@PathVariable int userId) {
		return Arrays.asList(new Products(1,"Bag",49.99),
				new Products(2,"Shoe",59.99),
				new Products(3,"Shirt",29.99),
				new Products(4,"Wallet",19.99),
				new Products(5,"Belt",9.99),
				new Products(6,"Trouser",35.99),
				new Products(7,"Cap",10.99));
	}
}
