<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting</title>
</head>
<style>
    a{
        font-weight: bold;
        color: black;
    }
    #back{
        background-color: #6e0505;
        color: white;
        padding: 7px;
        border: none;
        border-radius: 5px;
    }
    h1{
        color: #e72651;
    }
    #delete{
        background-color: #289409;
        color: white;
        padding: 7px;
        border: none;
        border-radius: 5px;
    }
</style>
<body>
<h1>Delete</h1>
<p>
    <a href="/nhanVien"><button id="back">Back</button></a>
</p>
<form method="post" action="/nhanVien?action=delete">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Information</legend>
        <input hidden name="id" value="${nhanvien.getId()}">
        <table>
            <tr>
                <td style="font-weight: bold">Name:    </td>
                <td><c:out value="${nhanvien.getName()}"/></td>
            </tr>
            <tr>
                <td style="font-weight: bold">Department:    </td>
                <td><c:out value="${nhanvien.getPhongBan().getName()}"/></td>
            </tr>
            <tr>
                <td><input id="delete" type="submit" value="Delete"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>