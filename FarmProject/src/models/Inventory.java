package models;

public class Inventory {
	private int rentMilk;
	private int salt;
	private int preLactation;
	
	public Inventory(int rentMilk, int salt, int preLactation) {
		super();
		this.rentMilk = rentMilk;
		this.salt = salt;
		this.preLactation = preLactation;
	}
	
	public Inventory() {
	}

	public int getRentMilk() {
		return rentMilk;
	}

	public void setRentMilk(int rentMilk) {
		this.rentMilk = rentMilk;
	}

	public int getSalt() {
		return salt;
	}

	public void setSalt(int salt) {
		this.salt = salt;
	}

	public int getPreLactation() {
		return preLactation;
	}

	public void setPreLactation(int preLactation) {
		this.preLactation = preLactation;
	}

	public void setInventory(int rentMilk, int salt, int preLactation) {
		this.rentMilk = rentMilk;
		this.salt = salt;
		this.preLactation = preLactation;

	}

	@Override
	public String toString() {
		return "Inventory [rentMilk=" + rentMilk + ", salt=" + salt + ", preLactation=" + preLactation + "]";
	}
	
}
