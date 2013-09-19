package com.zhou.home.model;

public class ShopInfo {
	private int shopId;
	private String name;
	
	
	public ShopInfo(int shopId, String name) {
		super();
		this.shopId = shopId;
		this.name = name;
	}
	
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
