<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
    <h1>Create a New Product</h1>

    <c:if test="${addProductSuccess}">
        <div>Successfully added product #${savedProduct.id}: ${savedProduct.name}</div>
    </c:if>

    <form:form modelAttribute="product" action="/product/create" method="post">
        <div>
            <form:label path="name">Product Name: </form:label>
            <form:input path="name" id="name"/>
        </div>

        <div>
            <form:label path="price">Price: </form:label>
            <form:input path="price" id="price"/>
        </div>

        <div>
            <form:label path="description">Description: </form:label>
            <form:textarea path="description" id="description"></form:textarea>
        </div>

        <button type="submit">Create Product</button>
    </form:form>

    <br/>
    <a href="/products">Back to Product List</a>
</body>
</html>
