package com.example.testmodule3.Service;

import com.example.testmodule3.Model.NhanVien;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public interface INhanVienDAO<E,K> {
    List<E> findAll(HttpServletRequest request);

    E findById(HttpServletRequest request);

    boolean add(HttpServletRequest request);
    void upgrade(HttpServletRequest request);

    boolean deleteById(HttpServletRequest request);

}
