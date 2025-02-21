package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{

    private static int idCounter = 1;
    private String orderId;
    private Customer customer;
    private List<FeastItem> itemList;
    private String eventDate;
    private int numberOfTables;
    private double totalAmount;

    public Order(Customer customer, List<FeastItem> itemList, String eventDate, int numberOfTables) {
        this.orderId = "" + (idCounter++);
        this.customer = customer;
        this.itemList = itemList;
        this.eventDate = eventDate;
        this.numberOfTables = numberOfTables;
        this.totalAmount = calculateTotal();
    }

    // Tính tổng tiền dựa trên danh sách món ăn và số lượng bàn
    private double calculateTotal() {
        double total = 0;
        for (FeastItem item : itemList) {
            total += item.getPrice();
        }
        return total * numberOfTables;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Order.idCounter = idCounter;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<FeastItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<FeastItem> itemList) {
        this.itemList = itemList;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------------------------------------------\n");
        sb.append("Customer order information [Order ID: ").append(orderId).append("]\n");
        sb.append("----------------------------------------------------------------\n");
        sb.append("Code          : ").append(customer.getCustomerId()).append("\n");
        sb.append("Customer name : ").append(customer.getName()).append("\n");
        sb.append("Phone number  : ").append(customer.getPhone()).append("\n");
        sb.append("Email         : ").append(customer.getEmail()).append("\n");
        sb.append("----------------------------------------------------------------\n");
        sb.append("Event date    : ").append(eventDate).append("\n");
        sb.append("Number of tables: ").append(numberOfTables).append("\n");

        for (FeastItem item : itemList) {
            sb.append("----------------------------------------------------------------\n");
            sb.append("Code of Set Menu : ").append(item.getItemId()).append("\n");
            sb.append("Set menu name    : ").append(item.getItemName()).append("\n");
            sb.append("Price            : ").append(String.format("%,.0f", item.getPrice())).append(" Vnd\n");
            sb.append("Ingredients      : \n");

            // Xuống dòng khi gặp ký tự `#`
            sb.append(item.getIngredients().replace("#", "\n")).append("\n");
        }

        sb.append("----------------------------------------------------------------\n");
        sb.append("Total cost       : ").append(String.format("%,.0f", totalAmount)).append(" VND\n");
        sb.append("----------------------------------------------------------------\n");
        return sb.toString();
    }
}
