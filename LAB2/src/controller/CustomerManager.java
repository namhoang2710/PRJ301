package controller;

import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerManager {

    private static List<Customer> listC;

    public CustomerManager() {
        listC = new ArrayList<>();
    }

    public List<Customer> getListC() {
        return listC;
    }

    public void registerCustomers() {
        
        
            String customerId = Inputter.getString("Enter cusID with strat (C|G|K) end 4 digit:", Acceptable.CUSTOMER_ID);
            String customerName = Inputter.getString("Enter name customer with length 2-25 character:", Acceptable.CUSTOMER_NAME);
            String phoneNumber = Inputter.getString("Enter phone number of customer: ", Acceptable.PHONE_VALID_VIETNAM);
            String email = Inputter.getString("Enter email of student: ", Acceptable.CUSTOMER_EMAIL);
            listC.add(new Customer(customerId, customerName, phoneNumber, email));
            System.out.println("Register Customer Succesfully!!!");
           
        
    }}