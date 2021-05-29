<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Product Details</h2>
	<table border="10" cellspacing="10" cellspacing="10" align="center">
		<tbody>
			<c:forEach var="item" items="${products}">
				<tr>
					<td>${item.productId}</td>
					<td>${item.productName}</td>
					<td>${item.quantityOnHand}</td>
					<td>${item.price}</td>
					<td><a href="/cart/${item.productId}">Add To Cart</a></td>
					<td><a href="/delete/${item.productId}">Delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>