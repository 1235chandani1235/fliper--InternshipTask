package mypackage.classes;

public class Shipping_details {

	private int shippingId;
	private String address;
	private String city;
	private String pincode;
	private int purchaseOrderId;
	private int customerId;

	// Constructor
	public Shipping_details(int shippingId, String address, String city, String pincode, int purchaseOrderId, int customerId) {
        this.shippingId = shippingId;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.purchaseOrderId = purchaseOrderId;
        this.customerId = customerId;
    }

	// Getters and setters
	public int getShippingId() {
		return shippingId;
	}

	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	// toString() method
	@Override
	public String toString() {
		return "ShippingDetails{" + "shippingId=" + shippingId + ", address='" + address + '\'' + ", city='" + city
				+ '\'' + ", pincode='" + pincode + '\'' + ", purchaseOrderId=" + purchaseOrderId + ", customerId="
				+ customerId + '}';
	}

}
