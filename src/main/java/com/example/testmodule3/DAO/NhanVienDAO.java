package com.example.testmodule3.DAO;

import com.example.testmodule3.Connection.MyConnection;
import com.example.testmodule3.Model.NhanVien;
import com.example.testmodule3.Model.PhongBan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    private Connection connection;
    private PhongBanDAO phongBanDAO;

    private static final String INSERT_NHANVIEN_SQL = "INSERT INTO nhanvien (name, email,address,phone,salary,id_phongban) VALUES (?, ?, ? ,?, ?, ?);";
    private static final String SELECT_NHANVIEN_BY_ID ="select * from nhanvien where id =?";
    private static final String SELECT_ALL_NHANVIEN = "select * from nhanvien";
    private static final String DELETE_NHANVIEN_SQL = "delete from nhanvien where id = ?;";
    private static final String UPDATE_NHANVIEN_SQL = "update nhanvien set name = ?,email= ?,address= ?, phone =?, salary =?,id_phongban=? where id = ?;";
    private static final String SELECT_NHANVIEN_BY_NAME = "select * from nhanvien where name like ?;";

    public NhanVienDAO() {
        connection = MyConnection.getConnection();
        phongBanDAO = new PhongBanDAO();
    }

    public List<NhanVien> findAll() {
        List<NhanVien> nhanViens = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_ALL_NHANVIEN)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                Double salary = resultSet.getDouble("salary");
                int phongBanId = resultSet.getInt("id_phongban");
                PhongBan phongBan = phongBanDAO.findPhongBanById(phongBanId);
                nhanViens.add(new NhanVien(id,name,email,address,phone,salary,phongBan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanViens;
    }

    public boolean createNhanVien(NhanVien nhanVien) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_NHANVIEN_SQL)) {
            preparedStatement.setString(1, nhanVien.getName());
            preparedStatement.setString(2, nhanVien.getEmail());
            preparedStatement.setString(3, nhanVien.getAddress());
            preparedStatement.setString(4,nhanVien.getPhone());
            preparedStatement.setDouble(5,nhanVien.getSalary());
            preparedStatement.setInt(6, nhanVien.getPhongBan().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public NhanVien findNhanVienById(int id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_NHANVIEN_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                Double salary = resultSet.getDouble("salary");
                int phongBanId = resultSet.getInt("id_phongban");
                PhongBan phongBan = phongBanDAO.findPhongBanById(phongBanId);
                return  new NhanVien(id,name,email,address,phone,salary,phongBan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteNhanVien(int id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_NHANVIEN_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNhanVien(NhanVien nhanVien) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(UPDATE_NHANVIEN_SQL)) {
            preparedStatement.setString(1, nhanVien.getName());
            preparedStatement.setString(2, nhanVien.getEmail());
            preparedStatement.setString(3, nhanVien.getAddress());
            preparedStatement.setString(4, nhanVien.getPhone());
            preparedStatement.setDouble(5, nhanVien.getSalary());
            preparedStatement.setInt(6, nhanVien.getPhongBan().getId());
            preparedStatement.setInt(7, nhanVien.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<NhanVien> findAllByNameContaining(String nameSearch) {
        List<NhanVien> products = new ArrayList<>();
        try(PreparedStatement preparedStatement =
                    connection.prepareStatement(SELECT_NHANVIEN_BY_NAME)) {
            preparedStatement.setString(1, "%" + nameSearch + "%");
            getListProduct(products, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private void getListProduct(List<NhanVien> nhanVienList, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            Double salary = resultSet.getDouble("salary");
            int phongBanId = resultSet.getInt("id_phongban");
            PhongBan phongBan = phongBanDAO.findPhongBanById(phongBanId);
            nhanVienList.add(new NhanVien(id, name, email, address, phone, salary, phongBan));
        }
    }

}
