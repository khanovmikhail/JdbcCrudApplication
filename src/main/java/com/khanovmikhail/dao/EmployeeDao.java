package com.khanovmikhail.dao;

import com.khanovmikhail.DatabaseConnector;
import com.khanovmikhail.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements CrudDao<Employee> {

    private final Connection connection = DatabaseConnector.getConnection();

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        try{
            PreparedStatement ps = connection.prepareStatement("select * from employees");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setFirstName(rs.getString(2));
                e.setLastName(rs.getString(3));
                e.setAge(rs.getInt(4));

                employees.add(e);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = new Employee();
        try{
            PreparedStatement ps = connection.prepareStatement("select * from employees where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                employee.setId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setAge(rs.getInt(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee save(Employee entity) {

        try{
            PreparedStatement ps = connection.prepareStatement(
                    "insert into employees (first_name, last_name, age) values (?,?,?)");
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3,entity.getAge());

            ps.executeUpdate();

            PreparedStatement pst = connection.prepareStatement(
                    "select id from employees where first_name = ? AND last_name = ? AND age = ?");
            pst.setString(1, entity.getFirstName() );
            pst.setString(2, entity.getLastName());
            pst.setInt(3, entity.getAge());
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                entity.setId(rs.getInt(1));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void update(Employee entity) {
        try{
            PreparedStatement ps = connection.prepareStatement(
                    "update employees set first_name = ?, last_name = ?, age = ? where id = ?");
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3,entity.getAge());
            ps.setInt(4, entity.getId());

            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee entity) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from employees where id = ?");
            ps.setInt(1, entity.getId());
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }














}
