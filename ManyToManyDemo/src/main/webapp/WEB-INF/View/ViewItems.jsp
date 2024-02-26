<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <style>
        .button-container {
            text-align: center; /* Align buttons to the center */
        }

        .button-container form {
            display: inline-block; /* Make forms display inline */
            margin: 0 10px; /* Add some spacing between buttons */
        }
    </style>
</head>
<body>
<div class="button-container">

    <form action="/restaurant/view">
        <input type="submit" value="View Restaurants">
    </form>
    <form action="/item/view">
        <input type="submit" value="View Items">
    </form>
</div><br>
<br>
<h3>Add items to Restaurant</h3>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Category</th>
        <th>Cusinie</th>
        <th>Add To Restaurant</th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td><c:out value="${item.getName()}"/></td>
            <td><c:out value="${item.getCategory()}"/></td>
            <td><c:out value="${item.getCuisine()}"/></td>
            <td>
                <form action="/restaurant/existItemAdded">
                    <input type="hidden" name="itemId" value="${item.getItemID()}">
                    <input type="submit" value="Add">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>