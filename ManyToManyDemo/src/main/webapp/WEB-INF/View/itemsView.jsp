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
        .top-right {
            position: absolute;
            top: 0;
            right: 0;
            padding: 10px; /* Add padding for spacing */
        }
    </style>
</head>
<body>
<div class="top-right">
    <form action="/item/add">
        <input type="submit" value="Add New Item">
    </form>
</div>
<div class="button-container">

    <form action="/restaurant/view">
        <input type="submit" value="View Restaurants">
    </form>
    <form action="/item/view">
        <input type="submit" value="View Items">
    </form>
</div><br>
<br>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Category</th>
        <th>Cuisine</th>
        <th>Add New Restaurant</th>
        <th>Add Exist Restaurant</th>
        <th>View Restaurants</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td><c:out value="${item.getName()}"/></td>
            <td><c:out value="${item.getCategory()}"/></td>
            <td><c:out value="${item.getCuisine()}"/></td>
            <td>
                <form action="/item/addNewRestaurant">
                    <input type="hidden" name="itemId" value="${item.getItemID()}">
                    <input type="submit" value="Add New">
                </form>
            </td>
            <td>
                <form action="/item/addExistRestaurant">
                    <input type="hidden" name="itemId" value="${item.getItemID()}">
                    <input type="submit" value="Add Exist">
                </form>
            </td>
            <td>
                <form action="/item/viewItems">
                    <input type="hidden" name="itemId" value="${item.getItemID()}">
                    <input type="submit" value="View">
                </form>
            </td>
            <td>
                <form action="/item/update">
                    <input type="hidden" name="itemId" value="${item.getItemID()}">
                    <input type="submit" value="update">
                </form>
            </td>
            <td>
                <form action="/item/delete">
                    <input type="hidden" name="itemId" value="${item.getItemID()}">
                    <input type="submit" value="delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>