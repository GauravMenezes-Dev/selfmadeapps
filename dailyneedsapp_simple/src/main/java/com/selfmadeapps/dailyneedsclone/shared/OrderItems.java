package com.selfmadeapps.dailyneedsclone.shared;

import com.selfmadeapps.dailyneedsclone.entity.ItemEntity;

public class OrderItems {
	private ItemEntity item;
	private int qty;
	public ItemEntity getItem() {
		return item;
	}
	public void setItem(ItemEntity item) {
		this.item = item;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
