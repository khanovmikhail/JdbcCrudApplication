package com.khanovmikhail.menu.button.positionbutton;

import com.khanovmikhail.menu.MenuItem;
import com.khanovmikhail.repository.PositionDao;

import java.util.Scanner;

public class PositionByIdButton implements MenuItem {

    private final PositionDao positionDao = new PositionDao();
    @Override
    public void run() {
        System.out.println("Input Position Id ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println(positionDao.findById(id));
    }

    @Override
    public String getTitle() {
        return "Find position by Id";
    }
}
