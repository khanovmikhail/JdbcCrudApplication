package com.khanovmikhail.menu;

import com.khanovmikhail.menu.button.employeebutton.*;
import com.khanovmikhail.menu.button.positionbutton.PositionByIdButton;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {

    private static boolean exitButton = false;
    private static Map<Integer, MenuItem> menu = new TreeMap<>();

    static {
        menu.put(-1, () -> exitButton = true);
        menu.put(11, new AllEmployeeButton());
        menu.put(12, new EmployeeByIdButton());
        menu.put(13, new SaveNewEmployeeButton());
        menu.put(14, new UpdateEmployeeButton());
        menu.put(15, new DeleteEmployeeButton());
        menu.put(21, new AllPositionsButton());
        menu.put(22, new PositionByIdButton());
    }

    public void startMenu(){
        Scanner scanner = new Scanner(System.in);
        do {
            printMenuChoices();
            Integer choice = scanner.nextInt();
            if (menu.containsKey(choice)) {
                menu.get(choice).run();
            } else {
                System.out.println("Choose one command that represents in menu ");
            }

        } while(!exitButton);
    }

    private void printMenuChoices(){
        System.out.println("----------------");
        System.out.println("Select your choice : ");
        menu.forEach((k,v) -> System.out.println(k + " - " + v.getTitle()));
    }
}
