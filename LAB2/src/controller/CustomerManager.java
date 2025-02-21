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
           
        
    }

    public void updateCustomerById() {
       
            String customerId = Inputter.getString("Enter cusID with strat (C|G|K) end 4 digit:", Acceptable.CUSTOMER_ID);
            Customer customerUpdate = Inputter.getCustomerById(customerId, listC);
            if (customerUpdate == null) {
                System.out.println("This customer does not exist.");
                
            } else {
                String customerName = Inputter.getString("Enter name customer with length 2-25 character:", Acceptable.CUSTOMER_NAME);
                String phoneNumber = Inputter.getString("Enter phone number of customer: ", Acceptable.PHONE_VALID_VIETNAM);
                String email = Inputter.getString("Enter email of student: ", Acceptable.CUSTOMER_EMAIL);
                customerUpdate.setName(customerName);
                customerUpdate.setPhone(phoneNumber);
                customerUpdate.setEmail(email);
            }
          
    }

    public void searchCustomerByName() {
        
        
            String keyWord = Inputter.getStringEmpty("Enter the full or partial name to search:", Acceptable.CUSTOMER_NAME);
            //Tìm kiếm khách hàng với keywword
            List<Customer> listS = searchCustomerByKeyWord(keyWord);
            if (listS.isEmpty()) {
                //Nếu không tìm thấy đối tượng nào 
                System.out.println("No one matches the search criterial!");
            } else {
                System.out.println("\n------------------------------------------------------------------");
                System.out.printf("%-8s | %-25s | %-10s | %-25s%n", "Code", "Customer Name", "Phone", "Email");
                System.out.println("------------------------------------------------------------------");
                for (Customer c : listS) {
                    System.out.printf("%-8s | %-25s | %-10s | %-25s%n",
                            c.getCustomerId(), c.getName(), c.getPhone(), c.getEmail());
                }
                System.out.println("------------------------------------------------------------------");
            }
    }

    private List<Customer> searchCustomerByKeyWord(String keyWord) {
        List<Customer> listTemp = new ArrayList<>();
        for (Customer customer : listC) {
            if (customer.getName().toLowerCase().contains(keyWord.toLowerCase())) {
                listTemp.add(customer);
            }
        }
        return listTemp;
    }
}
    

