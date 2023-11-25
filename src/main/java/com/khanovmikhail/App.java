package com.khanovmikhail;

import com.khanovmikhail.menu.Menu;
import com.khanovmikhail.repository.EmployeeDao;
import com.khanovmikhail.entity.Employee;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * Jdbc Crud Application
 *
 */
public class App 
{
    public static void main( String[] args ) {
        new Menu().startMenu();
    }
}
