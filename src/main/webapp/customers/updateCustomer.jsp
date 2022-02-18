<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Update customer</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<div class="container">
    <h2>Update customer form </h2>
    <h4>${notCompleteDataError}</h4>
    <form action="./update-customer?id=${customer.id}" method="post">
        <div class="form-group">
            <label for="firstNameId">First name:</label>
               <input type="text" name="firstName" value="${customer.firstName}"   placeholder="first name" class="form-control" id="firstNameId">    
        </div>
        <div class="form-group">
            <label for="lastNameId">Last name:</label>
                <input type="text" name="lastName" value="${customer.lastName}"   placeholder="last name" class="form-control" id="lastNameId">
        </div>
        <div class="form-group">
            <label for="birthDateId">Birth day:</label>
               <input type="date" name="birthDate" value="${customer.birthDate}"   placeholder="birth date" class="form-control" id="birthDateId">
            </label> <br><br>
        </div>
        <input type="submit" value="Update">
    </form>
</div>
<%@ include file="../fragments/footer.jspf" %>
</body>
</html>