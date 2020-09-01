package com.selfmadeapps.dailyneedsclone.model;

public class MarkOrderAsPaidModel {
	private String id;
	private boolean paid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "MarkOrderAsPaidModel [id=" + id + ", paid=" + paid + "]";
	}
}
