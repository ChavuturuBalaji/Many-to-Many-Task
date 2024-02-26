<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

</head>
<body>
<!DOCTYPE html>

<style>
    .button-container {
        text-align: center;
    }

    .button-container form {
        display: inline-block;
        margin: 0 10px;
    }
</style>
<div class="button-container">
    <form action="/restaurant/view">
        <input type="submit" value="View Restaurants">
    </form>
    <form action="/item/view">
        <input type="submit" value="View Items">
    </form>
</div>

<form:form modelAttribute="itemModel" action="/restaurant/itemadded">
    <table>
        <tr>
            <td>Item Name</td>
            <td><form:input path="name" required="true"/></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><form:input path="category" required="true"/></td>
        </tr>
        <tr>
            <td>Cuisine</td>
            <td><form:input path="cuisine" required="true"/></td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form:form>


</body>
</html>
