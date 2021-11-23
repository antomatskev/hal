<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HAL project</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: lightseagreen">
        <div class="navbar-header">
            <a href="/hal" class="navbar-brand">
                <img width="20%"
                     src="https://www.haigekassa.ee/sites/default/files/symboolika/hk_eng_cmyk.jpg"></a>
        </div>

        <ul class="nav navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Persons</a></li>
            <li><a href="<%=request.getContextPath()%>/listSL"
                   class="nav-link">Sick leaves</a></li>
            <li><a href="<%=request.getContextPath()%>/listPayments"
                   class="nav-link">Payments</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Persons</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Person</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Personal Code</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Address</th>
                <th>Email</th>
                <th>Bank Account</th>
                <th>Insurance</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="person" items="${personList}">
                <tr>
                    <td><c:out value="${person.id}"/></td>
                    <td><c:out value="${person.personalCode}"/></td>
                    <td><c:out value="${person.firstName}"/></td>
                    <td><c:out value="${person.lastName}"/></td>
                    <td><c:out value="${person.address}"/></td>
                    <td><c:out value="${person.email}"/></td>
                    <td><c:out value="${person.bankAccount}"/></td>
                    <td><c:out value="${person.insurance}"/></td>
                    <td><a href="edit?id=<c:out value='${person.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="delete?id=<c:out value='${person.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
</body>
</html>