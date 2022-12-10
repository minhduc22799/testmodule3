<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create</title>
</head>
<body>
<a href="/nhanVien?action="><button id="back">Back</button></a>
<div align="center">

  <form method="post" action="/nhanVien?action=create">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Add New Staff</h2>
      </caption>
      <tr>
        <th>Name:</th>
        <td>
          <input type="text" name="name" id="name" size="45" required/>
        </td>
      </tr>
      <tr>
        <th>Email:</th>
        <td>
          <input type="text" name="email" id="email" size="45" required/>
        </td>
      </tr>
      <tr>
        <th>Country:</th>
        <td>
          <input type="text" name="address" id="country" size="15" required/>
        </td>
      </tr>

      <tr>
        <th>Phone:</th>
        <td>
          <input type="text" name="phone"  size="15" required/>
        </td>
      </tr>

      <tr>
        <th>Salary:</th>
        <td>
          <input type="text" name="salary"  size="15" required/>
        </td>
      </tr>

      <tr>
        <th>Department:</th>
        <td>
          <select name="phongban">
            <c:forEach items="${phongbans}" var="p">
              <option value="${p.getId()}">

                <c:out value="${p.getName()}"/>

              </option>
            </c:forEach>
          </select>
        </td>
      </tr>

      <tr>
        <td colspan="2" align="center">
          <input id="save" type="submit" value="Add staff"/>
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
  h2{
    color: #286b26;
  }
  th{
    color: #672b39;
  }
  table{
    padding-bottom: 30px;
  }
  #save{
    margin-top: 30px;
    background-color: #286b26;
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
