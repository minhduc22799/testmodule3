package com.example.testmodule3.Service;

import com.example.testmodule3.DAO.NhanVienDAO;
import com.example.testmodule3.DAO.PhongBanDAO;
import com.example.testmodule3.Model.NhanVien;
import com.example.testmodule3.Model.PhongBan;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class NhanVienService implements INhanVienDAO{
   private NhanVienDAO nhanVienDAO;
   private PhongBanDAO phongBanDAO;

    public NhanVienService() {
        nhanVienDAO = new NhanVienDAO();
        phongBanDAO = new PhongBanDAO();
    }

    @Override
    public List findAll(HttpServletRequest request) {
        return nhanVienDAO.findAll();
    }
    public List<PhongBan> findAllPhongBan(HttpServletRequest request) {
        return phongBanDAO.findAll();
    }

    @Override
    public NhanVien findById(HttpServletRequest request) {
        int id = Integer.parseInt((request.getParameter("id")));
        return nhanVienDAO.findNhanVienById(id);
    }

    @Override
    public boolean add(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name =request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        int phongbanId  = Integer.parseInt(request.getParameter("phongban"));
        if (id ==null){
            return nhanVienDAO.createNhanVien(new NhanVien(name,email,address,phone,salary,phongBanDAO.findPhongBanById(phongbanId)));
        }else {
            return nhanVienDAO.updateNhanVien(new NhanVien(Integer.parseInt(id),name,email,address,phone,salary,phongBanDAO.findPhongBanById(phongbanId)));
        }
    }

    @Override
    public void upgrade(HttpServletRequest request) {

    }

    @Override
    public boolean deleteById(HttpServletRequest request) {
        int id = Integer.parseInt((request.getParameter("id")));
        return nhanVienDAO.deleteNhanVien(id);
    }
    public List<NhanVien> findByNameContaining(HttpServletRequest request) {
        String name = request.getParameter("search");
        return nhanVienDAO.findAllByNameContaining(name);
    }
}
