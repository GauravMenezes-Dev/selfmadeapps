package com.selfmadeapps.dailyneedsclone.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class OrderEntity implements Comparable<OrderEntity>{

	@Id
	private String id;
	private String username;

	private List<ItemEntity> items;
	private List<Integer> qtys;
	private boolean paid = false;
	private Date orderDate = new Date();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", username=" + username + ", items=" + items + ", qtys=" + qtys + "]";
	}

	public List<Integer> getQtys() {
		return qtys;
	}

	public void setQtys(List<Integer> qtys) {
		this.qtys = qtys;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public int compareTo(OrderEntity oEnt) {
		return this.getId().compareTo(oEnt.getId());
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public double returnTotal() {
		double total = 0;
		List<ItemEntity> iList = this.getItems();
		List<Integer> qList = this.getQtys();
		for(int i = 0 ; i < iList.size(); i++) {
			total += (iList.get(i).getPrice() * qList.get(i));
		}
		return total;
	}
}
