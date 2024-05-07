package mypackage.classes;

public class Customer {
	private int customerId;
	private String customerName;
	private String email;
	private String mobileNumber;
	private String city;

	// Constructor
	 public Customer(int customerId, String customerName, String email, String mobileNumber, String city) {
	        this.customerId = customerId;
	        this.customerName = customerName;
	        this.email = email;
	        this.mobileNumber = mobileNumber;
	        this.city = city;
	    }

	// Getters and setters
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// toString() method
	@Override
	public String toString() {
		return "Customer{" + "customerId=" + customerId + ", customerName='" + customerName + '\'' + ", email='" + email
				+ '\'' + ", mobileNumber='" + mobileNumber + '\'' + ", city='" + city + '\'' + '}';
	}

}
