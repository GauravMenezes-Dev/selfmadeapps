package com.selfmadeapps.dailyneedsclone.model;

import java.util.Map;

public class BillModel {
	private Map<String, Integer> itemsOrdered;
	private double total;
	private String username;

	public Map<String, Integer> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(Map<String, Integer> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		String header = "Username: "+username+"\n\nTotal: Rs"+total;
		String items = "\n";
		for(String item: this.itemsOrdered.keySet()) {
			items +="\n"+item+": "+this.itemsOrdered.get(item)+" pcs\n";
		}
		return header+items;
	}


	

}
