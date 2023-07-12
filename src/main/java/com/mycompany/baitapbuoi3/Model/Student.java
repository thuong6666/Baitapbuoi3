/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapbuoi3.Model;

import java.time.LocalDateTime;
import java.util.Objects;
/**
 *
 * @author LENOVO
 */
public class Student {
    private int id;
    private String name;
    private String password;
    private String email, phone, address;
    private String Gender;
    private LocalDateTime created_at ;

    public Student() {
    }

    public Student(int id, String name, String password, String email, String phone, String address, String Gender) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.Gender = Gender;
        this.created_at = LocalDateTime.now();
    }

       public Student(int id, String name, String password, String email, String phone, String address, String Gender,LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.Gender = Gender;
        this.created_at = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }



    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return   id + ", "  + name + ", " + password + ", " + email + ", " + phone + ", " + address + ", " + Gender + ", " + created_at ;
    }

  
}
