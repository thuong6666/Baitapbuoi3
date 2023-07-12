/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapbuoi3.Service;

import com.mycompany.baitapbuoi3.Model.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author LENOVO
 */
public class StudentList {
    public ArrayList<Student>  students ;
    File StudentFile;
    
    public StudentList() {
        this.createFiles();
        this.students = readDataFromFile(); 
        this.saveData();
        
    }

    public void print(){
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    
   
    private ArrayList<Student> readDataFromFile() {
        ArrayList<Student> arr = new ArrayList<>();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(StudentFile);
        } catch (FileNotFoundException ex) {  
        }
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] s = line.split(", ");
            int id = Integer.parseInt(s[0]);
            Student student = new Student(id, s[1], s[2], s[3], s[4], s[5], s[6], stringToLocalDateTime(s[7]));
         
            arr.add(student);
        }
        try {
            scanner.close();
            fileInputStream.close();
        } catch (Exception ex) {
        }
        return arr;
    }

    private LocalDateTime stringToLocalDateTime(String datetime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime date = LocalDateTime.parse(datetime, formatter);
        return date;
    }
    
        public void saveData() {
        try {
            PrintWriter printWriter = new PrintWriter(StudentFile, "UTF-8");
            for (Student student : students) {
                printWriter.println(student);
            }
            printWriter.flush();
            printWriter.close();
	} catch (Exception e) {
            System.out.println("Error write file!!!");
	}
    }

    private void createFiles() {
        StudentFile = new File("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Baitapbuoi3\\studentData.txt");
        try {
            StudentFile.createNewFile();
        } catch (Exception e) {
        }
    }

    public ArrayList<Student> seachName(String name){
        ArrayList<Student> arr = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toUpperCase().contains(name.toUpperCase())) {
                arr.add(student);
            }
        }
        return arr;
    }
  
    
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
//        studentService.readDataFromFile();
        ArrayList<Student> students = studentList.getStudents();
        System.out.println(students.size());
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println(studentList.toString());
        
    }
}
