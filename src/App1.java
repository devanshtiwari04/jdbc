//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import Dao.StudentDaoImplement;
import model.Student;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        int id;
        String name;
        int age;
        System.out.println("Main Execution");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the option:");
        int n=sc.nextInt();

        switch(n){
            case 1:
                App1.createstudent(sc);
                break;
            case 2:
                App1.updateStudent(sc);
                break;
            case 3:
                App1.getbyId(sc);
                break;
            case 4:
                App1.delete(sc);
                break;
            case 5:
                App1.getallStudent(sc);
                break;
        }




    }


    private static void getallStudent(Scanner sc) {


        StudentDaoImplement studentDaoImplement = new StudentDaoImplement();
        List<Student> studentList=studentDaoImplement.getAllStudent();

        if(studentList==null){
            System.out.println("No Record Found");
        }
        else{
            System.out.println("Student Information");
            for(Student std:studentList){
                System.out.println(std.toString());
            }
        }


    }

    private static void delete(Scanner sc) {
        System.out.println("Enter the id");
        int  id = sc.nextInt();

        StudentDaoImplement studentDaoImplement = new StudentDaoImplement();

        if(studentDaoImplement.deleteStudent(id)){
            System.out.println("Student deleted successfully");
        }else{
            System.out.println("oops! something went wrong..");
        }



    }





    private static void getbyId(Scanner sc) {
        System.out.println("Enter the id");
        int  id = sc.nextInt();
        StudentDaoImplement studentDaoImplement = new StudentDaoImplement();


        Student res=studentDaoImplement.getStudentById(id);

            System.out.println(res);


    }



    public static void updateStudent(Scanner sc){
        System.out.println("Enter the id");
        int  id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the name");
        String name = sc.nextLine().trim();
        sc.nextLine();


        System.out.println("Enter the age");
        int age = sc.nextInt();




        StudentDaoImplement studentDaoImplement = new StudentDaoImplement();

        if(studentDaoImplement.updateStudent(id,name,age)){
            System.out.println("Student updated successfully");
        }else{
            System.out.println("oops! something went wrong..");
        }
    }




    public static void createstudent(Scanner sc){
        System.out.println("Enter the name");
        String name = sc.nextLine();


        System.out.println("Enter the age");
        int age = sc.nextInt();

//        System.out.println("Enter the id");
//       int  id = sc.nextInt();


        StudentDaoImplement studentDaoImplement = new StudentDaoImplement();

        if(studentDaoImplement.createStudent(name,age)){
            System.out.println("Student created successfully");
        }else{
            System.out.println("oops! something went wrong..");
        }
    }
}