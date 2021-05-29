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
	<h2>View All Cart Product Details</h2>
	<table border="10" cellspacing="10" cellspacing="10" align="center">
		<tbody>
			<c:forEach var="item" items="${cartItems}">
				<tr>
					<td>${item.cartProductId}</td>
					<td>${item.cartProductName}</td>
					<td>${item.cartQuantityOnHand}</td>
					<td>${item.price}</td>
					<td><a href="/Delete/${item.cartProductId}">Delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>