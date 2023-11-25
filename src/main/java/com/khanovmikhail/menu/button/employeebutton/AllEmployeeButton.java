package com.khanovmikhail.menu.button.employeebutton;

import com.khanovmikhail.menu.MenuItem;
import com.khanovmikhail.repository.EmployeeDao;

public class AllEmployeeButton implements MenuItem {

    private final EmployeeDao employeeDao = new EmployeeDao();
    @Override
    public void run() {
        System.out.println("List of All employees : ");
        employeeDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "Show all employees";
    }
}
