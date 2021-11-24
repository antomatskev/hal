<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HAL project PERSON</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: lightseagreen">
        <div class="navbar-brand">
            <a href="/hal" class="navbar-brand">
                <img width="20%"
                     src="https://www.haigekassa.ee/sites/default/files/symboolika/hk_eng_cmyk.jpg">
            </a>
        </div>

        <ul class="navbar-nav">
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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${person != null}">
            <form action="updatePerson" method="post">
                </c:if>
                <c:if test="${person == null}">
                <form action="insertPerson" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${person != null}">
                                Edit Person
                            </c:if>
                            <c:if test="${person == null}">
                                Add New Person
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${person != null}">
                        <input type="hidden" name="id" value="<c:out value='${person.id}' />"/>
                    </c:if>


                    <fieldset class="form-group">
                        <label>Personal code</label> <input type="text"
                                                            value="<c:out value='${person.personalCode}' />"
                                                            class="form-control"
                                                            name="personalCode" required="required">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>First Name</label> <input type="text"
                                                         value="<c:out value='${person.firstName}' />"
                                                         class="form-control"
                                                         name="firstName" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Last Name</label> <input type="text"
                                                        value="<c:out value='${person.lastName}' />"
                                                        class="form-control"
                                                        name="lastName" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Address</label> <input type="text"
                                                      value="<c:out value='${person.address}' />" class="form-control"
                                                      name="address">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Email</label> <input type="text"
                                                    value="<c:out value='${person.email}' />" class="form-control"
                                                    name="email">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Bank Account</label> <input type="text"
                                                           value="<c:out value='${person.bankAccount}' />"
                                                           class="form-control"
                                                           name="bankAccount">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Insurance</label> <input type="text"
                                                        value="<c:out value='${person.insurance}' />"
                                                        class="form-control"
                                                        name="insurance">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>