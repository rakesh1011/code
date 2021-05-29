<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="f"  uri="http://www.springframework.org/tags/form"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome to cart App</title>
</head>
<body>
<h2>Your product with product ${productId} successfully added to the cart</h2>





Product ID : ${productId}
Product Name : ${product.productName}
Quality On Hand :${product.quantityOnHand}
Price : ${product.price}





<!--  Cart table  -->
</body>
</html>