<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="f"  uri="http://www.springframework.org/tags/form"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  i18n, Errors, Themes - Spring MVC Forms -->
<h2>Please fill the product details :</h2>

<f:form action="saveProduct" >
Product Id : <f:input  path="productId" /><br/>
Product Name : <f:input  path="productName" /><br/>
Quantity : <f:input  path="quantityOnHand" /><br/>
Price: <f:input  path="price" /><br/>

<input type="submit" value="Save Product">
</f:form>

</body>
</html>


<!-- 
<form action="saveProduct">
Product Id : <input type="text" name="productId"><br/>
Product Name : <input type="text" name="productName"><br/>
Quantity : <input type="text" name="quantityOnHand"><br/>
Price: <input type="text" name="price"><br/>

<input type="submit" value="Save Product">
</form>
 -->