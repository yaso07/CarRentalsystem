package com.carRentalAdminResources;

public class Addcar {
	
   private String vehicleBrand, type;
   long price;
   private int noOfCars;
   public  int availableCars=0;

   public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrands(String vehicleBrands) {
		this.vehicleBrand = vehicleBrands;
	} 

 

 
public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public long getPrice() {
	return price;
}

public void setPrice(long price) {
	this.price = price;
}

public int getNoOfCars() {
	return noOfCars;
}

public void setNoOfCars(int noOfCars) {
	this.noOfCars = noOfCars;
}

 
	

}
