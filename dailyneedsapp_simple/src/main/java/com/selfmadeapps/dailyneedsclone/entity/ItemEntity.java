package com.selfmadeapps.dailyneedsclone.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item")
public class ItemEntity {

	@Override
	public String toString() {
		return "ItemEntity [itemName=" + itemName + ", category=" + category + ", price=" + price + "]";
	}

	@Id
	private String itemName;
	private String category;
	private double price;

	public String getItem_name() {
		return itemName;
	}

	public void setItem_name(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}

