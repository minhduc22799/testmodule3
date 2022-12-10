package com.example.testmodule3.DAO;

import com.example.testmodule3.Connection.MyConnection;
import com.example.testmodule3.Model.PhongBan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongBanDAO {
    private  Connection connection;
    private final String SELECT_ALL_PHONGBAN = "select * from phongban;";
    private final String SELECT_PHONGBAN_BY_ID = "select * from phongban where id = ?;";


    public PhongBanDAO() {
        connection = MyConnection.getConnection();
    }

    public List<PhongBan> findAll() {
        List<PhongBan> phongBans = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_ALL_PHONGBAN)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                phongBans.add(new PhongBan(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongBans;
    }

    public PhongBan findPhongBanById(int id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_PHONGBAN_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPB = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new PhongBan(idPB, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
