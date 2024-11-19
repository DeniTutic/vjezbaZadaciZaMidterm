/* Updated Task Description: Marketplace Inventory and Order Management System
You are tasked with developing a basic inventory and order management system for a marketplace. This system should handle various types of items, organize them into customer orders, and support customer profile management. The design should allow flexibility for future expansion, and you are encouraged to use interfaces and generics where appropriate.
Requirements
1. Enum: HoneyType
Define an enum HoneyType that specifies types of honey:
BAGREMOV
LIVADSKI
This enum will be used to identify specific honey types within the system.
2. Interface: Sellable
Create an interface Sellable to represent essential behaviors for all sellable items. The Sellable interface should include:
double calculateDiscount(double discountRate): Calculates a discount on the item price using the provided discount rate.
String getDescription(): Returns a formatted description of the item, including relevant details (e.g., name, price, specific attributes).
3. Class: Item
Create an class Item that represents an item in the marketplace. The user cannot create the instance of this class. It should:
Implement the Sellable interface.
Include the following attributes:
private String barcode: A unique identifier for each item.
private String name: The name of the item.
private double price: The item’s price.
Implement calculateDiscount and getDescription as default behaviors for any item.
Provide getter and setter methods for all attributes.
4. Class: Milk
Create a concrete class Milk that extends Item. This class should:
Have an additional attribute:
private double fat: Represents the fat content in the milk product.
Provide a constructor to initialize the barcode, name, price, and fat content.
Override getDescription to include information about fat content.
Provide getter and setter methods for fat.
5. Class: Honey
Create another concrete class Honey that extends Item. This class should:
Include an additional attribute:
private HoneyType honeyType: The type of honey, based on the HoneyType enum.
Provide a constructor to initialize the barcode, name, price, and honey type.
Override getDescription to include information about honey type.
Provide getter and setter methods for honeyType.
6. Generic Class: Order
Define a generic Order class to represent a customer’s order, where T can be any type that extends Item and implements Sellable. This class should:
Have the following attributes:
private String orderNo: A unique identifier for the order.
private Date createAt: The creation date of the order.
private HashMap items: A map of items and their quantities in the order.
Include a constructor to initialize orderNo and createAt and items.
Provide a method addItem(T item, int quantity) to add an item to the order. If item is already in the order just update the quantities
Implement double calculateTotalAmount(), which calculates the total price of all items in the order based on their price and quantity.
Provide getter and setter methods for all attributes.
7. Class: Person
Define a Person class to represent a customer profile. This class should:
Include the following attributes:
private String name: The customer’s name.
private int age: The customer’s age.
private List<Order<? extends Item>> orders: A list of orders associated with the customer. This list can contain orders of various item types.
Provide a constructor to initialize the name and age attributes.
Include a method addOrder(Order<? extends Item> order) to add an order to the customer’s order history.
Provide getter and setter methods for all attributes.
8. Class: MainRun
In the MainRun class, demonstrate the functionality of the marketplace system by:
Creating instances of Milk and Honey with various attributes.
Creating an Order<Milk> and an Order<Honey>, adding the respective items to each order.
Creating a Person to represent a customer profile, and adding both milk and honey orders to this customer.
Iterating through each customer’s order history, displaying order details (including item names, prices, and quantities) and calculating the total amount for each order.
Example Scenario
Create two items, Milk and Honey, with unique attributes (fat content for Milk and honey type for Honey).
Create two orders, one containing only Milk items and the other containing only Honey items.
Create a Person for a customer who orders both milk and honey items.
Display the customer’s order details, including item descriptions and total order amounts.
*/
package org.example;

import java.util.*;

enum HoneyType {
    BAGREMOV,
    LIVADSKI
}

interface Sellable {
    double calculateDiscount(double discountRate);
    String getDescription();
}

abstract class Item implements Sellable {
    private String barcode;
    private String name;
    private double price;

    public Item(String barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    @Override
    public double calculateDiscount(double discountRate) {
        return price - (price * discountRate);
    }

    @Override
    public String getDescription() {
        return "Barcode: " + barcode + ", Name: " + name + ", Price: " + price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Milk extends Item {
    private double fat;

    public Milk(String barcode, String name, double price, double fat) {
        super(barcode, name, price);
        this.fat = fat;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Fat Content: " + fat + "%";
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }
}

class Honey extends Item {
    private HoneyType honeyType;

    public Honey(String barcode, String name, double price, HoneyType honeyType) {
        super(barcode, name, price);
        this.honeyType = honeyType;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Honey Type: " + honeyType;
    }

    public HoneyType getHoneyType() {
        return honeyType;
    }

    public void setHoneyType(HoneyType honeyType) {
        this.honeyType = honeyType;
    }
}

class Order<T extends Item & Sellable> {
    private String orderNo;
    private Date createAt;
    private HashMap<T, Integer> items = new HashMap<>();

    public Order(String orderNo, Date createAt) {
        this.orderNo = orderNo;
        this.createAt = createAt;
    }

    public void addItem(T item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (Map.Entry<T, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public HashMap<T, Integer> getItems() {
        return items;
    }
}

class Person {
    private String name;
    private int age;
    private List<Order<? extends Item>> orders = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addOrder(Order<? extends Item> order) {
        orders.add(order);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order<? extends Item>> getOrders() {
        return orders;
    }
}

public class MainRun {
    public static void main(String[] args) {
        Milk milk1 = new Milk("001", "Fresh Milk", 2.5, 3.5);
        Milk milk2 = new Milk("002", "Whole Milk", 3.0, 4.0);

        Honey honey1 = new Honey("101", "Organic Honey", 10.0, HoneyType.BAGREMOV);
        Honey honey2 = new Honey("102", "Wildflower Honey", 12.0, HoneyType.LIVADSKI);

        Order<Milk> milkOrder = new Order<>("MILK001", new Date());
        milkOrder.addItem(milk1, 2);
        milkOrder.addItem(milk2, 3);

        Order<Honey> honeyOrder = new Order<>("HONEY001", new Date());
        honeyOrder.addItem(honey1, 1);
        honeyOrder.addItem(honey2, 2);

        Person customer = new Person("John Doe", 30);
        customer.addOrder(milkOrder);
        customer.addOrder(honeyOrder);

        for (Order<? extends Item> order : customer.getOrders()) {
            System.out.println("Order No: " + order.getOrderNo());
            for (Map.Entry<? extends Item, Integer> entry : order.getItems().entrySet()) {
                System.out.println(entry.getKey().getDescription() + ", Quantity: " + entry.getValue());
            }
            System.out.println("Total Amount: " + order.calculateTotalAmount());
            System.out.println();
        }
    }
}
