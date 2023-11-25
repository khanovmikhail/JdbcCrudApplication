package com.khanovmikhail.menu.button.employeebutton;

import com.khanovmikhail.entity.Employee;
import com.khanovmikhail.entity.Position;
import com.khanovmikhail.menu.MenuItem;
import com.khanovmikhail.repository.EmployeeDao;

import java.util.Scanner;

public class SaveNewEmployeeButton implements MenuItem {
    private EmployeeDao employeeDao = new EmployeeDao();

    @Override
    public void run() {
        Employee e = inputNewEmployee();
        e = employeeDao.save(e);
        System.out.println(e);
    }

    @Override
    public String getTitle() {
        return "Create new Employee";
    }

    private Employee inputNewEmployee(){
        Scanner scanner = new Scanner(System.in);
        Employee e = new Employee();
        System.out.println("Input employee first name ");
        e.setFirstName(scanner.nextLine());
        System.out.println("Input employee last name ");
        e.setLastName(scanner.nextLine());
        System.out.println("Input employee age ");
        e.setAge(scanner.nextInt());
        System.out.println("Input employee position id ");
        Position p = new Position();
        p.setId(scanner.nextInt());
        e.setPosition(p);

        return e;
    }
}
