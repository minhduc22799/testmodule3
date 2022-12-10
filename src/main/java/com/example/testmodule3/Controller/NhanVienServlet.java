package com.example.testmodule3.Controller;

import com.example.testmodule3.Model.NhanVien;
import com.example.testmodule3.Model.PhongBan;
import com.example.testmodule3.Service.NhanVienService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = "/nhanVien")
public class NhanVienServlet extends HttpServlet {
    private NhanVienService nhanVienService;

    public void init() {
        nhanVienService = new NhanVienService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "edit":
                eidtForm(request, response);
                break;
            case "delete":
                deleteFrom(request, response);
                break;
            default:
                displayHome(request, response);
                break;
        }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                displayHome(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
        request.setAttribute("nhanviens", nhanVienService.findByNameContaining(request));
        requestDispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        nhanVienService.deleteById(request);
        response.sendRedirect("http://localhost:8080/nhanVien");
    }
    private void deleteFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
        request.setAttribute("nhanvien",nhanVienService.findById(request));
        dispatcher.forward(request, response);
    }
    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
            nhanVienService.add(request);
            response.sendRedirect("http://localhost:8080/nhanVien");
    }
    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        nhanVienService.add(request);
        response.sendRedirect("http://localhost:8080/nhanVien");
    }

    private void displayHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
        List<NhanVien> nhanViens = nhanVienService.findAll(request);
        request.setAttribute("nhanviens",nhanViens);
        requestDispatcher.forward(request,response);

    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        List<PhongBan> phongBans = nhanVienService.findAllPhongBan(request);
        request.setAttribute("phongbans",phongBans);
        dispatcher.forward(request, response);

    }

    private void eidtForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("nhanvien",nhanVienService.findById(request));
        request.setAttribute("phongbans",nhanVienService.findAllPhongBan(request));
        dispatcher.forward(request, response);

    }



}
