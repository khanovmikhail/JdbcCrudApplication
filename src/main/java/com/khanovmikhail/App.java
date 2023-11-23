package com.khanovmikhail;

import com.khanovmikhail.dao.EmployeeDao;
import com.khanovmikhail.entity.Employee;

import java.sql.Connection;
import java.util.List;

/**
 * Jdbc Crud Application
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Connection connection = DatabaseConnector.getConnection();
        System.out.println("Connection is succeeded");

        System.out.println("List of all employees");
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employeeList = employeeDao.findAll();

        employeeList.forEach(System.out::println);
        System.out.println("---------------------");

//        Employee e = new Employee();
//        e.setFirstName("Nikita");
//        e.setLastName("Kucherov");
//        e.setAge(35);
//        e = employeeDao.save(e);
//
//        System.out.println("---------------------");
//        employeeList = employeeDao.findAll();
//        employeeList.forEach(System.out::println);
//
//        e.setAge(36);
//        employeeDao.update(e);

        Employee e = new Employee();
        e.setId(6);
        employeeDao.delete(e);
        e.setId(11);
        employeeDao.delete(e);

        employeeList = employeeDao.findAll();
        employeeList.forEach(System.out::println);
    }
}
