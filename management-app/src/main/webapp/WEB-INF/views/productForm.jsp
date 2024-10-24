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

<%--    <c:if test="${addProductSuccess}">--%>
<%--        <div>Successfully added product: ${savedProduct.name}</div>--%>
<%--    </c:if>--%>

    <form:form modelAttribute="product" action="${pageContext.request.contextPath}/products" method="post">
            <form:label path="name">Product Name: </form:label>
            <form:input path="name" id="name" />
        <div>
            <label for="price">Price:</label>
            <form:input path="price" id="price" />
        </div>
        <div>
            <label for="description">Description:</label>
            <form:textarea path="description" id="description"></form:textarea>
        </div>
        <div>
            <button type="submit">Create Product</button>
        </div>
    </form:form>
</body>
</html>
