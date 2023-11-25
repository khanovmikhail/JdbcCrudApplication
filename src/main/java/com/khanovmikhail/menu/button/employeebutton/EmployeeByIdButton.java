package com.khanovmikhail.menu.button.employeebutton;

import com.khanovmikhail.menu.MenuItem;
import com.khanovmikhail.repository.EmployeeDao;

import java.util.Scanner;

public class EmployeeByIdButton implements MenuItem {

    private final EmployeeDao employeeDao = new EmployeeDao();
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Employee id");
        int id = scanner.nextInt();

        System.out.println(employeeDao.findById(id));
    }

    @Override
    public String getTitle() {
        return "Find employee by id";
    }
}
