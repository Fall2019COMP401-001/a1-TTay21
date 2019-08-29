package a1;

import java.util.Scanner;


public class A1Jedi {

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
		String[] itemName;
		void getItemName (String name) {
			this.itemName[this.count] = name;
			this.count++;
		}
		void setItemName () {
			itemName = new String[this.items];
			for (int i = 0; i < itemName.length; i++) {
			this.itemName[i] = "";  
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
	
	static class Item {
		String name;
		double price;
		int purchased = 0;
		int peoplePurchased = 0;
		
	}
	static Item makeItem() {
		return new Item();
	}
	public static void main(String[] args) {
	
		Scanner user_input = new Scanner(System.in);
		int itemNum= user_input.nextInt();
		Item[] item = new Item[itemNum];
		for (int i = 0; i < itemNum; i++) {
			item[i] = makeItem();
			item[i].name = user_input.next();
			item[i].price = user_input.nextDouble();
		}
		
		int customerNum = user_input.nextInt();
		Customer[] customer = new Customer [customerNum];
		// this for loop is to create a new customer for each index, since
		// I cannot figure out how to create customers from the array as the program goes on
		for (int i = 0; i < customerNum; i++) {
			customer[i] = makeCustomer();
			customer[i].firstName = user_input.next();
			customer[i].lastName = user_input.next();
			customer[i].items = user_input.nextInt();
			customer[i].setQuantity();
			customer[i].setItemName();
		for (int a = 0; a < customer[i].items; a++) { // edit this
				int amount = user_input.nextInt();
				customer[i].getQuantity(amount);
				String name = user_input.next();
				customer[i].getItemName(name);
				for (int b = 0; b < item.length; b++) {
					if (customer[i].itemName[a].equals(item[b].name)) {
						item[b].purchased += customer[i].quantity[a];
						item[b].peoplePurchased++;
					} 
				} 
				
			}
		}

		/* this is to calculate the total ONE TIME for each customer
		 * By doing this, whenever referencing the total amount each customer
		 * has paid, just use " customer[i].total "
		 * because the total will keep being re-calculated each time, growing in size
		 * if you do not do this
		 */

		for (int i = 0; i < item.length; i++) {
			if (item[i].purchased == 0) {
				System.out.println("No customers bought " + item[i].name);
			} else if (item[i].purchased > 0) {
				System.out.println(item[i].peoplePurchased + " customers bought " 
						+ item[i].purchased + " " + item[i].name);
			}
		}
	} // main closer
}
