/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.FeastItem;

public class FeastMenuManager {

    private final String FILE_NAME = "feastMenu.csv";

    private final List<FeastItem> listI;

    public FeastMenuManager() {
        listI = new ArrayList<>();
        readToFile();
        String temp = listI.get(0).getItemId();
        listI.get(0).setItemId(temp.substring(1));
    }

    public List<FeastItem> getListI() {
        return listI;
    }
    
       
    public void readToFile() {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            // Mở file bằng FileInputStream
            fileInputStream = new FileInputStream(FILE_NAME);

            // Sử dụng InputStreamReader để hỗ trợ mã hóa UTF-8
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

            // Sử dụng BufferedReader để đọc từng dòng
            bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Bỏ qua dòng trống
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Tách dữ liệu dựa trên dấu phẩy
                String[] data = line.split(",");

                // Kiểm tra nếu không đủ dữ liệu
                if (data.length < 4) {
                    System.err.println("Dòng không hợp lệ: " + line);
                    continue;
                }

                // Xử lý dữ liệu
                try {
                    String itemId = data[0].trim();
                    String itemName = data[1].trim();
                    double price = Double.parseDouble(data[2].trim());
                    String ingreditents = data[3].trim();
                    // Thêm vào danh sách
                    listI.add(new FeastItem(itemId, itemName, price, ingreditents));
                } catch (NumberFormatException e) {
                    System.err.println("Không thể chuyển đổi Price thành số nguyên: " + data[2]);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void displayFeastItem() {
       
        Collections.sort(listI);
       
        System.out.println("List of Set Menus for ordering party:");
        for (FeastItem feastItem : listI) {
            System.out.println(feastItem);
        }
    }

    public boolean isValidMenuCode(String menuCode) {
        for (FeastItem object : listI) {
            if (menuCode.equals(object.getItemId())) {
                return true;
            }
        }
        return false;
    }

    public FeastItem getFeastItemByCode(String menuCode) {
        for (FeastItem object : listI) {
            if (menuCode.equals(object.getItemId())) {
                return object;
            }
        }
        return null;
    }
  
  

}
