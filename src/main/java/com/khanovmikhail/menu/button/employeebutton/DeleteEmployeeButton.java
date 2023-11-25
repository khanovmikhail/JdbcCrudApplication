package com.khanovmikhail.menu.button.employeebutton;

import com.khanovmikhail.entity.Employee;
import com.khanovmikhail.menu.MenuItem;
import com.khanovmikhail.repository.EmployeeDao;

import java.util.Scanner;

public class DeleteEmployeeButton implements MenuItem {
    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Employee e = new Employee();
        e.setId(id);
        employeeDao.delete(e);
    }

    @Override
    public String getTitle() {
        return "Delete Employee By Id";
    }
}
