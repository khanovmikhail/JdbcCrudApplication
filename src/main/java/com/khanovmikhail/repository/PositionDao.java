package com.khanovmikhail.repository;

import com.khanovmikhail.DatabaseConnector;
import com.khanovmikhail.entity.Employee;
import com.khanovmikhail.entity.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDao implements CrudDao<Position> {

    private final Connection connection = DatabaseConnector.getConnection();
    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();

        try{
            PreparedStatement ps = connection.prepareStatement("select * from positions");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Position position = new Position();
                position.setId(rs.getInt(1));
                position.setName(rs.getString(2));

                positions.add(position);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public Position findById(int id) {
        Position position = new Position();
        try{
            PreparedStatement ps = connection.prepareStatement("select * from positions where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                position.setId(rs.getInt(1));
                position.setName(rs.getString(2));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return position;
    }

    @Override
    public Position save(Position entity) {
        return null;
    }

    @Override
    public void update(Position entity) {

    }

    @Override
    public void delete(Position entity) {

    }
}
