package com.khanovmikhail.menu.button.employeebutton;

import com.khanovmikhail.menu.MenuItem;
import com.khanovmikhail.repository.PositionDao;

public class AllPositionsButton implements MenuItem {

    private final PositionDao positionDao = new PositionDao();
    @Override
    public void run() {
        System.out.println("List of all positions");
        positionDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "Show all positions";
    }
}
