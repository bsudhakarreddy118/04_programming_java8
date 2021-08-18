package com.learn.streams;

public class Product {

	private int prodCode;
	private String name;
	private int price;
	private String category;
	private Supplier supplier;

	public Product() {
		//Default Constructor
	}

	public Product(int prodCode, String name, int price, String category, Supplier supplier) {
		super();
		this.prodCode = prodCode;
		this.name = name;
		this.price = price;
		this.category = category;
		this.supplier = supplier;
	}

	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getProdCode() {
		return prodCode;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "\nProduct [prodCode=" + prodCode + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", supplier=" + supplier + "]";
	}

}
