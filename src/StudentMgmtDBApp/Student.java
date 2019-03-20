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
 * Class Descriptions.
 **/


public class Student {

    // Declaring the variables.

    private String firstname;
    private String lastname;
    public int year;
    private String studentID;
    private String courses = " ";
    private int tuitionBalance = 0;
    private static int costOfCourse = 500; // static since the costOfCourse is common to all objects in class of Student
    private static int ID = 1000;
    public int showyear; // variable for showStudentInfo()
    public int amountpaid; // variable for showStudentInfo()

    // Constructor: to prompt USER to enter the Student's name and year.

    public Student() {
        // Get the Student Name; firstname and lastname.
        Scanner inputData = new Scanner(System.in);
        System.out.print("\nEnter the student's first name:\t");
        this.firstname = inputData.nextLine();

        System.out.print("Enter the student's last name:\t");
        this.lastname = inputData.nextLine();

        // Here the program displays the academic year from 1 to 4, under while condition, only if True...
        while (true) {
            System.out.print("\n[1] - for Freshman Year" +
                    "\n[2] - for Sophomore Year" +
                    "\n[3] - for Junior Year" +
                    "\n[4] - for Senior Year");
            System.out.print("\nEnter the student's academic year:\t");
            Scanner yearData = new Scanner(System.in);
            int i = yearData.nextInt(); // Takes the USER input for checking if valid Integer.
            if (i <= 0 || i > 4) {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Sorry, That's an Invalid entry. Enter a number between 1 & 4 only");
                System.out.println("-----------------------------------------------------------------");
            } else {
                this.year = i;
                setStudentID(); // calling the setStudentID function
                showyear = i; // Transferring the value of i for showStudentInfo(), academic year.
                break;
            }
        }


    }

    // Generate the Student-ID, which is academic year + unique student ID
    private void setStudentID() {
        ID++; // Increment the ID every time a new student enrolls.
        this.studentID = (year + "" + ID);
    }

    // Enroll in courses
    /*  1. History
     *      2. English
     *      3. Mathematics
     *      4. Physics
     *      5. Chemistry
     *      6. Biology
     *      7. Computer Science
     *      8. Arts
     *      */

    public void courseEnroll() {

        do {
            System.out.print("\nCOURSE LIST:" +
                    "\n - History" +
                    "\n - English" +
                    "\n - Mathematics" +
                    "\n - Physics" +
                    "\n - Chemistry" +
                    "\n - Biology" +
                    "\n - Computer Science" +
                    "\n - Arts" +
                    "\n----------------------------" +
                    "\n[Q or q] - TO EXIT/QUIT" +
                    "\n----------------------------" +
                    "\nType the course for enrollment (Eg. Type 'History' or 'history'):\t");
            Scanner inputDat = new Scanner(System.in);
            String individualcourse = inputDat.nextLine();
            // Condition Check for Quit and input validation.
            if (!individualcourse.equals("Q") && !individualcourse.equals("q")) {
                if ((individualcourse.equals("History") || individualcourse.equals("history")
                        || (individualcourse.equals("English") || individualcourse.equals("english"))
                        || (individualcourse.equals("Mathematics") || individualcourse.equals("mathematics"))
                        || (individualcourse.equals("Physics") || individualcourse.equals("physics"))
                        || (individualcourse.equals("Chemistry") || individualcourse.equals("chemistry"))
                        || (individualcourse.equals("Biology") || individualcourse.equals("biology"))
                        || (individualcourse.equals("Computer Science") || individualcourse.equals("computer science"))
                        || (individualcourse.equals("Arts") || individualcourse.equals("arts")))) {
                    courses = courses + "\n --> " + individualcourse;
                    tuitionBalance = tuitionBalance + costOfCourse;
                    System.out.println("++++++++++++++++++++++++++++++++");
                    System.out.println("+ ENROLLED, STUDENT REGISTERED +");
                    System.out.println("++++++++++++++++++++++++++++++++");
                } else {
                    System.out.println("Please enter a valid course, that was not a valid entry");
                }

            } else {
                System.out.println("Thank you.");
                break;
            }
        } while (1 != 0); // Setting for infinite loop until USER Quits

        System.out.println("----------------------------------------------------------");
        System.out.println("Student has enrolled in the following courses : " + courses);
        System.out.println("----------------------------------------------------------");
        System.out.println("Student's Tuition Balance is : $" + tuitionBalance);
    }

    // View Tuition Fee Balance
    public void viewTuitionBalance() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("The tuition balance of student " + firstname + " " + lastname + " is $" + tuitionBalance);
        System.out.println("----------------------------------------------------------------------------------");
    }

    // Pay tuition fees
    public void payTuition() {

        // User input for the amount to be paid for tuition.
        System.out.print("Enter the amount the student wishes to pay towards tuition: $");
        Scanner inpay = new Scanner(System.in);
        int payment = inpay.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("********************************************");
        System.out.println("Thank you for your payment of $" + payment);
        System.out.println("********************************************");
        amountpaid = payment; // for showStudentInfo()
        viewTuitionBalance();

    }


    //Display all information about student and courses enrolled in
    public String showStudentInfo() {
        System.out.println("\n\n----------************-------------");
        System.out.println("\nName: " + firstname + " " + lastname);
        if (showyear == 1) {
            System.out.println("\nAcademic Year: Freshman Year");
        } else if (showyear == 2) {
            System.out.println("\nAcademic Year: Sophomore Year");
        } else if (showyear == 3) {
            System.out.println("\nAcademic Year: Junior Year");
        } else if (showyear == 4) {
            System.out.println("\nAcademic Year: Senior Year");
        }

        System.out.println("\nStudent ID: "+studentID);
        System.out.println("\nCourses Enrolled in: "+courses);
        System.out.println("\nTuition Fee Amount Paid: $"+amountpaid);
        System.out.println("\nTuition Fee Balance: $"+tuitionBalance);

        return"\nThank you, enrollment completed";

}


    }


