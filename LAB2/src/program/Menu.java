package program;

import controller.CustomerManager;
import controller.FeastMenuManager;
import controller.Inputter;
import controller.OrderManager;

public class Menu {

    public void display() {
        int choice;
         
        CustomerManager customerManager = new CustomerManager();
        FeastMenuManager feastMenuManager = new FeastMenuManager();
        OrderManager orderManager = new OrderManager();
        

        do {
            System.out.println("===================================");
            System.out.println("******Traditional Feast Order Management******");
            System.out.println("===================================");
            System.out.println("1.  Registration New Customer");
            System.out.println("2.  Update Profile Customer");
            System.out.println("3.  Search Customer By Name");
            System.out.println("4.  Display Feast Menu");
            System.out.println("5.  Order FeastItem");
            System.out.println("6.  Update Order FeastItem");
            System.out.println("7.  Save Data To File");
            System.out.println("8.  Display Customer or Order lists");
            System.out.println("9.  Exist Program");
            System.out.println("===================================");
            choice = Inputter.getInt("Enter your choice: ", 1, 10);
            switch (choice) {
                case 1:
                    customerManager.registerCustomers();
                    break;
                case 2:
                    customerManager.updateCustomerById();
                    break;
                case 3:
                    customerManager.searchCustomerByName();
                    break;
                case 4:
                    feastMenuManager.displayFeastItem();
                    break;
                case  9:
                    break;
            }
        } while (choice != 9);
    }
}
