package com.dyangalih.employee;

import com.dyangalih.lib.Database;
import com.dyangalih.lib.Tools;
import com.github.javafaker.Faker;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    private Database db;
    private Faker faker;
    private String sql;
    private ResultSet rs;
    private int totalData;

    public Employee() {
        db = new Database();
        faker = new Faker();
    }

    public void addEmployee() {
        int count = faker.number().numberBetween(10,20);
        sql = Tools.getInstance().loadSql(getClass(), "employee_add.sql");
        for (int i = 0; i < count; i++) {
            db.execute(sql, new Object[]{i+1, faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(10,50)});
        }
    }

    public void deleteAllEmployee() {
        db.execute(Tools.getInstance().loadSql(getClass(), "employee_delete.sql"), new Object[]{});
    }

    private ResultSet getEmployeeById(int id) {
        return db.open(Tools.getInstance().loadSql(getClass(),"employee_by_id.sql"), new Object[]{id});
    }

    public void updateEmployee(){
        int id = faker.number().numberBetween(1, totalData);
        rs = getEmployeeById(id);
        try {
            System.out.println("Employee before change the data");
            while (rs.next()){
                System.out.println("First name : " + rs.getString("first")
                        + " | Last name : " + rs.getString("last")
                        + " | Age :" + rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        db.execute(Tools.getInstance().loadSql(getClass(), "employee_update.sql"),
                new Object[]{faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(10,50), id});

        rs = getEmployeeById(id);
        try {
            while (rs.next()){
                System.out.println("Employee after change the data");
                System.out.println("First name : " + rs.getString("first")
                        + " | Last name : " + rs.getString("last")
                        + " | Age :" + rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAllEmployee() {
        rs = db.open(Tools.getInstance().loadSql(getClass(), "employee_list.sql"), new Object[]{});

        try {
            totalData = 0;
            while (rs.next()){
                System.out.println("Employee data");
                System.out.println("First name : " + rs.getString("first")
                        + " | Last name : " + rs.getString("last")
                        + " | Age :" + rs.getInt("age"));
                totalData++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
