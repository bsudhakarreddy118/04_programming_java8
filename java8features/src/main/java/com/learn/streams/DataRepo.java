package com.learn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DataRepo {

	public static int[] nums = { 1, 2, 5, 6, 4, 3 };

	public static List<String> states = Arrays.asList("Karnataka", "Delhi","Goa", "Goa","UttarPradesh", "Tamilnadu");
	
	public static List<Product> products = Arrays.asList(
			new Product(101, "phone", 45, "electronics", new Supplier(1, "ABC Corp")),
			new Product(103, "tshirt", 10, "clothing",new Supplier(2, "XYZ Corp")),
			new Product(104, "camera", 20, "electronics",new Supplier(1, "ABC Corp")),
			new Product(105, "computer", 35, "electronics",new Supplier(1, "ABC Corp")),
			new Product(106, "computer", 45, "electronics",new Supplier(1, "ABC Corp")),
			new Product(102, "sweater", 15, "clothing",new Supplier(2, "XYZ Corp"))
			//new Product(107, "sweater", 15, null,new Supplier(2, "XYZ Corp"))
	);
	
	public static Optional<Product> getProductId(int id){
		return null;
	}

}