package jp.co.internous.origami.model.domain.dto;

import java.sql.Timestamp;

public class CartDto {

	private int id;
	private int productCount;
	private String imageFullPath;
	private String productName;
	private int price;
	private int subtotal;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getImageFullPath() {
		return imageFullPath;
	}

	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}

	public String getProductName() {
		return productName;
	}

	public void serProductName(String productName) {
		this.productName = productName;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}