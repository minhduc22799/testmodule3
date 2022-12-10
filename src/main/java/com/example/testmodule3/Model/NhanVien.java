package com.example.testmodule3.Model;

public class NhanVien {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private Double Salary;
    PhongBan phongBan;

    public NhanVien() {
    }

    public NhanVien(int id, String name, String email, String address, String phone, Double salary, PhongBan phongBan) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        Salary = salary;
        this.phongBan = phongBan;
    }

    public NhanVien(String name, String email, String address, String phone, Double salary, PhongBan phongBan) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        Salary = salary;
        this.phongBan = phongBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }
}
