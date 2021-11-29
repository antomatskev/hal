<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HAL project PAYMENT</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: green">
        <div class="navbar-brand">
            <a href="/hal" class="navbar-brand">
                HAL
            </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/listPerson"
                   class="nav-link">Persons</a></li>
            <li><a href="<%=request.getContextPath()%>/listSL"
                   class="nav-link">Sick leaves</a></li>
            <li><a href="<%=request.getContextPath()%>/listPayment"
                   class="nav-link">Payments</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${payment != null}">
            <form action="updatePayment" method="post">
                </c:if>
                <c:if test="${payment == null}">
                <form action="insertPayment" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${payment != null}">
                                Edit Payment
                            </c:if>
                            <c:if test="${payment == null}">
                                Add New Payment
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${payment != null}">
                        <input type="hidden" name="id" value="<c:out value='${payment.id}' />"/>
                    </c:if>


                    <fieldset class="form-group">
                        <label>Person ID</label> <input type="text"
                                                            value="<c:out value='${payment.personId}' />"
                                                            class="form-control"
                                                            name="personId" required="required">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Income</label> <input type="text"
                                                         value="<c:out value='${payment.income}' />"
                                                         class="form-control"
                                                         name="income" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Sum</label> <input type="number"
                                                        value="<c:out value='${payment.sum}' />"
                                                        class="form-control"
                                                        name="sum" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Status</label> <input type="text"
                                                      value="<c:out value='${payment.status}' />" class="form-control"
                                                      name="status">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
<footer style="position: relative;
        right: 0;
        bottom: 0;
        left: 0;
        padding: 1rem;
        background-color: red;
        text-align: center;">
    <div class="navbar-header">
        <a href="/hal" class="navbar-brand">
            <img width="20%"
                 src="https://www.haigekassa.ee/sites/default/files/symboolika/hk_eng_cmyk.jpg">
        </a>
    </div>
</footer>
</body>
</html>