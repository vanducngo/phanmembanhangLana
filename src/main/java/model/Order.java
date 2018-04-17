package model;

import com.google.gson.annotations.SerializedName;

public class Order {

	@SerializedName("label_id")
	private String orderId;

	@SerializedName("customer_fullname")
	private String customerName;

	@SerializedName("address")
	private String address;

	@SerializedName("value")
	private String price;

	public String getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getAddress() {
		return address;
	}

	public String getOrderPrice() {
		return price;
	}
}
