package com.khanovmikhail.menu.button.employeebutton;

import com.khanovmikhail.entity.Employee;
import com.khanovmikhail.entity.Position;
import com.khanovmikhail.menu.MenuItem;
import com.khanovmikhail.repository.EmployeeDao;

import java.util.Scanner;

public class UpdateEmployeeButton implements MenuItem {

    private final EmployeeDao employeeDao = new EmployeeDao();
    @Override
    public void run() {
        Employee e = updateEmployee();
        employeeDao.update(e);
    }

    @Override
    public String getTitle() {
        return "Update Employee";
    }

    private Employee updateEmployee(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Employee id which your want to update");
        int id = scanner.nextInt();

        Employee e = employeeDao.findById(id);
        System.out.println(e);

        System.out.println("Edit Employee :");

        System.out.println("Input employee first name (input \"old\" for the old value)");
        String s = scanner.next();
        if(!s.equals("old")){
            e.setFirstName(s);
        }

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ex) {
//            throw new RuntimeException(ex);
//        }

        System.out.println("Input employee last name (input \"old\" for the old value)");
        String lastName = scanner.next();
        if(!s.equals("old")){
            e.setLastName(lastName);
        }

        System.out.println("Input employee age (input \"-1\" for the old value)");
        int age = scanner.nextInt();
        if(age != -1){
            e.setAge(age);
        }

        System.out.println("Edit employee position id (input \"-1\" for the old value)");
        Position p = new Position();
        int pId = scanner.nextInt();

        if(pId != -1){
            p.setId(pId);
            e.setPosition(p);
        }
        return e;
    }
}
