package com.khanovmikhail.menu;

public interface MenuItem {

    void run();
    default String getTitle(){
        return "Exit button";
    }
}
