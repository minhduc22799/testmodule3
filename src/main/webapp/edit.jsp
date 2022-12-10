<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit</title>
</head>
<body>

<a style="text-align: center" href="/nhanVien?action="><button id="back">Back</button></a>
<center>
  <h1>Edit</h1>
</center>
<div align="center">
  <form method="post" action="/nhanVien?action=edit">
    <table border="1" cellpadding="5">
      <caption>
      </caption>
      <tr>
        <th>Name:</th>
        <input hidden type="text" name="id" id="id" size="45" value="${nhanvien.getId()}" required/>
        <td>
          <input type="text" name="name" id="name" size="45" value="${nhanvien.getName()}" required/>
        </td>
      </tr>
      <tr>
        <th>Email:</th>
        <td>
          <input type="text" name="email" id="email" size="45" value="${nhanvien.getEmail()}" required/>
        </td>
      </tr>
      <tr>
        <th>Country:</th>
        <td>
          <input type="text" name="address" id="country" size="15" value="${nhanvien.getAddress()}" required/>
        </td>
      </tr>

      <tr>
        <th>Phone:</th>
        <td>
          <input type="text" name="phone"  size="15" value="${nhanvien.getPhone()}" required/>
        </td>
      </tr>

      <tr>
        <th>Salary:</th>
        <td>
          <input type="text" name="salary"  size="15" value="${nhanvien.getSalary()}" required/>
        </td>
      </tr>

      <tr>
        <th>Departments:</th>
        <td>
          <select name="phongban">
            <c:forEach items="${phongbans}" var="p">
              <option selected hidden value="${nhanvien.getPhongBan().getId()}"><c:out value="${nhanvien.getPhongBan().getName()}"/></option>
              <option value="${p.getId()}">
                <c:out value="${p.getName()}"/>
              </option>
            </c:forEach>
          </select>
        </td>
      </tr>

      <tr>
        <td colspan="2" align="center">
      <input id="save" type="submit" value="Edit Staff"/>
        </td>
      </tr>
    </table>
  </form>

</div>
</body>
<style>
  table,th,tr,td{
    border: none;
  }
  input,select{
    margin-left: 20px;
    outline: none;
    padding: 5px;
    border-radius: 5px;
  }
  h1{
    color: #5252ce;
  }
  th{
    color: #948542;
  }
 table{
    padding-bottom: 30px;
  }
 #save{
   margin-top: 30px;
   background-color: #5252ce;
   border: none;
   border-radius: 10px;
   padding: 12px 30px 12px 30px ;
   color: white;
 }
 #back{
   background-color: #6e0505;
   margin-left: 100px;
   padding: 10px;
   border-radius: 10px;
   color: white;
   border: none;
 }
</style>
</html>
