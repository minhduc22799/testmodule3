
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>


<div align="center">
<div id="header">
    <h2>
        <a href="/nhanVien?action=create"><button class="add">Add</button></a>
    </h2>
    <form method="post" action="/nhanVien?action=search">
        <input style="outline: none" name="search" placeholder="Search..." >
        <button id="search" type="submit">Search</button>
    </form>
</div>

    <table border="1" cellpadding="5">
        <caption><h2>List Staff</h2></caption>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Salary</th>
            <th>Department</th>
            <th>Action</th>

        </tr>
        <c:forEach items="${nhanviens}" var="nhanvien" >
            <tr>
                <td><c:out value="${nhanvien.getName()}"/></td>
                <td><c:out value="${nhanvien.getEmail()}"/></td>
                <td><c:out value="${nhanvien.getAddress()}"/></td>
                <td><c:out value="${nhanvien.getPhone()}"/></td>
                <td><c:out value="${nhanvien.getSalary()}"/></td>
                <td><c:out value="${nhanvien.getPhongBan().getName()}"/></td>
                <td>
                    <a href="/nhanVien?action=edit&id=${nhanvien.getId()}"><button class="edit">Edit</button></a>
                    <a href="/nhanVien?action=delete&id=${nhanvien.getId()}"><button class="delete">Delete</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<style>
   table,td,th{
        border: none;
    }
    th,tr,td{
        text-align: center;
        padding: 10px 30px 10px 20px;
    }
    th{
        color: #2e2ef6;
    }
    .add{
        background-color: #20d920;
        padding: 10px;
        margin-top: 30px;
        margin-left: 130px;
        border: none;
        border-radius: 10px;
        color: white;
    }
    .edit{
        background-color: #d9c00d;
        padding: 10px;
        border: none;
        border-radius: 10px;
        color: white;
    }
    .delete{
        color: white;
        background-color: #e72651;
        padding: 10px;
        border: none;
        border-radius: 10px;
    }
    th{
        color: white;
        background-color: #a6a6e7;
    }

#header{
    display: grid;
    grid-template-columns: 40% 60%;
}
form{
    margin-top: 50px;
    margin-left: -50px;
}
form input{
    padding: 5px;
}
#search{
    color: white;
    background-color: #3064e8;
    border: none;
    padding: 7.5px;
}
td,tr{
    background-color: #f6f6f6;
}
</style>
</html>
