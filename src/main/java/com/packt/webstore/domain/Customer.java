package com.packt.webstore.domain;


//Domain object
public class Customer {
	
	private static final long serialVersionUID = 3676730792576131001L;

	private String customerId;
	private String name;
	private String address;
	private long noOfOrdersMade;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public long getNoOfOrdersMade() {
		return noOfOrdersMade;
	}


	public void setNoOfOrdersMade(long noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (noOfOrdersMade ^ (noOfOrdersMade >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noOfOrdersMade != other.noOfOrdersMade)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Customer with Id: " + customerId + ", "
				+ "name - " + name + ", address - " 
				+ address + ", noOfOrdersMade: "
				+ noOfOrdersMade;
	}
	
	
	
	
}
