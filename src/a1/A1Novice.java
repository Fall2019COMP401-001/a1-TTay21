package a1;

import java.util.Scanner;
import java.text.DecimalFormat;

public class A1Novice {

	static class Customer {

		String firstName = "";
		String lastName = "";
		int items = 0;
		int count = 0;
		// this function is used to get the quantity of each item, 1 by 1
		int[] quantity;  
		void getQuantity(int amount) {
			this.quantity[this.count] = amount;
		};
		void setQuantity() {
			quantity = new int[this.items];
			for (int i = 0; i < quantity.length; i++) {
				this.quantity[i] = 0;
			}
		}
		double[] price;
		void setPrices() {
			price = new double[this.items];
			for (int i = 0; i < price.length; i++) {
				this.price[i] = 0.0;
			}
		}
		void getPrice(double price) {
			this.price[this.count] = price;
			this.count++;
		};
		float total = 0.00f;
		float getTotal () {
			for (int i = 0; i < items; i++) {
				this.total += (this.quantity[i]*this.price[i]);

			}
			return this.total;
		}
		};
	static Customer makeCustomer() {
	return new Customer();
	}
	public static void main(String[] args) {
		
		Scanner user_input = new Scanner(System.in);
	    DecimalFormat twoSpaces = new DecimalFormat("##.##");

		int customerNum = user_input.nextInt();
		Customer[] customer = new Customer [customerNum];
		// this for loop is to create a new customer for each index, since
		// I cannot figure out how to create customers from the array as the program goes on
		for (int i = 0; i < customerNum; i++) {
			customer[i] = makeCustomer();
		}
		for (int i = 0; i < customerNum; i++) {
			customer[i].firstName = user_input.next();	
			customer[i].lastName = user_input.next();
			customer[i].items = user_input.nextInt();
			customer[i].setQuantity();
			customer[i].setPrices();
			for (int a = 1; a <= customer[i].items; a++ ) {
				int amount = user_input.nextInt();
				customer[i].getQuantity(amount);
				String itemName = user_input.next();
				double price = user_input.nextDouble();
				customer[i].getPrice(price);
			}
			}

		for (int i = 0; i < customer.length; i++) {
			System.out.println(customer[i].firstName.charAt(0) + ". " + 
					customer[i].lastName + ": " + String.format("%.2f", customer[i].getTotal()));
		}
		user_input.close();
		}
	}
