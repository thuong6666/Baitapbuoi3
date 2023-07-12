/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapbuoi3.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.baitapbuoi3.Model.User;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class LoginService {
    List<User> users = new ArrayList<>();

    public LoginService() {
        initUserDefault();
    }
    
    
    
    public boolean verifyLogin(String username, String password){
        for (User user : users) {
            if ((user.getUsername().equals(username))&&user.getPassword().equals(password)) {
                System.out.println( user.toString());
                return true;
                
            }
            
        }
        return false;
    }
    
    private void initUserDefault(){
        Gson gson = new Gson();
        try (Reader reader = new FileReader("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Baitapbuoi3\\src\\main\\java\\com\\mycompany\\baitapbuoi3\\Model\\users.json")) {
            users = gson.fromJson(reader, new TypeToken<List<User>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }

}
