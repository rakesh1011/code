<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Please search your products based on product id : </h2>
</body>

<form:form action="searchProductById">
<table>
<tr><td>Product Id to search : </td><td><form:input path="productId" /></td></tr>
<tr><td>Product Name : </td><td><form:input path="productName" /></td></tr>
<tr><td>Product Quantity On Hand : </td><td><form:input path="quantityOnHand" /></td></tr>
<tr><td>Product Price : </td><td><form:input path="price" /></td></tr>
<tr>
<td><input type="submit" value="Fetch"></td>
<td><input type="submit" formaction="searchProductByIdForm" value="Reset"></td>
<td><input type="submit" value="Delete" formaction="deleteProductById"></td>

</tr>
</table>
</form:form>

<font color="red">${msg}</font>
</html>