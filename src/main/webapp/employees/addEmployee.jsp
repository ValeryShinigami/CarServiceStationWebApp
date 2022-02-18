<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Add employee</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<div class="container">
    <h2>Add employee form </h2>
    <h4>${notCompleteDataError}</h4>
    <form action="./add-employee" method="post">
        <div class="form-group">
            <label for="firstNameId">First name:</label>
                <input type="text" name="firstName" placeholder="first name" class="form-control" id="firstNameId">
        </div>
        <div class="form-group">
            <label for="lastNameId">Last name:</label>
                <input type="text" name="lastName" placeholder="last name" class="form-control" id="lastNameId">
        </div>
        <div class="form-group">
            <label for="addressId">Address:</label>
               <input type="text" name="address" placeholder="address" class="form-control" id="addressId">
        </div>
        <div class="form-group">
            <label for="phoneNumberId">Phone Number:</label>
               <input type="text" name="phoneNumber" placeholder="phoneNumber" class="form-control" id="phoneNumberId">
        </div>
        <div class="form-group">
            <label for="remarksId">Remarks:</label>
               <input type="text" name="remarks" placeholder="remarks" class="form-control" id="remarksId">
        </div>
        <div class="form-group">
            <label for="hourlyRateId">Hourly Rate:</label>
               <input type="number" name="hourlyRate" placeholder="hourlyRate" class="form-control" id="hourlyRateId">
        </div>
        <input type="submit" value="Create">
    </form>
</div>
<%@ include file="../fragments/footer.jspf" %>
</body>
</html>