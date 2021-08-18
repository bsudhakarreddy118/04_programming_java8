package com.learn.streams;

public class Supplier {

	private int supplierId;
	private String supplierName;

	public Supplier() {
		// default
	}

	public Supplier(int supplierId, String supplierName) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + "]";
	}

}
