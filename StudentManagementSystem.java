package com.task2;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); 
        } while (choice != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("--- Student Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); 
        
        Student newStudent = new Student(id, name, marks);
        studentList.add(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("--- Student List ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); 

        Student studentToUpdate = findStudentById(idToUpdate);
        if (studentToUpdate == null) {
            System.out.println("Student with ID " + idToUpdate + " not found.");
            return;
        }

        System.out.print("Enter new Name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            studentToUpdate.setName(newName);
        }

        System.out.print("Enter new Marks (enter -1 to keep current): ");
        double newMarks = scanner.nextDouble();
        scanner.nextLine(); 
        if (newMarks != -1) {
            studentToUpdate.setMarks(newMarks);
        }

        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine(); 
        
        Student studentToDelete = findStudentById(idToDelete);
        if (studentToDelete == null) {
            System.out.println("Student with ID " + idToDelete + " not found.");
            return;
        }

        studentList.remove(studentToDelete);
        System.out.println("Student deleted successfully!");
    }

    private static Student findStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}