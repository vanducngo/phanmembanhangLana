package model;

import com.google.gson.annotations.SerializedName;

public class OrderDetail extends BaseModel{
	
	@SerializedName("order")
	private Order order;
	
	public Order getOrder() {
		return order;
	}
}
