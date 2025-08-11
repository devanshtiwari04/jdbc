package Dao;

import Helper.DBConnect;
import Helper.QueryBuilder;
import model.Student;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudentDaoImplement implements StudentDao {


    @Override
    public boolean createStudent(String name, int age) {

        HashMap<String, String> std = new HashMap<>();
        std.put("name", name);
        std.put("age", String.valueOf(age));

        QueryBuilder queryBuilder = new QueryBuilder();
        String sql = queryBuilder.setTable("student").insert(std).getQuery();

        int effectedRows = 0;

        try {
            PreparedStatement ps = DBConnect.getDBConnection().prepareStatement(sql);
            effectedRows = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Query error");
        }

        if(effectedRows > 0){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public Student getStudentById(int id) {
        QueryBuilder queryBuilder = new QueryBuilder();
        String sql = queryBuilder.setTable("student").select().where("id","=","2").getQuery();

        String name="";
        int age=0;

        try {
            PreparedStatement ps = DBConnect.getDBConnection().prepareStatement(sql);
            ResultSet rs  = ps.executeQuery();

            if(rs.next()) {
                name= rs.getString("name");
                age=rs.getInt("age");
            }

        } catch (SQLException e) {
            System.out.println("Query error");
        }



        return new Student(name,id,age);
    }




    @Override
    public boolean updateStudent(int id, String name, int age) {
        HashMap<String,String> std1=new HashMap<>();

        std1.put("name",name);
        std1.put("age",String.valueOf(age));

        QueryBuilder queryBuilder = new QueryBuilder();
        String sql = queryBuilder.setTable("student").update(std1).where("id","=",String.valueOf(id)).getQuery();

        int affectedRows = 0;

        try {
            PreparedStatement ps = DBConnect.getDBConnection().prepareStatement(sql);
            affectedRows = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Query error"+e.getMessage());
        }

        if(affectedRows > 0){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public boolean deleteStudent(int id) {
        QueryBuilder queryBuilder = new QueryBuilder();
        String sql = queryBuilder.setTable("student").delete().where("id","=",String.valueOf(id)).getQuery();

        int affectedRows = 0;

        try {
            PreparedStatement ps = DBConnect.getDBConnection().prepareStatement(sql);
            affectedRows = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Query error"+e.getMessage());
        }

        if(affectedRows > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Student> getAllStudent() {
       List<Student> studentList =new ArrayList<>();
       QueryBuilder queryBuilder=new QueryBuilder();
       String sql=queryBuilder.setTable("student").select("*").getQuery();

        try {
            PreparedStatement ps = DBConnect.getDBConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                studentList.add(new Student(
                        rs.getString("name")
                        , rs.getInt("id")
                        , rs.getInt("age")));
            }


        }  catch (SQLException e) {
            System.out.println("SQl error"+e.getMessage());
        }

         return studentList;
       }


    }


