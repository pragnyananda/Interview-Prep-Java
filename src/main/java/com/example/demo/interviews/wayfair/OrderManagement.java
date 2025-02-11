package com.example.demo.interviews.wayfair;

/*
--Problem Statement

An order management system for a restaurant is being developed. Implement the IOrder and IOrderSystem interface as described.



Create a class called Order implementing IOrder interface.

Create a new class called OrderSystem and implement the IOrderSystem interface supporting following use-cases.

Add the order item to the cart
Remove the order item from the cart
Calculate the discounted prices for each order in the cart and sum the values. Discounted Price = Order Price - ((Order Price * Discount Rate) / 100).

Calculate discounts for each product category in the cart. The method returns a map of categories name and the discount amount. (key = category, value = category discount)

Retrieve the list of items in the cart along with their quantities.



Category determination is done as follows:

Order Price <= 10: Cheap
Order Price <= 20 and OrderPrice > 10: Moderate
Order Price > 20: Expensive
The discount per category is as follows:

Cheap  = 10%
Moderate = 20%
Expensive = 30%


Example

There are 2 Order objects, with name, price:

Pizza 40

Sandwich 30



After they are added, calculate the total amount from orders.

e.g. The Price for Pizza = 40 and 40 > 20, so the discount equals 30%. The discounted price = 40 - ((40*30)/100) = 28. Similarly, the 30% discounted price of Sandwich is 21.



Output:

Total Amount: 49

Expensive Category Discount: 21

Pizza (1 items)

Sandwich (1 items)



Input Format For Custom Testing
Sample Case 1
Sample Input For Custom Testing

STDIN        Function
-----        --------
9            number of orders n = 9
Order-1 49   first order: name = 'Order-1', price = 49
Order-2 31   second order...
Order-3 74
Order-4 21
Order-5 64
Order-6 94
Order-7 23
Order-8 23
Order-9 71
Sample Output

Total Amount: 319
Expensive Category Discount: 131
Order-1 (1 items)
Order-2 (1 items)
Order-3 (1 items)
Order-4 (1 items)
Order-5 (1 items)
Order-6 (1 items)
Order-7 (1 items)
Order-8 (1 items)
Order-9 (1 items)
Explanation

9 orders are added and grouped by price category. All items are in the 'Expensive' category,
so only 1 group of items is reported. Data is read, method calls are made, and results are printed by the provided stub.

 */

import java.util.*;
interface IOrder {
    void setName(String name);
    String getName();
    void setPrice(int price);
    int getPrice();
}
interface IOrderSystem {
    void addToCart(IOrder order);
    void removeFromCart(IOrder order);
    int calculateTotalAmount();
    Map<String, Integer> categoryDiscounts();
    Map<String, Integer> cartItems();
}
class Order implements IOrder {
    private String name;
    private int price;
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public int getPrice() {
        return price;
    }
}
class OrderSystem implements IOrderSystem {
    private List<IOrder> cart = new ArrayList<>();
    @Override
    public void addToCart(IOrder order) {
        cart.add(order);
    }
    @Override
    public void removeFromCart(IOrder order) {
        cart.remove(order);
    }
    // For each order, compute the discounted price and sum them up.
    @Override
    public int calculateTotalAmount() {
        int totalAmount = 0;
        for (IOrder order : cart) {
            int discountedPrice = calculateDiscountedPrice(order);
            totalAmount += discountedPrice;
        }
        return totalAmount;
    }
    // For each category, compute the total discount amount.
    @Override
    public Map<String, Integer> categoryDiscounts() {
        Map<String, Integer> categoryDiscounts = new TreeMap<>();

        for (String category : determineCategories()) {
            int discountedTotalPrice = 0;
            int totalPrice = 0;
            for (IOrder order : cart) {
                if (category.equals(determineCategory(order))) {
                    int discountedPrice = calculateDiscountedPrice(order);
                    discountedTotalPrice += discountedPrice;
                    totalPrice += order.getPrice();
                }
            }
            int discountAmount = totalPrice - discountedTotalPrice;
            categoryDiscounts.put(category, discountAmount);
        }
        return categoryDiscounts;
    }
    // Return a map of item names and their quantities.
    @Override
    public Map<String, Integer> cartItems() {
        Map<String, Integer> cartItems = new TreeMap<>();
        for (String itemName : determineItemNames()) {
            int quantity = countItems(itemName);
            cartItems.put(itemName, quantity);
        }
        return cartItems;
    }
    // Determine the category based on order price.
    private String determineCategory(IOrder order) {
        if (order.getPrice() <= 10)
            return "Cheap";
        else if (order.getPrice() <= 20)
            return "Moderate";
        else
            return "Expensive";
    }
    // List of categories in the required order.
    private List<String> determineCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Cheap");
        categories.add("Moderate");
        categories.add("Expensive");
        return categories;
    }
    // Correct calculation of the discounted price.
    private int calculateDiscountedPrice(IOrder order) {
        String category = determineCategory(order);
        int discountRate = 0;
        switch (category) {
            case "Cheap":
                discountRate = 10;
                break;
            case "Moderate":
                discountRate = 20;
                break;
            case "Expensive":
                discountRate = 30;
                break;
        }
        return order.getPrice() - ((order.getPrice() * discountRate) / 100);
    }
    // Helper method to get unique item names.
    private List<String> determineItemNames() {
        List<String> itemNames = new ArrayList<>();
        for (IOrder order : cart) {
            if (!itemNames.contains(order.getName())) {
                itemNames.add(order.getName());
            }
        }
        return itemNames;
    }
    // Helper method to count how many times an item appears in the cart.
    private int countItems(String itemName) {
        int count = 0;
        for (IOrder order : cart) {
            if (itemName.equals(order.getName())) {
                count++;
            }
        }
        return count;
    }
}

public class OrderManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOrders = scanner.nextInt();
        OrderSystem orderSystem = new OrderSystem();
        for (int i = 0; i < numOrders; i++) {
            String name = scanner.next();
            int price = scanner.nextInt();
            Order order = new Order();
            order.setName(name);
            order.setPrice(price);
            orderSystem.addToCart(order);
        }
        int totalAmount = orderSystem.calculateTotalAmount();
        Map<String, Integer> discounts = orderSystem.categoryDiscounts();
        Map<String, Integer> cartItems = orderSystem.cartItems();
        System.out.println("Total Amount: " + totalAmount);
        if (discounts.containsKey("Expensive") && discounts.get("Expensive") > 0) {
            System.out.println("Expensive Category Discount: " + discounts.get("Expensive"));
        }
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + " (" + entry.getValue() + " items)");
        }
        scanner.close();
    }
}
