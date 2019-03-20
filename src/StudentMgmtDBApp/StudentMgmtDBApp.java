package StudentMgmtDBApp;

import java.util.Scanner;

/**
 * # -*- coding: utf-8 -*-
 * Created On:             19 Mar 2019 at 5:55 PM
 * Author:                 Arvind Sachidev Chilkoor
 * Created Using:          IntelliJ IDEA
 * Name of Project:        StudentManagementSystem
 * Package Name:           StudentMgmtDBApp
 * <p>
 * <p>
 * Description:
 * A application that manages the student enrollment and tuition fee balance in database.
 *
 * Todo the following:
 * 1. Ask the USER how many students will be added to the database.
 * 2. Ask the USER the name and year of each student.
 * 3. Each student will have a Student-ID with 5 - digit unique code, with the first number being the grade level.
 * 4. A Student can enroll in the following courses:
 *      1. History
 *      2. English
 *      3. Mathematics
 *      4. Physics
 *      5. Chemistry
 *      6. Biology
 *      7. Computer Science
 * 5. Each course costs around USD 500 to enroll.
 * 6. Student must be able to view the balance and pay the tuition fees.
 * 7. To view student profile and status, name, ID, courses enrolled and balance must be displayed.
 **/



public class StudentMgmtDBApp {

    public static void main(String[] args) {

        // Get User Input for number of students for enrollment:
        System.out.println("Enter the number of new students to enroll:  ");
        Scanner in = new Scanner(System.in);
        int numbOfStudents = in.nextInt();
        Student[] students = new Student[numbOfStudents]; // Creating the array based on number of students

        // Create enrollment for n number of new students
        // For loop for n students
        for (int n = 0; n < numbOfStudents; n++) {
            students[n] = new Student();
            students[n].courseEnroll();
            students[n].viewTuitionBalance();
            students[n].payTuition();

        }
        // Display Student Info Loop
        for (int n = 0; n < numbOfStudents; n++) {
            System.out.println(students[n].showStudentInfo());
        }
    }
}
