package lesson10.labs.part2.prob8;

import java.util.Optional;

public class Product {
	private String productId;
	private String productName;
	private double unitPrice;
	public Product(String prodId, String prodName, double price) {
		this.productId = prodId;
		this.productName = prodName;
		this.unitPrice = price;
	}
	public String getProductId() {
		return productId;
	}
//	public String getProductName() {
//		return productName;
//	}
	
	public Optional<String> getProductName() {
		return Optional.ofNullable(productName);
	}
	public double getUnitPrice() {
		return unitPrice;
	}
}
