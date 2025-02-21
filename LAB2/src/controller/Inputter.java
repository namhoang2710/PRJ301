package controller;
import java.util.List;
import java.util.Scanner;
import model.Customer;

public class Inputter {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(String msg, String regex) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();

   
            if (input.isEmpty()) {
                System.err.println("Input can't be empty. Please re-input:");
                continue;  
            }

            
            boolean check = Acceptable.isValid(input, regex);
            if (check) {
                return input;  
            } else {
                System.err.println("Input not valid. Please re-input:");
            }
        }
    }

    public static String getStringEmpty(String msg, String regex) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                break;
            } else {
                if (Acceptable.isValid(input, regex)) {
                    return input;
                } else {
                    System.err.print("Input not valid.Please re-input: ");
                    continue;
                }
            }
        }
        return null;
    }

    

   

       
    public static boolean checkCustomerId(String customerId, List<Customer> c) {
        for (Customer customer : c) {
            if (customerId.equalsIgnoreCase(customer.getCustomerId())) {
                return true;
            }
        }
        return false;
    }

    
   


  public static int getInt(String msg, int optionMin, int optionMax) {
        String input;
        int result;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Input could't be empty!!!. Please enter again: ");
                continue;
            } else {
                try {
                    result = Integer.parseInt(input);
                    if (result >= optionMin && result <= optionMax) {
                        return result;
                    } else {
                        System.out.println("Please enter number in range [" + optionMin + "->" + optionMax + "]:");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Please enter integer number: ");
                }
            }
        }
    }
    

    
}