package mypackage.classes;

public class Purchase_order {

    private int orderId;
    private String productName;
    private int quantity;
    private double pricing;
    private double mrp;
    private int customerId;
    private String city;

    // Constructor with parameters
    public Purchase_order(int orderId, String productName, int quantity, double pricing, double mrp, int customerId, String city) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.pricing = pricing;
        this.mrp = mrp;
        this.customerId = customerId;
        this.city = city;
    }

    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
	// Getters and setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricing() {
		return pricing;
	}

	public void setPricing(double pricing) {
		this.pricing = pricing;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
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
		return "PurchaseOrder{" + "orderId=" + orderId + ", productName='" + productName + '\'' + ", quantity="
				+ quantity + ", pricing=" + pricing + ", mrp=" + mrp + ", customerId=" + customerId +", city='" + city + '\''+ '}';
	}

}
