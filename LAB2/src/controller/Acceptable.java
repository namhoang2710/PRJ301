package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public interface Acceptable {

    // Regular expressions for validation
    String CUSTOMER_ID = "^(C|G|K)\\d{4}$";
    String CUSTOMER_NAME = "^[A-Za-z ]{2,25}$";
    String DOUBLE_VALID = "^-?\\d+(\\.\\d+)?$";
    String INTEGER_VALID = "^-?\\d+$";
    String PHONE_VALID_VIETNAM = "^(03[2-9]|05[2689]|07[06-9]|08[1-9]|09[0-9])\\d{7}$";
    String CUSTOMER_EMAIL = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,3}$";
    
    String SET_MENU_CODE_REGEX = "^PW\\d{3}$";

    // Validation method
 public   static boolean isValid(String data, String pattern) {
        return data.matches(pattern);
    }
}
