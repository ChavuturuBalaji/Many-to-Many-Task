<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .button-container {
            text-align: center;
        }

        .button-container form {
            display: inline-block;
            margin: 0 10px;
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

</div>
<br>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Category</th>
        <th>Cuisine</th>
        <th>Add New Restaurant</th>
        <th>Add Exist Restaurant</th>
        <th>Update Item Details</th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td><c:out value="${item.getName()}"/></td>
            <td><c:out value="${item.getCategory()}"/></td>
            <td><c:out value="${item.getCuisine()}"/></td>
            <td>
                <form action="/restaurant/itemRemove">
                    <input type="hidden" name="itemId" value="${item.getItemID()}">
                    <input type="submit" value="delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
